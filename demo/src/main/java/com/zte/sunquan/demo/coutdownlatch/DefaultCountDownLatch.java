package com.zte.sunquan.demo.coutdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by 10184538 on 2017/7/10.
 */
public class DefaultCountDownLatch {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        for(int i=0;i<4;i++)
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("xxxxxxxxxxxxxxxxxxxx");
                    countDownLatch.countDown();
                    System.out.println("yyyyyyyyyyyyyyyyyyyy");
                }
            }).start();
        countDownLatch.await();
        System.out.println("end");
    }
}
