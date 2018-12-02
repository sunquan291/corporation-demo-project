package com.zte.sunquan.demo.coutdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by 10184538 on 2016/11/24.
 */
public class WorkerRunnable implements Runnable {
    private final CountDownLatch doneSignal;
    private final int i;
    public WorkerRunnable(CountDownLatch doneSignal, int i1) {
        this.doneSignal = doneSignal;
        this.i = i1;
    }

    public void run() {
        doWork(i);
        doneSignal.countDown();
        System.out.println(doneSignal.getCount());
    }

    private void doWork(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread:%s with i=%d\n",Thread.currentThread().getName(),i);
    }
}
