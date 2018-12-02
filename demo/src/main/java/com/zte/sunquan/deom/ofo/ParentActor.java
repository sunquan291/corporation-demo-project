package com.zte.sunquan.deom.ofo;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import java.util.Optional;

/**
 * Created by sunquan on 2018/3/29.
 */
public class ParentActor extends AbstractActor {
    private String name;
    private ActorRef c1;
    public ParentActor(String name) {
        this.name = name;
    }

    public ParentActor() {
         c1 = getContext().actorOf(ChildActor.props("c1"), "c1");
        ActorRef c2 = getContext().actorOf(ChildActor.props("c2"), "c2");
    }

    public static Props props() {
        return Props.create(ParentActor.class);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("killc1",p->{
                    getContext().stop(c1);
//                    Thread.sleep(5000);
                    Optional<ActorRef> c1 = getContext().findChild("c1");
                    System.out.println("c1...."+ c1.get());
                    System.out.println("c1111"+c1.get().isTerminated());
                    getContext().actorOf(ChildActor.props("c1"),"c1");


                })
                .matchAny(p -> {
            System.out.println("parent:" + p);
        }).build();
    }

    @Override
    public void preStart() throws Exception {
        super.preStart();
        System.out.println("parent pre start");
    }

    @Override
    public void postStop() throws Exception {
        super.postStop();
        System.out.println("parent pre stop");
    }

    @Override
    public void preRestart(Throwable reason, Optional<Object> message) throws Exception {
        super.preRestart(reason, message);
        System.out.println("parent pre reStart2");
    }

    @Override
    public void postRestart(Throwable reason) throws Exception {
        super.postRestart(reason);
        System.out.println("parent pre reStart1");
    }
}
