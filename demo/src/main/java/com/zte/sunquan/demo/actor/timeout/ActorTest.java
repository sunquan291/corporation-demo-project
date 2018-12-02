package com.zte.sunquan.demo.actor.timeout;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * Created by 10184538 on 2017/9/30.
 */
public class ActorTest {
    private ActorSystem system;
    @Before
    public void init(){
        system=ActorSystem.create("test-sq");
    }
    @Test
    public void testActor() throws InterruptedException {
        CountDownLatch latch=new CountDownLatch(1);
        ActorRef printActor = system.actorOf(PrintActor.props());
        ActorRef calActor = system.actorOf(CalculatorActor.props());
        calActor.tell("+1",printActor);
        latch.await();
    }
}
