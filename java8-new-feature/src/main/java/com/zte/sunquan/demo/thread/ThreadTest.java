package com.zte.sunquan.demo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.alibaba.ttl.TtlRunnable;
import com.zte.sunquan.demo.future.complete.UserThreadFactory;

/**
 * ThreadTest class
 *
 * @author 10184538
 * @date 2019/4/23
 */
public class ThreadTest {

    private ExecutorService executorService = new ThreadPoolExecutor(5, 200, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024)
            , UserThreadFactory.build("store-plane"), new ThreadPoolExecutor.AbortPolicy());

    public void start() {
        List<String> data = new ArrayList<>();
        data.add("1111");
        data.add("1112");
        data.add("1113");
        data.add("1114");
        data.add("1115");

        data.forEach(k -> {
            Future<?> submit = executorService.submit(TtlRunnable.get(() -> {
                        System.out.println("ThreadName:" + Thread.currentThread().getName());
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("content:" + k);
                    }
            ));
            try {
                submit.get();//必须加阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        //也要阻塞
        System.out.println("bbbbbbbbbbbbbbbbbb");
        executorService.shutdown();
        boolean done = false;
        try {
            done = executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
        }
        System.out.println(done);
    }

    public void start2() throws ExecutionException, InterruptedException {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            data.add("abc" + i);
        }

        Future<?> submit = executorService.submit(TtlRunnable.get(() -> {
            System.out.println("ThreadName:" + Thread.currentThread().getName());
            try {
                Thread.sleep(12000);
                data.forEach(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        submit.get();//必须阻塞住
        System.out.println("aaaaaaaaaaa");
        executorService.shutdown();
        boolean done = false;
        try {
            done = executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
        }
        System.out.println(done);
    }


    public void start3() {
        List<String> data = new ArrayList<>();
        data.add("1111");
        data.add("1112");
        data.add("1113");
        data.add("1114");
        data.add("1115");

        data.parallelStream().forEach(k -> {
            Future<?> submit = executorService.submit(TtlRunnable.get(() -> {
                        System.out.println("ThreadName:" + Thread.currentThread().getName());
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("content:" + k);
                    }
            ));
            try {
                submit.get();//必须加阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        //也要阻塞
        System.out.println("bbbbbbbbbbbbbbbbbb");
        executorService.shutdown();
        boolean done = false;
        try {
            done = executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
        }
        System.out.println(done);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadTest test = new ThreadTest();
        test.start3();
    }
}

