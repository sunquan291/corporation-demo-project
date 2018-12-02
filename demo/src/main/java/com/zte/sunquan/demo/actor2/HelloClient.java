package com.zte.sunquan.demo.actor2;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;


/**
 * Created by 10184538 on 2017/6/3.
 */
public class HelloClient implements Runnable{

    private int seq;
    private String serviceName;
    final ActorSystem system = ActorSystem.create("helloakka");
    public HelloClient(int seq, String serviceName) {
        this.seq = seq;
        this.serviceName = serviceName;
    }

    @Override
    public void run() {
        ActorRef actor=system.actorOf(null);
    }
}
