package com.zte.sunquan.deom.ofo;

import akka.actor.AbstractActor;
import akka.actor.Props;
import java.util.Optional;

/**
 * Created by sunquan on 2018/3/29.
 */
public class ChildActor extends AbstractActor {
    private String name;

    public ChildActor() {

    }

    public ChildActor(String name) {
        this.name = name;
    }

    public static Props props(String name) {
        return Props.create(ChildActor.class,name);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchAny(p -> {
            System.out.println("child:" + p);
        })
                .build();
    }

    @Override
    public void preStart() throws Exception {
        super.preStart();
        System.out.println("child " + name + " pre start");
    }

    @Override
    public void postStop() throws Exception {
        super.postStop();
        System.out.println("child " + name + " pre stop");
    }

    @Override
    public void preRestart(Throwable reason, Optional<Object> message) throws Exception {
        super.preRestart(reason, message);
        System.out.println("child " + name + " pre reStart1");
    }

    @Override
    public void postRestart(Throwable reason) throws Exception {
        super.postRestart(reason);
        System.out.println("child " + name + " pre reStart2");
    }
}
