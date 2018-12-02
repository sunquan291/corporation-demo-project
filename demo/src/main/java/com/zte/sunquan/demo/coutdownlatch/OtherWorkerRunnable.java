package com.zte.sunquan.demo.coutdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by 10184538 on 2016/11/24.
 */
public class OtherWorkerRunnable implements Runnable {
    private final CountDownLatch doneSignal;
    public OtherWorkerRunnable(CountDownLatch doneSignal) {
        this.doneSignal = doneSignal;
    }

    public void run() {
        try {
            doneSignal.await();
            System.out.println("Print sentence in OtherWorkerRunnable");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
