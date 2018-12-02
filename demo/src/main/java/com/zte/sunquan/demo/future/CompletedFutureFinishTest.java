package com.zte.sunquan.demo.future;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 10184538 on 2016/12/6.
 * 计算结果完成时的处理
 * whenComplete产生的future随原future完成而完成，结果即原future返回结果
 * handleAsync产生的future随原future完成而完成，结果可以自定义(同时可处理异常，防止持续的抛出)兼有whenComplete和转换的两个功能
 */

public class CompletedFutureFinishTest {
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);
    @Test
    public void futureTest00() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("future runing...");
            return 100;
        });
        CompletableFuture<Integer> future1 = future.whenComplete((v, e) -> {
            System.out.println("future result:" + v);
            System.out.println("future expection:" + e);
        });

//        System.out.println("Future1 result:" + future1.get());
//        future.handleAsync((v, e) -> {
//            return v + 10;
//        });
    }

    public void futureTest01() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("future runing...");
            return 100;
        });
        CompletableFuture<Integer> future1 = future.handleAsync((v, e) -> {
            System.out.println("future result:" + v);
            System.out.println("future expection:" + e);
            return v * 8;
        });
        System.out.println("Future1 result:" + future1.get());
    }

    public void futureTest02() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("future runing...");
            throw new IndexOutOfBoundsException("h");
        });
        CompletableFuture<Integer> future1 = future.handleAsync((v, e) -> {
            System.out.println("future result:" + v);
            System.out.println("future expection:" + e);
            return 8;
        });
        System.out.println("Future1 result:" + future1.get());
    }

    public void futureTest03() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("future runing...");
            throw new IndexOutOfBoundsException("h");
        });
        CompletableFuture<Integer> future1 = future.whenComplete((v, e) -> {
            System.out.println("future result:" + v);
            System.out.println("future expection:" + e);
        });
        System.out.println("Future1 result:" + future1.get());
    }
    public void futureTest04() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("future runing...");
            return 100;
        });
        CompletableFuture<Integer> future1 = future.exceptionally((e) -> {
            System.out.println("future expection:" + e);
            return 0;
        });
        System.out.println("Future1 result:" + future1.get());
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        CompletedFutureFinishTest cft = new CompletedFutureFinishTest();
//        cft.futureTest00();
//        cft.futureTest01();
//        cft.futureTest02();
//        cft.futureTest03();
        cft.futureTest04();
        System.in.read();
    }
}
