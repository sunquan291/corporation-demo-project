package com.zte.sunquan.demo.thread.local;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ThreadLocalTest class
 * 需要注意通过线程池来进行子父线程变量传递时，则会出现问题
 * JAVA8
 *
 * @author 10184538
 * @date 2019/2/21
 */
public class InheritThreadLocal4Test {
    private static ExecutorService executorService = Executors.newFixedThreadPool(1);

    private static final ThreadLocal<String> nameThreadLocal = new InheritableThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "sunquan";
        }
    };

    public static void main(String[] args) throws InterruptedException {
        nameThreadLocal.set("abc");

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.forEach(p -> {
            System.out.println(p + ":" + Thread.currentThread().getName() + ":" + nameThreadLocal.get());
        });
        TimeUnit.SECONDS.sleep(2);

        list.parallelStream().forEach(p -> {
            //不在是父线程中变量
            //ForkJoinPool.commonPool-worker-1父线程
            nameThreadLocal.set("efg" + p);
            System.out.println(p + ":" + Thread.currentThread().getName() + ":" + nameThreadLocal.get());
        });

        //abc
        System.out.println(Thread.currentThread().getName() + ":" + nameThreadLocal.get());
        Thread.sleep(1000);
    }
}
