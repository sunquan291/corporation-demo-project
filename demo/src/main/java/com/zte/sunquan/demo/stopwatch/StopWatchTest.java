package com.zte.sunquan.demo.stopwatch;

import com.google.common.base.Stopwatch;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.util.concurrent.TimeUnit;

/**
 * Created by 10184538 on 2017/11/7.
 */
public class StopWatchTest {

    public static void main(String[] args) throws InterruptedException {
//        Stopwatch stopwatch = Stopwatch.createUnstarted();
//        stopwatch.start();
//        TimeUnit.SECONDS.sleep(3);
//        Long l=stopwatch.elapsed(TimeUnit.MILLISECONDS);
//        System.out.println(l);
//
//        stopwatch.reset();
//        if (!stopwatch.isRunning()) {
//            stopwatch.start();
//        }
//        TimeUnit.SECONDS.sleep(3);
//        Long l2=stopwatch.elapsed(TimeUnit.MILLISECONDS);
//        System.out.println(l2);
        System.out.println(LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));
    }

}
