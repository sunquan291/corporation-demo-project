package com.zte.sunquan.demo.actor.linecount;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

/**
 * Created by 10184538 on 2016/10/25.
 */
public class LineCounterActor extends UntypedActor {
    @Override
    public void onReceive(Object msg) {
        if(msg instanceof LineCalculatingMsg){
            LineCalculatingMsg processStringMsg=(LineCalculatingMsg)msg;
            int wordsInLine=processStringMsg.getLine().split(" ").length;
            getSender().tell(new LineCalculatedMsg(wordsInLine), ActorRef.noSender());
            System.out.printf("%s has count %d words\n",Thread.currentThread().getName(),wordsInLine);
        }
    }
}
