package com.zte.sunquan.demo.metric;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;

import java.security.Guard;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by 10184538 on 2016/12/6.
 */
public class MetricTest {

    private static List<String> queue=new ArrayList<>();

    static  MetricRegistry metricRegistry=new MetricRegistry();

    static ConsoleReporter consoleReporter=ConsoleReporter.forRegistry(metricRegistry).build();

    public static void main(String[] args) throws InterruptedException {

        Gauge<Integer> gauge = new Gauge<Integer>() {
            @Override
            public Integer getValue() {
                return queue.size();
            }
        };
        //注册需要报告内容（Gauge实现)
        metricRegistry.register(MetricRegistry.name(MetricTest.class, "pending-job", "size"),gauge);
        //开始报告
        consoleReporter.start(3, TimeUnit.SECONDS);

        TimeUnit.SECONDS.sleep(10);
    }

}
