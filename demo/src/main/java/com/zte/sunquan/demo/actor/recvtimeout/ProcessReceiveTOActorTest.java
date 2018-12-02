package com.zte.sunquan.demo.actor.recvtimeout;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.zte.sunquan.demo.actor.ask.PrintActor;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * Created by 10184538 on 2017/9/22.
 */
public class ProcessReceiveTOActorTest {
    @Test
    public void startTest() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        ActorSystem system = ActorSystem.create();
        ActorRef actorRef = system.actorOf(ProcessReceiveTOActor.props());
        ActorRef printActor = system.actorOf(PrintActor.props());
        actorRef.tell("Hello,world", printActor);
        latch.await();
    }
}
