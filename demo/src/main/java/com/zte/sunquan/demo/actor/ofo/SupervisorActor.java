package com.zte.sunquan.demo.actor.ofo;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.OneForOneStrategy;
import akka.actor.SupervisorStrategy;
import akka.actor.SupervisorStrategy.Directive;
import akka.japi.Function;
import java.util.Optional;
import scala.concurrent.duration.Duration;

import static akka.actor.SupervisorStrategy.escalate;
import static akka.actor.SupervisorStrategy.restart;
import static akka.actor.SupervisorStrategy.resume;
import static akka.actor.SupervisorStrategy.stop;


public class SupervisorActor extends AbstractActor {

    public ActorRef childActor;//子actor，异常在子actor抛出

    public SupervisorActor() {
        childActor = getContext().actorOf(WorkerActor.props(),
                "workerActor");
    }
    @Override
    public void preStart() {
        System.out.println("abc");
    }

    @Override
    public void preRestart(Throwable reason, Optional<Object> message) throws Exception {
        super.preRestart(reason, message);
        System.out.println("789");

    }

    @Override
    public void postStop() {
        System.out.println("123");
    }

    //这里我们对重启的频率作了限制，最多5能进行 3 次重启
    private static SupervisorStrategy strategy = new OneForOneStrategy(3,
            Duration.create("5 second"), new Function<Throwable, Directive>() {
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
        return receiveBuilder().match(Result.class, p -> {
            childActor.tell(p, getSender());
        }).matchAny(p -> {
            childActor.tell(p, ActorRef.noSender());
        })
                .build();
    }
}
