package com.zte.sunquan.demo;

/**
 * Created by 10184538 on 2017/12/11.
 */

import com.google.common.base.Preconditions;

import java.util.concurrent.CountDownLatch;

public class TestNativeOutOfMemoryError {

    public static void main(String[] args) {

//        for (int i = 0;; i++) {
//            System.out.println("i = " + i);
//            new Thread(new HoldThread()).start();
//    }
        Integer integer = null;
        Preconditions.checkNotNull(integer, "integer not null.");
        System.out.println("xxxxxxxxx");
        System.out.println("yyyyyyyy");


    }

}

class HoldThread extends Thread {
    CountDownLatch cdl = new CountDownLatch(1);

    public HoldThread() {
        this.setDaemon(true);
    }

    public void run() {
        try {
            cdl.await();
        } catch (InterruptedException e) {
        }
    }

}