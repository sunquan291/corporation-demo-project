package com.zte.sunquan.demo.future.complete;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Before;
import org.junit.Test;

public class FutureWhenCompleteTest {
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
    public void testWhenComplete() throws InterruptedException {
        //计算完成后随即执行. 可以处理异常  无返回值
        future.whenComplete((p, e) -> {
            if (e == null)
                System.out.println("Result:" + p);
        });
        Thread.sleep(500);
    }

    @Test
    public void testWhenComplete2() throws InterruptedException {
        futureWithException.whenComplete((p, e) -> {
            if (e != null)
                System.out.println("error");
        });
        Thread.sleep(500);
    }
}
