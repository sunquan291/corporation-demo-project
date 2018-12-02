package com.zte.sunquan.demo.future;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.dispatch.OnComplete;
import akka.pattern.Patterns;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import javax.annotation.Nullable;
import org.junit.Before;
import org.junit.Test;
import scala.concurrent.Future;

/**
 * Created by 10184538 on 2018/3/28.
 */
public class FutureAsListTest {
    ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

    ListenableFuture future1 = null;
    ListenableFuture future2 = null;
    static ActorSystem system = ActorSystem.create("mysystem");

    @Before
    public void init() {

        future1 = service.submit(new Callable<Integer>() {
            public Integer call() throws InterruptedException {
                Thread.sleep(1000);
                System.out.println("call future 1.");
                return 1;
            }
        });
        future2 = service.submit(new Callable<Integer>() {
            public Integer call() throws InterruptedException {
                Thread.sleep(1000);
                System.out.println("call future 2.");
                //       throw new RuntimeException("----call future 2.");
                return 2;
            }
        });
    }

    @Test
    public void testAllAsList() throws Exception {
        //allAsList
        final ListenableFuture<List<Integer>> allFutures = Futures.allAsList(future1, future2);
        Futures.addCallback(allFutures, new FutureCallback<List<Integer>>() {

            @Override
            public void onSuccess(@Nullable List<Integer> result) {
                result.forEach(p -> {
                    System.out.println("output: " + p);
                });
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("Output error " + t);
            }
        });
        System.out.println(allFutures.get());
        Thread.sleep(2000);
//        call future 2.
//        call future 1.
//        [1, 2]
//        Output: 1
//        Output: 2
    }

    @Test
    public void testAllAsListWithException() throws Exception {
        future2.cancel(true);
        ListenableFuture future3 = service.submit(new Callable<Integer>() {
            public Integer call() throws InterruptedException {
                Thread.sleep(1000);
                System.out.println("call future 3.");
                throw new RuntimeException("----call future 3 error.");
            }
        });
        //allAsList
        final ListenableFuture<List<Integer>> allFutures = Futures.allAsList(future1, future3);
        Futures.addCallback(allFutures, new FutureCallback<List<Integer>>() {

            @Override
            public void onSuccess(@Nullable List<Integer> result) {
                for (Integer r : result)
                    System.out.println("Output: " + r);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("Output error " + t);

            }
        });
        System.out.println(allFutures.get());
//        call future 1.
//        call future 3.
//        Output error java.lang.RuntimeException: ----call future 3 error.
//        future3抛出异常，针对allAsList，直接走Failure流程，不管其它feture有没有正确完成
//        java.util.concurrent.ExecutionException: java.lang.RuntimeException: ----call future 3 errror.
    }

    @Test
    public void testAllAsListWithException2() throws Exception {
        future2.cancel(true);
        final SettableFuture<Object> settableFuture = SettableFuture.create();
        ActorRef print = system.actorOf(ReturnActor.props(), "print");

        //注意此处2秒超时，如果这个ask超时，下面的聚合后，还是会走onFailure
        //什么时候，会中断？
        Future<Object> ask = Patterns.ask(print, "how old are you", 2000);
        ask.onComplete(new OnComplete<Object>() {
            @Override
            public void onComplete(Throwable failure, Object o) throws Throwable {
                if (failure != null) {
                    settableFuture.setException(failure);
                } else
                    settableFuture.set(o);
            }
        }, system.dispatcher());

        //allAsList
        final ListenableFuture<List<Integer>> allFutures = Futures.allAsList(future1, settableFuture);
        Futures.addCallback(allFutures, new FutureCallback<List<Integer>>() {

            @Override
            public void onSuccess(@Nullable List<Integer> result) {
                for (Integer r : result)
                    System.out.println("Output: " + r);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("Output error " + t);
            }
        });
        System.out.println(allFutures.get());
    }

    @Test
    public void testSuccessfulAsListWithException() throws Exception {
        future2.cancel(true);
        ListenableFuture future4 = service.submit(new Callable<Integer>() {
            public Integer call() throws InterruptedException {
                Thread.sleep(1000);
                System.out.println("call future 4.");
                throw new RuntimeException("----call future 4.");
            }
        });
        //successfulAsList
        final ListenableFuture<List<Integer>> allFutures = Futures.successfulAsList(future1, future4);
        Futures.addCallback(allFutures, new FutureCallback<List<Integer>>() {

            @Override
            public void onSuccess(@Nullable List<Integer> result) {
                for (Integer r : result)
                    System.out.println("Output: " + r);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("Output error " + t);

            }
        });
        System.out.println(allFutures.get());
//        call future 1.
//        call future 4.
//        对于future4抛出异常，其返回值为null,聚合Future不会走failure流程
//        [1, null]
//        Output: 1
//        Output: null
    }

    @Test
    public void should_test_furture() throws Exception {
        //allAsList
        final ListenableFuture<List<Integer>> allFutures = Futures.allAsList(future1, future2);
        Futures.addCallback(allFutures, new FutureCallback<List<Integer>>() {

            @Override
            public void onSuccess(@Nullable List<Integer> result) {
                for (Integer r : result)
                    System.out.println("Output: " + r);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("Output error " + t);

            }
        });
        //Futures transform可以进一步重定义结果
        final ListenableFuture transform = Futures.transform(allFutures, new AsyncFunction<List<Integer>, Boolean>() {
            @Override
            public ListenableFuture apply(List<Integer> results) throws Exception {
                if (results.size() == 2)
                    return Futures.immediateFuture(true);
                else
                    return Futures.immediateFuture(false);
            }
        });

        Futures.addCallback(transform, new FutureCallback<Object>() {

            public void onSuccess(Object result) {
                System.out.println("success with: " + result);
            }

            public void onFailure(Throwable thrown) {

                System.out.printf("onFailure%s\n", thrown.getMessage());
            }
        });

        System.out.println(transform.get());
//        call future 1.
//        call future 2.
//        Output: 1
//        Output: 2
//        true
//        success with: true
    }
}
