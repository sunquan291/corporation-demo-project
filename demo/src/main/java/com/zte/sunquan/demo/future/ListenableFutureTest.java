package com.zte.sunquan.demo.future;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by 10184538 on 2016/12/23.
 */
public class ListenableFutureTest {

    @Test
    public void testListenableFuture() throws IOException {
        ListeningExecutorService executorService = MoreExecutors
                .listeningDecorator(Executors.newCachedThreadPool());
        final ListenableFuture<Integer> listenableFuture
                = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("call listenableFuture..");
                TimeUnit.SECONDS.sleep(1);
                return 7;
            }
        });
        Futures.addCallback(listenableFuture, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(Integer result) {
                System.out.println("get listenable future's result with callback " + result);
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });
        System.in.read();
    }

    @Test
    public void testThenApply() throws IOException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("call completableFuture..");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 7;
        });
        CompletableFuture<Integer> future1 = future.whenComplete((v, e) -> {
            if (e == null)
                System.out.println("get completable future's result with callback " + v);
        });
        System.in.read();
    }
}
