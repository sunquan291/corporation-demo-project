package com.zte.sunquan.demo.typeactor;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.TypedActor;
import akka.dispatch.OnComplete;
import org.junit.Before;
import org.junit.Test;
import scala.concurrent.Future;

/**
 * Created by 10184538 on 2018/1/2.
 */
public class TestTypedActors {

    private ActorSystem system;
    private Squarer defaultSquare;
    private Squarer sqSquare;

    @Before
    public void init() {
        //Actor工厂
        TypedActorsFactory factory = new TypedActorsFactory("typedServer");
        system = factory.system;
        //创建代理
        defaultSquare = factory.getTypedActorDefault();
        sqSquare = factory.getTypedActor("sunquan");
    }

    @Test
    public void testA() {
        sqSquare.squareDontCare(10);
    }

    @Test
    public void testB() {
        Future future = sqSquare.square(10);
        future.onComplete(new OnComplete<Integer>() {
            @Override
            public void onComplete(Throwable throwable, Integer integer) throws Throwable {
                if (throwable == null)
                    System.out.println("Get result:" + integer);
                else
                    System.out.println("ERROR:"+throwable.getMessage());
            }
        }, system.dispatcher());
    }

    @Test
    public void testC() {
        Future future = sqSquare.square(10);
        ActorRef printActor = system.actorOf(Props.create(PrintActor.class), "printActor");
        //Future的返回结果pipe到接收器中
        akka.pattern.Patterns.pipe(future, system.dispatcher())
                .to(printActor);

    }

    @Test
    public void testD() {
        System.out.println(sqSquare.squareNowPlease(10).get());
        System.out.println(sqSquare.squareNow(10));
    }

    @Test
    public void testE() {
        ActorRef actorRefFor = TypedActor.get(system).getActorRefFor(sqSquare);
        System.out.println(TypedActor.get(system).isTypedActor(sqSquare));
        System.out.println(TypedActor.get(system).isTypedActor(actorRefFor));
        //这个消息将会在SquarerImpl的onReceive方法中接收到
        actorRefFor.tell("Message", ActorRef.noSender());
    }

    @Test
    public void testF() throws InterruptedException {
        //这将会尽快地异步终止与指定的代理关联的有类型Actor
        TypedActor.get(system).stop(sqSquare);
        Thread.sleep(1000);
        System.out.println(TypedActor.get(system).getActorRefFor(sqSquare).isTerminated());
    }

    @Test
    public void testG() throws InterruptedException {
        //这将会在有类型actor完成所有在当前调用之前对它的调用后异步地终止它
        TypedActor.get(system).poisonPill(sqSquare);
        Thread.sleep(1000);
        System.out.println(TypedActor.get(system).getActorRefFor(sqSquare).isTerminated());
    }

    @Test
    public void testRemote() throws InterruptedException {
        //注意akka.tcp(akka.tcp://Remote端ActorSystem的名字@Remote端配置的IP:Remote端配置的端口号/user/Remote端的Actor名字)
        ActorSelection actorSelection = system.actorSelection("akka.tcp://typedServer@127.0.0.1:2552/user/sunquan");
        System.out.println(actorSelection.anchor().isTerminated());
        actorSelection.tell("Remote Message", ActorRef.noSender());
        Thread.sleep(1000);
    }
}
