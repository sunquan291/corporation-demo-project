package com.zte.sunquan.demo.future;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 10184538 on 2016/12/6.
 * 转换
 * whenComplete产生的future随原future完成而完成，结果即原future返回结果
 * handleAsync产生的future随原future完成而完成，结果可以自定义(同时可处理异常，防止持续的抛出)兼有whenComplete和转换的两个功能
 * thenApply功能上与handleAsync一样，但可以转换数据类型，同时依次处理，但无法处理异常
 */
public class CompletedFutureTransTest {
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void futureTest00() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("future runing...");
            return 100;
        });
        CompletableFuture<Integer> future1 = future.thenApply((v) -> {
            System.out.println("future result:" + v);
            return Integer.MAX_VALUE;
        });

        System.out.println("Future1 result:" + future1.get());
        future.handleAsync((v, e) -> {
            return v + 10;
        });
    }

    public void futureTest01() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("future runing...");
            return 100;
        });
        CompletableFuture<String> future1 = future.thenApply((v) ->
                v * 8
        ).thenApply(v->"result"+v);
        System.out.println("Future1 result:" + future1.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        CompletedFutureTransTest cft = new CompletedFutureTransTest();
//        cft.futureTest00();
        cft.futureTest01();
        System.in.read();
    }
}
