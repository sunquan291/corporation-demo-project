package com.zte.sunquan.demo.actor.linecount.cluster;

import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * Created by 10184538 on 2017/9/5.
 */
public class TestActor extends UntypedActor {
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    public static Props props() {
        return Props.create(TestActor.class);
    }

    @Override
    public void preStart() throws Exception {
        super.preStart();
        System.out.println("preStart");
    }

    @Override
    public void postStop() throws Exception {
        super.postStop();
        System.out.println("postStop");
    }

    @Override
    public void onReceive(Object message) {
        System.out.println(message);
    }
}
