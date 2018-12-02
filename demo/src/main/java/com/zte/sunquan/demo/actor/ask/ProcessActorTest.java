package com.zte.sunquan.demo.actor.ask;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import akka.actor.ActorIdentity;
import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Identify;
import akka.dispatch.Mapper;
import akka.dispatch.OnComplete;
import akka.pattern.Patterns;
import akka.util.Timeout;
import org.junit.Test;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

/**
 * Created by 10184538 on 2017/10/10.
 */
public class ProcessActorTest {

    @Test
    public void startMessageTest() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        Timeout t = new Timeout(Duration.create(5, TimeUnit.SECONDS));
        ActorSystem system = ActorSystem.create();
        ActorRef myActor = system.actorOf(ProcessActor.props());
        ActorRef printActor = system.actorOf(PrintActor.props());
//        myActor.tell(new Message(), printActor);
        myActor.tell(new Message(), ActorRef.noSender());
        latch.await();
    }

    @Test
    public void startMessageTest2() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        Timeout t = new Timeout(Duration.create(5, TimeUnit.SECONDS));
        ActorSystem system = ActorSystem.create();
//        ActorRef myActor = system.actorOf(ProcessActor.props(),"sq");
        ActorRef printActor = system.actorOf(PrintActor.props());
//        myActor.tell(new Message(), printActor);
        Identify identify = new Identify("is sq actor exist");
        //注意actorSelection不保证对应actor存在
        ActorSelection actorSelection = system.actorSelection("akka://default/user/sq");
        //这行不管如何，始终都是会进行发送的，不存在时，会进行dead-letter
        actorExistAsynHandle(actorSelection,system,new Message());
        latch.await();
    }


    private void actorExistAsynHandle(ActorSelection actorSelection, ActorSystem system, Object msg) {
        Identify identify = new Identify("detect actor whether exist or not");
        Future<Object> ask = Patterns.ask(actorSelection, identify, 5000);
        ask.onComplete(new OnComplete<Object>() {
            @Override
            public void onComplete(Throwable throwable, Object s) throws Throwable {
                System.out.println("OnComplete:"+Thread.currentThread().getName());
                ActorIdentity identity = (ActorIdentity) s;
                if (identity.getActorRef().isPresent()) {
                    identity.getActorRef().get().tell(msg, ActorRef.noSender());
                }else {
                    System.out.println(actorSelection+" not exist");
                }
            }
        }, system.dispatcher());
    }

    @Test
    public void startTest() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        Timeout t = new Timeout(Duration.create(5, TimeUnit.SECONDS));
        ActorSystem system = ActorSystem.create();
        ActorRef myActor = system.actorOf(ProcessActor.props());

        //使用ask发送消息,actor处理完，必须有返回（超时时间5秒）
        Future<Object> ask = Patterns.ask(myActor, "Hello,world", t);

        ask.onComplete(new OnComplete<Object>() {
            @Override
            public void onComplete(Throwable throwable, Object o) throws Throwable {
                if (throwable != null) {
                    //如果处理延迟大于ask参数
                    //akka.pattern.AskTimeoutException:
                    // Ask timed out on [Actor[akka://default/user/$a#2060184193]] after [5000 ms].
                    // Sender[null] sent message of type "java.lang.String".
                    // 从上一句话判断，处理函数一定要将string传递
                    System.out.println(throwable);

                } else {
                    System.out.println(o);
                }
            }
        }, system.dispatcher());

        //对结果进行取map (无法处理异常)
        ask.map(new Mapper<Object, Object>() {
            @Override
            public Object apply(Object o) {
                System.out.println("apply ask:" + o);
                return "end";
            }
        }, system.dispatcher());
//        System.out.println(ask.value().get().get());
        latch.await();
    }
}
