package com.zte.sunquan.demo.actor.linecount.sortint;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * Created by 10184538 on 2017/6/17.
 */
public class IntArraySort {

    private static int[] inputs = {
            2, 3, 2,
            1, 12, 32,
            12, 44, 56,
            12, 42, 121,
            555, 12, 1000,
            29,-1
    };

    public static void main(String[] args) {
        //创建ActorSystem
        ActorSystem actorSystem = ActorSystem.create("int-arry-sort");
        //创建actor
        ActorRef mySortActorRef = actorSystem.actorOf(Props.create(MySortActor.class), "MySortActor");
        //mysortActorRef被传递（告知）一个数组
        mySortActorRef.tell(inputs, ActorRef.noSender());
    }
}
