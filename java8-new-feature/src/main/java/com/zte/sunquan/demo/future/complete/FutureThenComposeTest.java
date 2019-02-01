package com.zte.sunquan.demo.future.complete;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class FutureThenComposeTest {
    //compose相当于flatMap,避免CompletableFuture<CompletableFuture<String>>这种
    @Test
    public void testThenCompose() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            return "zero";
        }, executor);
        CompletableFuture<CompletableFuture<String>> f4 = f1.thenApply(FutureThenComposeTest::calculate);
        System.out.println("f4.get:" + f4.get().get());

        //compose时入参是future
        CompletableFuture<String> f5 = f1.thenCompose(FutureThenComposeTest::calculate);
        System.out.println("f5.get:" + f5.get());

        System.out.println(f1.get());
    }

    public static CompletableFuture<String> calculate(String input) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(input);
            return input + "---" + input.length();
        }, executor);
        return future;
    }
}
