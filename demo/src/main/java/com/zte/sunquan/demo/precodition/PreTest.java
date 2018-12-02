package com.zte.sunquan.demo.precodition;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 10184538 on 2018/3/5.
 */
public class PreTest {

    private static ExecutorService executor = Executors.newFixedThreadPool(10);
    private String abc() {
        check();
        return "abc";
    }

    private void check() {
        Preconditions.checkState(1 + 2 > 10, "error");
        ListenableFuture<?> submit = MoreExecutors.listeningDecorator(executor).submit(() -> {
        });
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "abc", executor);
        future.whenComplete((a,e)->{});
    }

    @Test
    public void myTest() {
        String check = abc();
        System.out.println("aa" + check);
    }

}
