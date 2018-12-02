package com.zte.sunquan.demo.akka.ask;

import java.util.Date;

import akka.actor.AbstractActor;
import akka.actor.Props;

/**
 * Created by 10184538 on 2018/6/2.
 */
public class AOperationActor extends AbstractActor {

    public static Props props() {
        return Props.create(AOperationActor.class);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(Message.class,p->p.getId()==1, p -> {
            //模拟A业务对于消息的响应，将消息打上时间戳，返回
            p.setMsg(p.getMsg() + ":" + new Date(System.currentTimeMillis()));
            getSender().tell(p, getSelf());

        }).match(Message.class,p->p.getId()==2, p -> {
            Thread.sleep(2000);
            //模拟A业务对于消息的响应，将消息打上时间戳，返回
            getSender().tell(p.getId()+"A", getSelf());

        }).matchAny(p -> {
            Thread.sleep(2000);
            getSender().tell("hello,world,AOperationActor", getSelf());
        })
                .build();
    }
}
