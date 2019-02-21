package com.zte.sunquan.demo.thread.local;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

/**
 * TransmittableThreadLocalTest class
 *
 * @author 10184538
 * @date 2019/2/21
 */
public class TransmittableThreadLocal2Test {

    private static ExecutorService executorService = Executors.newFixedThreadPool(1);

    private static final ThreadLocal<String> nameThreadLocal = new TransmittableThreadLocal<String>();

    public static void main(String[] args) throws InterruptedException {
        nameThreadLocal.set("abc");

        executorService.submit(TtlRunnable.get(() -> {
            //abc(子线程中会引起父线程变更)
            System.out.println(Thread.currentThread().getName() + ":" + nameThreadLocal.get());
            //修改线程变量
            nameThreadLocal.set("efg");
        }));

        TimeUnit.SECONDS.sleep(1);

        executorService.submit(TtlRunnable.get(() -> {
            System.out.println(Thread.currentThread().getName() + ":" + nameThreadLocal.get());
        }));
        //abc
        System.out.println(Thread.currentThread().getName() + ":" + nameThreadLocal.get());
        Thread.sleep(2000);
    }
}
