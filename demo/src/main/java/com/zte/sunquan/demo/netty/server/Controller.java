package com.zte.sunquan.demo.netty.server;


import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 10184538 on 2017/12/27.
 */
public class Controller {
    private ExecutorService executor = Executors.newSingleThreadExecutor();//.newFixedThreadPool(1);


    public void submitTask() {
        for (int i = 0; i < 1; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "正处理");
                }
            });
        }
//        executor.shutdown();
    }
}