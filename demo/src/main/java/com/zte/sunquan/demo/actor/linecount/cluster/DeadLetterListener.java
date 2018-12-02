package com.zte.sunquan.demo.actor.linecount.cluster;

import akka.actor.DeadLetter;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * Created by 10184538 on 2018/4/24.
 */
public class DeadLetterListener extends UntypedActor {
    public static Props props() {
        return Props.create(DeadLetterListener.class);
    }
    @Override
    public void onReceive(Object o) throws Throwable {
        if (o instanceof DeadLetter) {
            DeadLetter letter = (DeadLetter) o;
            System.out.println("SQ:" + letter.message());
        }
    }
}
