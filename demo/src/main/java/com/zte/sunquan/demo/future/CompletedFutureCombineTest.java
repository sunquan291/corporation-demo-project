package com.zte.sunquan.demo.future;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 10184538 on 2016/12/6.
 */
public class CompletedFutureCombineTest {
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void futureTest00() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("future runing...");
            return 100;
        });
        CompletableFuture<String> future1 = future.thenCompose(i -> {
            return CompletableFuture.supplyAsync(() -> {
                return (i * 10) + "";
            });
        });
        System.out.println("Future1 result:" + future1.get());
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        CompletedFutureCombineTest cft = new CompletedFutureCombineTest();
        cft.futureTest00();
        System.in.read();
    }
}
