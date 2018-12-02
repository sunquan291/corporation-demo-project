package com.zte.sunquan.demo.executor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/**
 * Created by sunquan on 2017/4/15.
 */
public class ExecutorTest {

    public ThreadFactory getFactory(String groupName, String name) {
        ThreadFactoryBuilder threadFactoryBuilder = new ThreadFactoryBuilder();
        threadFactoryBuilder.setNameFormat(name)
                .setThreadFactory(GroupedThreadFactory.groupedThreadFactory(groupName));
        return threadFactoryBuilder.build();
    }

    @Test
    public void threadWithName() throws InterruptedException {
        ThreadFactory build = new ThreadFactoryBuilder().setPriority(Thread.NORM_PRIORITY)
                .setDaemon(false)
                .setNameFormat("SQ-Creat-%d")
                .build();
        ExecutorService ses = Executors.newFixedThreadPool(10, Executors.defaultThreadFactory());
        for (int i = 1; i < 10; i++) {
            ses.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

        ScheduledExecutorService ses2 = Executors.newSingleThreadScheduledExecutor(build);
        ses2.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("abc:" + Thread.currentThread().getName());
            }
        });

        Thread.sleep(1000);

    }


    @Test
    public void threadWithUserName() throws InterruptedException {
        ExecutorService ses = Executors.newFixedThreadPool(10, UserThreadFactory.build("abc"));
        for (int i = 1; i < 10; i++) {
            ses.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        ExecutorService ses2 = Executors.newFixedThreadPool(10, UserThreadFactory.build("abc"));
        for (int i = 1; i < 10; i++) {
            ses2.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        ScheduledExecutorService ses3 = Executors.newSingleThreadScheduledExecutor(UserThreadFactory.build("efg"));
        ses3.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });

        Thread.sleep(1000);

    }

    @Test
    public void test() throws InterruptedException {
        //对每一个事件都要定义其所在的事件组，事件名，并保持相关继承关系
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ExecutorService executorService =
                Executors.newFixedThreadPool(2, getFactory("sqGroup/a/b", "sqThread%d"));
        executorService.execute(() -> {
            System.out.println("parent thread group name: " + Thread.currentThread().getThreadGroup().getParent().getName());
            System.out.println("current thread group name: " + Thread.currentThread().getThreadGroup().getName());
            System.out.println("current thread name: " + Thread.currentThread().getName());
            countDownLatch.countDown();
        });
        countDownLatch.await();
        System.out.println(Thread.currentThread().getThreadGroup().getName());
    }

    @Test
    public void dTest() throws InterruptedException {
        ExecutorService executorService = DynamicExecutorFactory
                .getExecutorService(true, 50);//只有1个线程
        Thread.sleep(15000);
        DynamicExecutorFactory.getExecutorService(true, 50);//压力计算得26个线程
//        Thread.currentThread().join();
    }

}
