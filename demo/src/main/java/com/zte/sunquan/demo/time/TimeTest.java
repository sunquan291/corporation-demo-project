package com.zte.sunquan.demo.time;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by 10184538 on 2017/7/28.
 */
public class TimeTest {
    @Test
    public void testTimes() throws InterruptedException {
        Instant start = Instant.now();
        TimeUnit.SECONDS.sleep(2);
        Duration between = Duration.between(start, Instant.now());
        System.out.println(between.toNanos());
    }
    @Test
    public void testDate(){
        LocalDate now = LocalDate.now();
        System.out.println(now);
        now=LocalDate.of(2017,1,1).plusDays(1);
        System.out.println(now);
    }
    @Test
    public void testA(){
        AtomicLong atomicLong=new AtomicLong(1L);
        ConcurrentHashMap map=new ConcurrentHashMap();
    }
}
