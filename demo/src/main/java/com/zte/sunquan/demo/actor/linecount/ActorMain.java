package com.zte.sunquan.demo.actor.linecount;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * Created by 10184538 on 2016/11/24.
 */
public class ActorMain implements java.io.Serializable{

    public static final String filePath="E:/AbstractDriverEventHandler.java";

    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("helloakka");
        final ActorRef myActor = system.actorOf(Props.create(FileCounterActor.class), "myActor");
        myActor.tell(new StartFileCalculateMsg(filePath), ActorRef.noSender());
    }
}
