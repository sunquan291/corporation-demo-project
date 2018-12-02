package com.zte.sunquan.demo.actor.java8;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.actor.ReceiveTimeout;

import java.time.Instant;

/**
 * Created by 10184538 on 2017/9/19.
 */
public class PrintActor extends AbstractActor {
    public static Props props(){
        return Props.create(PrintActor.class);
    }
    @Override
    public Receive createReceive() {
        return receiveBuilder().match(String.class,
                s -> {
                    System.out.println(s + ":" + Instant.now());
                })
                .match(ReceiveTimeout.class, t ->
                        System.out.println("ReceiveTimeout")
                ).match(Throwable.class, t ->
                                System.out.println("Throwable")
//                        breaker.fail()
                )
                .build();
    }

}
