package com.zte.sunquan.demo.typeactor;

import akka.actor.ActorContext;
import akka.actor.ActorRef;
import akka.actor.TypedActor;
import akka.dispatch.Futures;
import akka.japi.Option;
import scala.concurrent.Future;
import scala.concurrent.Promise;

/**
 * Created by 10184538 on 2018/1/2.
 */
public class SquarerImpl implements Squarer, akka.actor.TypedActor.Receiver {
    private String name;

    public SquarerImpl() {
        this.name = "default";
    }

    public SquarerImpl(String name) {
        this.name = name;
    }

    @Override
    public void onReceive(Object o, ActorRef actorRef) {
        System.out.println("TypedActor收到消息----" + o + "---from:" + actorRef);
    }

    @Override
    public void squareDontCare(int i) {
        System.out.println("squareDontCare:fire-and-forget只接收不返回结果，与ActorRef.tell完全一致----" + i + "," + currentThreadName());  //可以从线程号看出是异步处理的
        int sq = i * i; //Nobody cares :(
        //返回当前的ActorContext,
        // 此方法仅在一个TypedActor 实现的方法中有效
        ActorContext context = TypedActor.context();
        System.out.println("context:" + context);

        //返回当前有类型actor的外部代理,
        // 此方法仅在一个TypedActor 实现的方法中有效
        Squarer mysq = TypedActor.<Squarer>self();
        System.out.println("self:" + mysq);
    }

    @Override
    public Future<Integer> square(int i) {
        System.out.println("square:返回feature" + i + "," + currentThreadName());
        Promise<Integer> promise = Futures.promise();
        return promise.future();
//        return Futures.successful(i * i);
    }

    @Override
    public Option<Integer> squareNowPlease(int i) {
        System.out.println("squareNowPlease:返回option" + i + "," + currentThreadName());
        return Option.some(i * i);
    }

    @Override
    public int squareNow(int i) {
        System.out.println("squareNow:返回int" + i + "," + currentThreadName());
        return i * i;
    }
}
