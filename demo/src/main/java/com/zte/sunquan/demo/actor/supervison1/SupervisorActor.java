package com.zte.sunquan.demo.actor.supervison1;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.OneForOneStrategy;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;
import akka.actor.SupervisorStrategy.Directive;
import akka.japi.Function;
import scala.concurrent.duration.Duration;

import static akka.actor.SupervisorStrategy.escalate;
import static akka.actor.SupervisorStrategy.restart;
import static akka.actor.SupervisorStrategy.resume;
import static akka.actor.SupervisorStrategy.stop;


public class SupervisorActor extends AbstractActor {

    public ActorRef childActor;//子actor

    public SupervisorActor() {
        childActor = getContext().actorOf(Props.create(WorkerActor.class));
    }

    private static SupervisorStrategy strategy = new OneForOneStrategy(10,
            Duration.create("10 second"), new Function<Throwable, Directive>() {
        public Directive apply(Throwable t) {
            if (t instanceof ArithmeticException) {
                return resume();
            } else if (t instanceof NullPointerException) {
                return restart();
            } else if (t instanceof IllegalArgumentException) {
                return stop();
            } else {
                return escalate();
            }
        }
    });

    @Override
    public SupervisorStrategy supervisorStrategy() {
        return strategy;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(MyActorSystem.Result.class, p -> {
            childActor.tell(p, getSender());
        }).matchAny(p -> {
            childActor.tell(p, ActorRef.noSender());
        })
                .build();
    }
}
