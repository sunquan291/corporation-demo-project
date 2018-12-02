package com.zte.sunquan.demo.actor.timeout;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.actor.ReceiveTimeout;
import scala.concurrent.duration.Duration;

import javax.annotation.concurrent.GuardedBy;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by 10184538 on 2017/9/30.
 */
public class CalculatorActor extends AbstractActor {
    @GuardedBy("DATE_FORMAT")
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public CalculatorActor() {
        getContext().setReceiveTimeout(Duration.apply(5, TimeUnit.SECONDS));
    }

    public static Props props() {
        return Props.create(CalculatorActor.class);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(String.class, p -> {
            String outMsg="calculator:"+p;
            System.out.println(outMsg);
            getSender().tell(outMsg,getSelf());
        }).match(ReceiveTimeout.class,p->{
            System.out.println("ReceiveTimeout:"+DATE_FORMAT.format(new Date()));
        })
                .build();
    }
}
