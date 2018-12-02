package com.zte.sunquan.demo.netty.server;


import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 10184538 on 2017/12/27.
 */
public class MainController {
    private ExecutorService executor = Executors.newFixedThreadPool(1);//.newFixedThreadPool(7);//.newFixedThreadPool(1);

    private static Map<String, MainController> map = new ConcurrentHashMap<>();

    public void submitTask() {
        for (int i = 0; i < 1; i++) {
//            executor.submit(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName() + "正处理");
//                }
//            });
            executor.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    System.out.println(Thread.currentThread().getName() + "正处理");
                    return "ABC";
                }
            });
        }
//        executor.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
//        int i=0;
//        while (i++<2100) {
//            MainController ct1 = new MainController();
//            map.put("1", ct1);
//            Thread.sleep(2000);
//            ct1.submitTask();
//            map.remove("1");
//        }

        MainController ct1 = new MainController();
        ct1.submitTask();
//        Exception e = new Exception("abc");
//        e.printStackTrace();
        latch.await();
    }
}