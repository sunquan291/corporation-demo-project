package com.zte.sunquan.demo.thread.local;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
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
public class TransmittableThreadLocalTest {

    private static ExecutorService executorService = Executors.newFixedThreadPool(1);

    private static final ThreadLocal<String> nameThreadLocal = new TransmittableThreadLocal<String>();

    public static void main(String[] args) throws InterruptedException {
        nameThreadLocal.set("abc");

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        list.forEach(p->{
            executorService.submit(TtlRunnable.get(() -> {
                //abc(子线程中会引起父线程变更)
                System.out.println(p+"-"+Thread.currentThread().getName() + ":" + nameThreadLocal.get());
                //修改线程变量
                nameThreadLocal.set("efg");
            }));
            //不行，要使用上面的
//            executorService.submit(() -> {
//                //abc(子线程中会引起父线程变更)
//                System.out.println(p+"-"+Thread.currentThread().getName() + ":" + nameThreadLocal.get());
//                //修改线程变量
//                nameThreadLocal.set("efg");
//            });
        });

        //abc
        System.out.println(Thread.currentThread().getName() + ":" + nameThreadLocal.get());
        Thread.sleep(2000);
        executorService.shutdown();
    }
}
