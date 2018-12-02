package com.zte.sunquan.demo.actor.supervison1;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.event.Logging;
import akka.event.LoggingAdapter;

import java.util.Optional;

public class WorkerActor extends AbstractActor {
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    private int state = 0;

    @Override
    public void preStart() {
        log.info("Starting WorkerActor instance hashcode # {}", this.hashCode());
    }

    @Override
    public void preRestart(Throwable reason, Optional<Object> message) throws Exception {
        log.info("reStarting WorkerActor");
        super.preRestart(reason, message);
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
        }).match(MyActorSystem.Result.class, p -> {
            getSender().tell(state, ActorRef.noSender());
        }).matchAny(p -> {
            throw new IllegalArgumentException("Wrong Argument");
        })
                .build();
    }
}
