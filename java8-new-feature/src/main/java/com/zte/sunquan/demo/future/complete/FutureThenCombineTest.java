package com.zte.sunquan.demo.future.complete;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Before;
import org.junit.Test;

public class FutureThenCombineTest {
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
    public void testThenCombine() throws InterruptedException, TimeoutException, ExecutionException {
        //与AcceptBoth类似，但有返回值，同样不能处理异常，且会抛出
        CompletableFuture<Integer> resultFuture = future.thenCombine(futureWithException, (x, y) -> {
            System.out.println(x + ":" + y);
            return x + y;
        });
        Thread.sleep(500);
        System.out.println(resultFuture.get(10, TimeUnit.SECONDS));
    }

    @Test
    public void testThenCombine2() throws InterruptedException, TimeoutException, ExecutionException {
        CompletableFuture<Integer> resultFuture = future.thenCombine(CompletableFuture.completedFuture(100), (x, y) -> {
            System.out.println(x + ":" + y);
            return x + y;
        });
        Thread.sleep(500);
        System.out.println(resultFuture.get(10, TimeUnit.SECONDS));
    }
}
