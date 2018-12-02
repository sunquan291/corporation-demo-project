package com.zte.sunquan.demo.actor.timeout;

import akka.actor.AbstractActor;
import akka.actor.Props;

import javax.annotation.concurrent.GuardedBy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 10184538 on 2017/9/30.
 */
public class PrintActor extends AbstractActor {

    @GuardedBy("DATE_FORMAT")
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static Props props() {
        return Props.create(PrintActor.class);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(String.class, s -> {
            System.out.println("Got String:" + s + " at:" + DATE_FORMAT.format(new Date()));
        }).build();
    }
}
