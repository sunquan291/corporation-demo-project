package com.zte.sunquan.demo.actor.cluster;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Terminated;

import java.util.ArrayList;
import java.util.List;

import static com.zte.sunquan.demo.actor.cluster.TransformationMessages.BACKEND_REGISTRATION;

/**
 * Created by 10184538 on 2017/10/10.
 */
public class TransformationFrontend extends AbstractActor {

    private List<ActorRef> backends = new ArrayList<ActorRef>();
    private int jobCounter = 0;

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(TransformationMessages.TransformationJob.class, p -> {
            if (backends.isEmpty()) {
                getSender().tell(
                        new TransformationMessages.JobFailed("Service unavailable, try again later", p),
                        getSender());
            } else {
                jobCounter++;
                backends.get(jobCounter % backends.size()).forward(p, getContext());
                System.out.println(backends.size());
            }
        }).match(String.class, BACKEND_REGISTRATION::equals, p -> {
            getContext().watch(getSender());//??
            backends.add(getSender());
            System.out.println("backends add : "+getSender());
        }).match(Terminated.class, p -> {
            backends.remove(p.getActor());
        })
                .build();
    }
}
