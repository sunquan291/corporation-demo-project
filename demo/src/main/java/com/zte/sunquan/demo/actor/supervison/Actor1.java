package com.zte.sunquan.demo.actor.supervison;

import akka.actor.AbstractActor;
import akka.actor.ActorKilledException;
import akka.actor.ActorRef;
import akka.actor.OneForOneStrategy;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;
import akka.actor.Terminated;
import scala.concurrent.duration.Duration;

import static akka.actor.SupervisorStrategy.escalate;
import static akka.actor.SupervisorStrategy.restart;
import static akka.actor.SupervisorStrategy.stop;

/**
 * Created by 10184538 on 2017/10/31.
 */
public class Actor1 extends AbstractActor {

    private static final int COUNT = 10;
    private ActorRef[] actors = new ActorRef[COUNT];
    private int count;

    public static Props props() {
        return Props.create(Actor1.class);
    }

    private static SupervisorStrategy strategy = new OneForOneStrategy(-1,
            Duration.Inf(),
            throwable -> {
                System.out.println("throwable:" + throwable);
                if (throwable instanceof Exception) {
                    return restart();
                } else
                    return escalate();

            });

    @Override
    public SupervisorStrategy supervisorStrategy() {
        return strategy;
    }

    @Override
    public void preStart() throws Exception {
        super.preStart();
        for (int i = 0; i < COUNT; i++) {
            actors[i] = getContext().actorOf(Actor2.props());
            getContext().watch(actors[i]);
        }
        getSelf().tell("Start", getSelf());
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().matchEquals("Start", p -> {
            System.out.println("****START****");
            actors[(int) (Math.random() * 10)].tell("Hi", getSelf());
            self().tell("Goon", self());
        }).matchEquals("Goon", p -> {
            actors[(int) (Math.random() * 10)].tell("Hi", getSelf());
            self().tell("Goon", self());
            System.out.println(count);
            if (++count == 300) {
                throw new ActorKilledException("Teminate all actor!");
            }
        }).match(Terminated.class, p -> {
            System.out.println(getSender() + " terminate");
        })
                .build();
    }
}
