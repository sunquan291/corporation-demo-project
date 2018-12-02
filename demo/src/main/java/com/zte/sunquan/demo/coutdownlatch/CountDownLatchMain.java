package com.zte.sunquan.demo.coutdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by 10184538 on 2016/11/24.
 */
public class CountDownLatchMain {
    public static final int num = 6;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(num);
        Executor e = Executors.newFixedThreadPool(10);
        //start num threads and wait they completed...(use countDownLatch.await)
        for (int i = 0; i < num; i++) {
            e.execute(new WorkerRunnable(countDownLatch, i));
        }
        System.out.println("Print1 sentence in Main Thread");
//        countDownLatch.await();
//        e.execute(new OtherWorkerRunnable(countDownLatch));
        System.out.println("Print2 sentence in Main Thread");
    }
}
