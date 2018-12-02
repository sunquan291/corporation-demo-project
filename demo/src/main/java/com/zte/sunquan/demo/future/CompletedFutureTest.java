package com.zte.sunquan.demo.future;


import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by 10184538 on 2016/12/6.
 */
public class CompletedFutureTest {
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Test(expected = ExecutionException.class)
    public void futureTest00() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int i = 1 / 0;
            return 100;
        });
        //java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
//        future.join();
        //java.util.concurrent.ExecutionException: java.lang.ArithmeticException: / by zero
        future.get();//抛出异常
    }

    @Test
    public void futureTest10() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return 100;
        });
        int result=future.get().intValue();
        Assert.assertEquals(100,result);

        CompletableFuture<Integer> sleepFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });

        result=sleepFuture.getNow(200);
        Assert.assertEquals(200,result);
    }

    @Test(expected = TimeoutException.class)
    public void futureTest11() throws InterruptedException, ExecutionException, TimeoutException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });
        future.get(1,TimeUnit.SECONDS);
    }
    public void futureTest01() throws ExecutionException, InterruptedException {
        //runAsync无返回值
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            System.out.println("hello,future1");
        }, executorService);
        System.out.println(future1.get());
    }

    public void futureTest02() throws ExecutionException, InterruptedException {
        //supplyAsync有返回值
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello,future1");
            return 100;
        }, executorService);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello,future2");
            return 200;
        }, executorService);

        CompletableFuture<Void> future3 = CompletableFuture.allOf(future1, future2);
        //确保future1与future都执行完成
        future3.join();
        System.out.println("hello,world3");
        System.out.println(future3.get());
    }

    public void futureTest03() throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello,future1");
            return 100;
        }, executorService);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello,future2");
            return 200;
        }, executorService);
        //future1与future2任一个执行完成
        CompletableFuture future = CompletableFuture.anyOf(future1, future2);
        System.out.println("hello,world3");
        System.out.println(future.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletedFutureTest cft = new CompletedFutureTest();
//        cft.futureTest00();
        cft.futureTest03();
        System.exit(0);
    }
}
