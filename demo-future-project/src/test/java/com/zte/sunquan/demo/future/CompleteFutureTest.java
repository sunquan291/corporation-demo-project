package com.zte.sunquan.demo.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by 10184538 on 2018/6/2.
 */
public class CompleteFutureTest {
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);
    private CompletableFuture<Integer> future;
    private CompletableFuture<Integer> futureWithException;

    @Before
    public void init() {
        future = CompletableFuture.supplyAsync(() -> {
            int result = 0;
            for (int i = 0; i <= 100; i++)
                result += i;
            return result;
        }, executorService);
        futureWithException = CompletableFuture.supplyAsync(() -> {
            return 1 / 0;
        }, executorService);
    }

    @Test
    public void testComplete() throws InterruptedException {
        //设置回调常用方法whenComplete
        future.whenComplete((p, e) -> {
            if (e == null)
                System.out.println("Result:" + p);
        });
        Thread.sleep(500);
    }

    @Test
    public void testAccept() throws InterruptedException {
        //与whenComplete类似，设置回调，同时吞掉异常
        futureWithException.thenAccept((p) -> {
            System.out.println("Result:" + p);
        });
        Thread.sleep(500);
    }

    @Test
    public void testAcceptBoth() throws InterruptedException {
        //thenAcceptBoth,future的组合，同样有异常不执行（类比allAsList）
        future.thenAcceptBoth(futureWithException, (x, y) -> {
            System.out.println(x + ":" + y);
        });
        Thread.sleep(500);
        future.thenAcceptBoth(CompletableFuture.completedFuture(100), (x, y) -> {
            System.out.println(x + ":" + y);
        });
        Thread.sleep(500);
    }

    @Test
    public void testThenCombine() throws InterruptedException, ExecutionException {
        //thenAcceptBoth,future的组合，同样有异常不执行（类比allAsList）
        future.thenCombine(futureWithException, (x, y) -> {
            System.out.println(x + ":" + y);
            return x + ":" + y;
        });
        Thread.sleep(500);
        future.thenCombine(CompletableFuture.completedFuture(100), (x, y) -> {
            System.out.println(x + ":" + y);
            return x + ":" + y;
        });
        Thread.sleep(500);

        /////////////////compose 方法返回future/////////////////////////
        future.thenCompose(p -> {
            return CompletableFuture.completedFuture(p);
        });
        System.out.println(future.get());
        Thread.sleep(500);
    }
}
