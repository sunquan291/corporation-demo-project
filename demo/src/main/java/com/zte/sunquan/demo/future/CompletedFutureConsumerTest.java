package com.zte.sunquan.demo.future;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 10184538 on 2016/12/6.
 * 纯消费Action
 * thenApply, handle处理完会产生新的计算结果,或者返回同样的计算结果whenComplete
 *
 * 不返回任何值
 *
 * thenRun不会使用原future的结果
 */
public class CompletedFutureConsumerTest {
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void futureTest00() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("future runing...");
            return 100;
        });
        CompletableFuture<Void> future1 = future.thenAccept((v) -> {
            System.out.println("future result:" + v);
        });

        System.out.println("Future1 result:" + future1.get());
    }
    public void futureTest01() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("future runing...");
            return 100;
        });
        //当future1与第一个参数执行完成后，结果参数会传给第二个参数Function
        CompletableFuture<Void> future1 = future.thenAcceptBoth(CompletableFuture.completedFuture(10),
                (x, y) -> System.out.println(x * y));

        System.out.println("Future1 result:" + future1.get());
    }

    public void futureTest02() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("future runing...");
            return 100;
        });
        //当future1与第一个参数执行完成后，结果参数会传给第二个参数Function
        CompletableFuture<Void> future1 = future.thenRun(
                () -> System.out.println());

        System.out.println("Future1 result:" + future1.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        CompletedFutureConsumerTest cft = new CompletedFutureConsumerTest();
//        cft.futureTest00();
        cft.futureTest01();
        System.in.read();
    }
}
