package com.zte.sunquan.demo.actor.supervison;

import akka.actor.AbstractActor;
import akka.actor.Props;
import scala.Option;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 10184538 on 2017/10/31.
 */
public class Actor2 extends AbstractActor {
    String name;
    int index;
    private static AtomicInteger atomicInteger = new AtomicInteger();
    public Actor2(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static Props props() {
        return Props.create(Actor2.class,"actor2",atomicInteger.getAndIncrement());
    }

    @Override
    public void preRestart(Throwable reason, Option<Object> message)
            throws Exception {
        // TODO Auto-generated method stub
        System.out.println(name + "_" + index + " restart");
        super.preRestart(reason, message);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().matchAny(p -> {
            System.out.println(name + "_" + index + " receive message "+p);
            // 当获得到的随机数大于0.99的时候抛出异常
            if (Math.random() > 0.96) {
                System.out.println("trriger exception "+name+" ,"+index);
                throw new Exception("user exception");
            }
        }).build();
    }
}
