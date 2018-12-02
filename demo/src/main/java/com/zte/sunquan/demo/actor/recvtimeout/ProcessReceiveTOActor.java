package com.zte.sunquan.demo.actor.recvtimeout;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.actor.ReceiveTimeout;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * Created by 10184538 on 2017/10/10.
 */
public class ProcessReceiveTOActor extends AbstractActor {
    //receive time out是指最多允许多长时间 该actor无消息接收，即空闲
    public ProcessReceiveTOActor() {
        getContext().setReceiveTimeout(scala.concurrent.duration.Duration.apply(10, TimeUnit.SECONDS));
    }
    public static Props props() {
        return Props.create(ProcessReceiveTOActor.class);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, "Hello,world"::equals, s -> {
                    getSender().tell("get message " + s, getSelf());
                })
                .match(ReceiveTimeout.class, p -> {
                    System.out.println("receive time out."+ Instant.now());
//                    getContext().setReceiveTimeout(Duration.Undefined());
//                    throw new RuntimeException("received timeout");
                })
                .build();
    }
}
