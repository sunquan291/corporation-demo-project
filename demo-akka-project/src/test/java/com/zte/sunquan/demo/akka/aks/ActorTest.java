package com.zte.sunquan.demo.akka.aks;

import java.util.concurrent.TimeUnit;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import org.junit.Test;

import com.zte.sunquan.demo.akka.ask.Message;
import com.zte.sunquan.demo.akka.ask.MessageHandlerActor;

/**
 * Created by 10184538 on 2018/6/2.
 */
public class ActorTest {

    @Test
    public void testAsk() throws InterruptedException {

        ActorSystem system = ActorSystem.create("ask-test");
        ActorRef messageHandlerActor = system.actorOf(MessageHandlerActor.props());
        Message msg = new Message();
        msg.setId(1L);
        msg.setMsg("hello,world");
        messageHandlerActor.tell(msg, ActorRef.noSender());

        TimeUnit.SECONDS.sleep(10);
    }

    @Test
    public void testAsk2() throws InterruptedException {

        ActorSystem system = ActorSystem.create("ask-test");
        ActorRef messageHandlerActor = system.actorOf(MessageHandlerActor.props());
        Message msg = new Message();
        msg.setId(2L);
        msg.setMsg("hello,world");
        messageHandlerActor.tell(msg, ActorRef.noSender());

        TimeUnit.SECONDS.sleep(10);
    }

    @Test
    public void testAsk3() throws InterruptedException {

        ActorSystem system = ActorSystem.create("ask-test");
        ActorRef messageHandlerActor = system.actorOf(MessageHandlerActor.props());
        Message msg = new Message();
        msg.setId(3L);
        msg.setMsg("hello,world");
        messageHandlerActor.tell(msg, ActorRef.noSender());

        TimeUnit.SECONDS.sleep(10);
    }
    @Test
    public void testAsk4() throws InterruptedException {

        ActorSystem system = ActorSystem.create("ask-test");
        ActorRef messageHandlerActor = system.actorOf(MessageHandlerActor.props());
        Message msg = new Message();
        msg.setId(4L);
        msg.setMsg("hello,world");
        messageHandlerActor.tell(msg, ActorRef.noSender());

        TimeUnit.SECONDS.sleep(10);
    }
}
