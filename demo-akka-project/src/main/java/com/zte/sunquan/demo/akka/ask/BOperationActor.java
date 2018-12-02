package com.zte.sunquan.demo.akka.ask;

import akka.actor.AbstractActor;
import akka.actor.Props;

/**
 * Created by 10184538 on 2018/6/2.
 */
public class BOperationActor extends AbstractActor {
    public static Props props() {
        return Props.create(BOperationActor.class);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(Message.class, p -> p.getId() == 1, p -> {
            //模拟B业务对于消息的响应，将消息转成大写,返回
            p.setMsg(p.getMsg().toUpperCase());//需要注意是这里对消息进行了修改并返回，原则应保证消息的不可变
            getSender().tell(p, getSelf());

        }).match(Message.class, p -> p.getId() == 2, p -> {
            //模拟A业务对于消息的响应，将消息打上时间戳，返回
            getSender().tell(p.getId() + "B", getSelf());

        }).matchAny(p -> {
            getSender().tell("hello,world,BOperationActor", getSelf());
        })
                .build();
    }
}
