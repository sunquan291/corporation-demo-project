package com.zte.sunquan.demo.actor.ask;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

import java.util.concurrent.TimeUnit;

/**
 * Created by 10184538 on 2017/9/18.
 */
public class ProcessSub2Actor extends AbstractActor {
    public static Props props() {
        return Props.create(ProcessSub2Actor.class);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(Message.class,(content)->{
            System.out.println("ProcessSub2Actor process:"+content);
//            TimeUnit.SECONDS.sleep(4);
            getSender().tell("ProcessSub2Actor result:"+content, ActorRef.noSender());

        }).build();
    }
}
