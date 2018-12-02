package com.zte.sunquan.demo;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by 10184538 on 2017/7/24.
 */
public class FutrueTask {
    @Test
    public void test() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future=CompletableFuture.supplyAsync(()->{
            return  1;
        }).thenAccept(t->{
            System.out.println("hello,woorld.");
        }).thenAccept(t->{
            System.out.println("hello,woorld2.");
        });
        System.out.println("Future1 result:" + future.get());
    }
}
