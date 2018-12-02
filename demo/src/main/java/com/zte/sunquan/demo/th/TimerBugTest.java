package com.zte.sunquan.demo.th;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by 10184538 on 2016/12/6.
 */
public class TimerBugTest {

    private static long start;
    public static void main(String[] args) {
        TimerTask t1=new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task1 start after:"+(System.currentTimeMillis()-start));
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        TimerTask t2=new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task1 start after:"+(System.currentTimeMillis()-start));
            }
        };
        start = System.currentTimeMillis();
        Timer t=new Timer();
        t.schedule(t1,1000);//1秒后开始执行
        //理论上2秒后开始执行，但其实是6（1+5）秒后才开始执行，主要是timer是单线程，在t1中等待了5秒
        t.schedule(t2,2000);
    }
}
