package com.zte.sunquan.demo.actor.ofo;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class WorkerActor extends AbstractActor {
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    private int state = 0;

    public static Props props() {
        return Props.create(WorkerActor.class);
    }

    @Override
    public void preStart() {
        log.info("Starting WorkerActor instance hashcode # {}", this.hashCode());
    }

    @Override
    public void postStop() {
        log.info("Stopping WorkerActor instance hashcode # {}", this.hashCode());

    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(String.class, p -> {
            throw new NullPointerException("Null Value Passed");
        }).match(Integer.class, p -> {
            if (p <= 0) {
                throw new ArithmeticException("Number equal or less than zero");
            } else
                state = p;
        }).match(Result.class, p -> {
            getSender().tell(state, ActorRef.noSender());
        }).matchAny(p -> {
            throw new IllegalArgumentException("Wrong Argument");
        })
                .build();
    }
}
