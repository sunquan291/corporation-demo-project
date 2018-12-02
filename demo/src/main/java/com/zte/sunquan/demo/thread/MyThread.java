package com.zte.sunquan.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 10184538 on 2017/3/28.
 */
public class MyThread {

    public MyThread(String group) {
        ExecutorService takeExecutor = Executors.newFixedThreadPool(1);
        takeExecutor.submit(() -> {
            while (true) {
                System.out.println(group);
            }
        });
    }
}
