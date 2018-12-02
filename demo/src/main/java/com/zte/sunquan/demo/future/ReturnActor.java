package com.zte.sunquan.demo.future;

import akka.actor.AbstractActor;
import akka.actor.Props;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/**
 * Created by sunquan on 2017/9/30.
 */
public class ReturnActor extends AbstractActor {

    @GuardedBy("DATE_FORMAT")
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static Props props() {
        return Props.create(ReturnActor.class);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(String.class, s -> {
            System.out.println("Got String:" + s + ", at:" + DATE_FORMAT.format(new Date()));
            getContext().stop(getSelf());
            getContext().actorOf(ReturnActor.props(),"print");
//            TimeUnit.SECONDS.sleep(5);
//            getSender().tell(28,getSelf());
        }).build();
    }
}
