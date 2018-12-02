package com.zte.sunquan.demo.typeactor;

import akka.actor.AbstractActor;

/**
 * Created by 10184538 on 2018/1/2.
 */
public class PrintActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder().matchAny(p->{
            System.out.println("printActor--->"+p);
        }).build();
    }
}
