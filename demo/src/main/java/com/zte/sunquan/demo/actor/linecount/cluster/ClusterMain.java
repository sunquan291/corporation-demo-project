package com.zte.sunquan.demo.actor.linecount.cluster;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.DeadLetter;
import akka.actor.Kill;

/**
 * Created by 10184538 on 2017/9/5.
 */
public class ClusterMain {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println("Start simpleClusterListener");
//        final ActorSystem actorSystem = ActorSystem.create("helloakka");
//        final ActorRef simpleClusterListener = actorSystem.actorOf(springExt.props("SimpleClusterListener"), "simpleClusterListener");
//        actorMap.put("simpleClusterListener", simpleClusterListener);
//        System.out.println.info("Started simpleClusterListener");
        final ActorSystem actorSystem = ActorSystem.create("helloakka");
        ActorRef actorRef = actorSystem.actorOf(TestActor.props(), "12ab");

        System.out.println(actorRef);
        System.out.println(actorRef.isTerminated());
        //一个Terminated消息会被发送到所有的watcher
//        actorRef.tell(PoisonPill.getInstance(),ActorRef.noSender());
        //宿主Actor会抛出一个ActorKilledException并被发送给Supervisor
        actorRef.tell(Kill.getInstance(), ActorRef.noSender());
        Thread.sleep(2000);
        System.out.println(actorRef.isTerminated());

        ActorRef deadListenerActor = actorSystem.actorOf(DeadLetterListener.props(), "deadsq");
        actorSystem.eventStream().subscribe(deadListenerActor, DeadLetter.class);
        actorRef.tell("hello,world", ActorRef.noSender());

        Thread.sleep(5000);


    }
}
