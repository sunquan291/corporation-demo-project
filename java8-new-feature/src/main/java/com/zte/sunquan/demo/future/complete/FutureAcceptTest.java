package com.zte.sunquan.demo.future.complete;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Before;
import org.junit.Test;

public class FutureAcceptTest {
    private static ExecutorService executorService = Executors.newFixedThreadPool(10,
            UserThreadFactory.build("future-test"));
    //默认定义两个future
    private CompletableFuture<Integer> future;
    private CompletableFuture<Integer> futureWithException;

    @Before
    public void init() {
        future = CompletableFuture.supplyAsync(() -> {
            System.out.println("thread name:" + Thread.currentThread().getName());
            //计算0+...+100
            int result = 0;
            for (int i = 0; i <= 100; i++)
                result += i;
            return result;
        }, executorService);
        futureWithException = CompletableFuture.supplyAsync(() -> 1 / 0
                , executorService);
    }


    @Test
    public void testAccept() throws InterruptedException {
        //与whenComplete类似，设置回调，同时吞掉异常
        future.thenAccept(p -> {
            System.out.println("Result:" + p);
        });
        Thread.sleep(500);
    }

    @Test
    public void testAcceptBoth() throws InterruptedException {
        //如果AcceptBoth中其中有异常，则无执行回调   那能处理异常的组合 thenCombine
        future.thenAcceptBoth(futureWithException, (x, y) -> {
            System.out.println(x + ":" + y);
        });
        Thread.sleep(500);
    }

    @Test
    public void testAcceptBoth2() throws InterruptedException {
        future.thenAcceptBoth(CompletableFuture.completedFuture(100), (x, y) -> {
            System.out.println(x + ":" + y);
        });
        Thread.sleep(500);
    }
}
