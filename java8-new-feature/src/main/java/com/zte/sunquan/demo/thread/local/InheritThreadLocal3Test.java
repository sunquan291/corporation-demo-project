package com.zte.sunquan.demo.thread.local;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ThreadLocalTest class
 * 需要注意通过线程池来进行子父线程变量传递时，则会出现问题
 * @author 10184538
 * @date 2019/2/21
 */
public class InheritThreadLocal3Test {

    private static ExecutorService executorService = Executors.newFixedThreadPool(1);

    private static final ThreadLocal<String> nameThreadLocal = new InheritableThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "sunquan";
        }
    };

    public static void main(String[] args) throws InterruptedException {
        nameThreadLocal.set("abc");

        executorService.submit(()->{
            //abc(子线程中会引起父线程变更)
            System.out.println(Thread.currentThread().getName() + ":" + nameThreadLocal.get());
            //修改线程变量
            nameThreadLocal.set("efg");
        });

        TimeUnit.SECONDS.sleep(1);

        executorService.submit(()->{
            //居然打印efg,而不在是父线程中变量
            System.out.println(Thread.currentThread().getName() + ":" + nameThreadLocal.get());
        });
        //abc
        System.out.println(Thread.currentThread().getName() + ":" + nameThreadLocal.get());
        Thread.sleep(1000);
    }
}
