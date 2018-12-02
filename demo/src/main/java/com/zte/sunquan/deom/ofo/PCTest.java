package com.zte.sunquan.deom.ofo;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.PoisonPill;
import org.junit.Test;

/**
 * Created by sunquan on 2018/3/29.
 */
public class PCTest {
    static ActorSystem _system = ActorSystem.create("mysystem");

    @Test
    public void test() throws InterruptedException {
        _system.actorOf(ParentActor.props(),"parent");
        ActorRef parent = _system.actorFor("akka://mysystem/user/parent");
        Thread.sleep(3000);
        ActorRef c1 = _system.actorFor("akka://mysystem/user/parent/c1");
        ActorRef c2 = _system.actorFor("akka://mysystem/user/parent/c2");
        parent.tell("p1",ActorRef.noSender());
        c1.tell("c1",ActorRef.noSender());
        c2.tell("c2",ActorRef.noSender());
        parent.tell("killc1",ActorRef.noSender());
        _system.actorOf(ChildActor.props("c1"),"c1");
        Thread.sleep(5000);
        _system.terminate();
    }

}
