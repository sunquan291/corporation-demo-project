package com.zte.sunquan.demo.actor.java8;

import static akka.pattern.Patterns.ask;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.CountDownLatch;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.dispatch.Mapper;
import akka.dispatch.OnComplete;
import akka.dispatch.OnFailure;
import akka.dispatch.OnSuccess;
import akka.dispatch.Recover;
import org.junit.Test;
import scala.collection.parallel.ParIterableLike;
import scala.compat.java8.FutureConverters;
import scala.concurrent.Future;

/**
 * Created by 10184538 on 2017/12/25.
 */
public class TransTest {

    @Test
    public void testStop() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        ActorSystem system = ActorSystem.create("test");
        ActorRef helloGreeter = system.actorOf(PrintActor.props());
        //system.stop(helloGreeter);
        helloGreeter = system.actorOf(PrintActor.props());
        latch.await();
    }

    @Test
    public void testGreeterActorSendingOfGreeting3() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        ActorSystem system = ActorSystem.create("test");
        final ActorRef helloGreeter = system.actorOf(PrintActor.props());
        Future<Object> ask = ask(helloGreeter, "heel,world", 2000);
        //scala
        ask.onComplete(new OnComplete<Object>() {
            @Override
            public void onComplete(Throwable throwable, Object o) throws Throwable {

            }
        }, system.dispatcher());
        latch.await();

    }

    @Test
    public void testGreeterActorSendingOfGreeting4() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        ActorSystem system = ActorSystem.create("test");
        final ActorRef helloGreeter = system.actorOf(PrintActor.props());
        Future<Object> ask = ask(helloGreeter, "heel,world", 2000);
        CompletionStage<Object> future = FutureConverters.toJava(ask);
        future.whenComplete((t, e) -> {
        });
        ask.onComplete(new OnComplete<Object>() {
            @Override
            public void onComplete(Throwable throwable, Object o) throws Throwable {

            }
        }, system.dispatcher());
        latch.await();
    }

    @Test
    public void testCompose() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        ActorSystem system = ActorSystem.create("test");
        final ActorRef helloGreeter = system.actorOf(PrintActor.props());
        Future<Object> ask = ask(helloGreeter, "heel,world", 2000);
        ask.onSuccess(new OnSuccess<Object>() {
            @Override
            public void onSuccess(Object o) throws Throwable {
                System.out.println("Success:" + o);
            }
        }, system.dispatcher());

        ask.onFailure(new OnFailure() {
            @Override
            public void onFailure(Throwable throwable) throws Throwable {
                System.out.println("Failure:" + throwable);
            }
        },system.dispatcher());

        ask.map(new Mapper<Object, Object>() {

        }, system.dispatcher());

//        ask.flatMap(new ParIterableLike.FlatMap<>(){},system.dispatcher());

        ask.recover(new Recover<Object>() {
            @Override
            public Object recover(Throwable throwable) throws Throwable {
                return null;
            }
        }, system.dispatcher());

//        ask.recoverWith(, system.dispatcher());

        latch.await();
    }
}
