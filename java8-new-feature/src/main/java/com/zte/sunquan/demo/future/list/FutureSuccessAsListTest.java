package com.zte.sunquan.demo.future.list;


import com.google.common.collect.Lists;
import com.google.common.util.concurrent.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * Created by sunquan on 2018/3/28.
 */
public class FutureSuccessAsListTest {
    ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

    ListenableFuture future1 = null;
    ListenableFuture future2 = null;

    private List<String> stringList = new ArrayList<>();

    @Before
    public void init() {

        for (int i = 0; i < 10000; i++) {
            stringList.add("content:" + i);
        }
//        List<CompletableFuture<Void>> futureList = partition.stream().map(p -> CompletableFuture.runAsync(() -> {
//            try {
//                //模拟耗时操作
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(p);
//        })).collect(Collectors.toList());
    }

    @SuppressWarnings("UnstableApiUsage")
    @Test
    public void testFuture() throws ExecutionException, InterruptedException {
        long current = System.currentTimeMillis();
        List<List<String>> partition = Lists.partition(stringList, 1000);
        List<? extends ListenableFuture<Integer>> futureList = partition.stream().map(p -> service.submit(() -> {
            try {
                //模拟耗时操作,核心还是这里面的耗时才是瓶颈
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println(Thread.currentThread().getName() + ":" + p);
            return p.size();
        })).collect(Collectors.toList());
        System.out.println("Map time:" + (System.currentTimeMillis() - current));
        ListenableFuture<List<Integer>> allFutures = Futures.successfulAsList(futureList);
        Futures.addCallback(allFutures, new FutureCallback<List<Integer>>() {

            @Override
            public void onSuccess(List<Integer> result) {
                int total = 0;
                for (Integer r : result) {
                    //System.out.println("Output: " + r);
                    total += r;
                }
                System.out.println(total);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("Output error " + t);

            }
        });
        System.out.println(allFutures.get());
        System.out.println("Total time:" + (System.currentTimeMillis() - current));
    }

}
