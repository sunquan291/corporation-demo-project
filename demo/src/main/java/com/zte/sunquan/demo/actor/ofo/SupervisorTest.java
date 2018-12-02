package com.zte.sunquan.demo.actor.ofo;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.Terminated;
import akka.pattern.Patterns;
import akka.testkit.TestActorRef;
import akka.testkit.TestKit;
import akka.testkit.TestProbe;
import org.junit.Test;
import scala.concurrent.Await;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

public class SupervisorTest extends TestKit {
    static ActorSystem _system = ActorSystem.create("faultTolerance");
    TestActorRef<SupervisorActor> supervisor = TestActorRef
            .apply(Props.create(SupervisorActor.class), _system);

    public SupervisorTest() {
        super(_system);
        supervisor.tell(Integer.valueOf(8), ActorRef.noSender());
    }

    @Test
    public void successTest() throws Exception {
        //正数
        supervisor.tell(Integer.valueOf(8), ActorRef.noSender());
        Integer result = (Integer) Await.result(
                Patterns.ask(supervisor, new Result(), 5000),
                Duration.create(5000, TimeUnit.MILLISECONDS));
        assert result.equals(Integer.valueOf(8));
    }

    @Test
    public void resumeTest() throws Exception {
        TestActorRef<SupervisorActor> supervisor = TestActorRef.apply(
                Props.create(SupervisorActor.class), _system);
        //first send a correct message
        supervisor.tell(Integer.valueOf(8), ActorRef.noSender());
        //Send a  message that generates exception  ArithmeticException
        supervisor.tell(Integer.valueOf(-8), ActorRef.noSender());

        Integer result = (Integer) Await.result(
                Patterns.ask(supervisor, new Result(), 5000),
                Duration.create(5000, TimeUnit.MILLISECONDS));

        assert result.equals(Integer.valueOf(8));
    }

    @Test
    public void restartTest() throws Exception {
        supervisor.tell("null", ActorRef.noSender());

        Integer result = (Integer) Await.result(
                Patterns.ask(supervisor, new Result(), 5000),
                Duration.create(5000, TimeUnit.MILLISECONDS));

        assert result.equals(Integer.valueOf(0));
    }

    @Test
    public void restartTestInMaxRetry() throws Exception {
        supervisor.tell("null", ActorRef.noSender());

        Integer result = (Integer) Await.result(
                Patterns.ask(supervisor, new Result(), 5000),
                Duration.create(5000, TimeUnit.MILLISECONDS));

        assert result.equals(Integer.valueOf(0));

        //由oneforone的创建参数，5s内只允许3次重启
        supervisor.tell("null", ActorRef.noSender());
        Thread.sleep(2000);
        supervisor.tell("null", ActorRef.noSender());
        supervisor.tell("null", ActorRef.noSender());

        ActorRef workerActor = supervisor.underlyingActor().childActor;
        TestProbe probe = new TestProbe(_system);
        probe.watch(workerActor);
        probe.expectMsgClass(Terminated.class);
        //
        Thread.sleep(5000);
        assert supervisor.underlyingActor().childActor.isTerminated();
    }


    @Test
    public void stopTest() throws Exception {

        ActorRef workerActor = supervisor.underlyingActor().childActor;
        TestProbe probe = new TestProbe(_system);
        probe.watch(workerActor);

        supervisor.tell(Long.parseLong("10"), ActorRef.noSender());

        probe.expectMsgClass(Terminated.class);
    }
}
