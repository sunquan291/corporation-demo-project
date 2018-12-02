package com.zte.sunquan.demo.akka.ask;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.dispatch.Futures;
import akka.dispatch.Mapper;
import akka.dispatch.OnComplete;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.compat.java8.FutureConverters;
import scala.concurrent.Future;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.JdkFutureAdapters;
import com.google.common.util.concurrent.ListenableFuture;

/**
 * Created by 10184538 on 2018/6/2.
 */
public class MessageHandlerActor extends AbstractActor {

    public static Props props() {
        return Props.create(MessageHandlerActor.class);
    }

    Timeout waitTime = new Timeout(5, TimeUnit.SECONDS);
    private ActorRef aOper = getContext().actorOf(AOperationActor.props(), "aOperaction");
    private ActorRef bOper = getContext().actorOf(BOperationActor.props(), "bOperaction");

    @Override
    public Receive createReceive() {

        return receiveBuilder().match(Message.class, p -> p.getId() == 1, p -> {
            //id=1的操作
            System.out.println(p.toString());

            Future<Object> aResult = Patterns.ask(aOper, p, waitTime);
            Future<Object> bResult = Patterns.ask(bOper, p, waitTime);

            //注意ask是异步的，接下来可以进行其它的操作，但要处理ask返回future的回调
            aResult.onComplete(new OnComplete<Object>() {
                @Override
                public void onComplete(Throwable throwable, Object result) throws Throwable {
                    if (throwable == null) {
                        System.out.println("AResult:" + result);
                    }
                }
            }, getContext().dispatcher());

            FutureConverters.toJava(bResult).whenComplete((r, e) -> {
                if (e == null) {
                    System.out.println("BResult:" + r);
                }
            });

            //模拟其它处理
            Thread.sleep(3000);
        }).match(Message.class, p -> p.getId() == 2, p -> {
            //id=2的操作,要求A,B都处理完
            System.out.println(p.toString());

            Future<Object> aResult = Patterns.ask(aOper, p, waitTime);
            Future<Object> bResult = Patterns.ask(bOper, p, waitTime);
            //有顺序，保证aOper先返回
            final Future<String> aggResult = Futures.sequence(
                    Lists.newArrayList(aResult, bResult), getContext().dispatcher())
                    .map(new Mapper<Iterable<Object>, String>() {
                        @Override
                        public String apply(Iterable<Object> parameter) {
                            StringBuilder sb = new StringBuilder();
                            Iterator<Object> iterator = parameter.iterator();
                            while (iterator.hasNext()) {
                                sb.append(iterator.next());
                            }
                            return sb.toString();
                        }
                    }, getContext().dispatcher());

            aggResult.onComplete(new OnComplete<String>() {
                @Override
                public void onComplete(Throwable throwable, String s) throws Throwable {
                    if (throwable == null && aggResult.isCompleted())
                        System.out.println("Result:" + aggResult.value());
                    else
                        System.out.println(throwable);
                }
            }, getContext().dispatcher());

        }).match(Message.class, p -> p.getId() == 3, p -> {
            //id=2的操作,要求A,B都处理完
            System.out.println(p.toString());

            Future<Object> aResult = Patterns.ask(aOper, p, waitTime);
            Future<Object> bResult = Patterns.ask(bOper, p, waitTime);

            ListenableFuture<Object> aListenableResult = JdkFutureAdapters.listenInPoolThread(FutureConverters.toJava(aResult).toCompletableFuture());
            ListenableFuture<Object> bListenableResult = JdkFutureAdapters.listenInPoolThread(FutureConverters.toJava(bResult).toCompletableFuture());

            //有顺序的
            ListenableFuture<List<Object>> aggFutures = com.google.common.util.concurrent.Futures.successfulAsList(aListenableResult, bListenableResult);

            com.google.common.util.concurrent.Futures
                    .addCallback(aggFutures, new FutureCallback<List<Object>>() {
                        @Override
                        public void onSuccess(List<Object> result) {
                            for (Object obj : result) {
                                System.out.println("Got result:" + obj);
                            }
                        }

                        @Override
                        public void onFailure(Throwable t) {
                            System.out.println(t);
                        }
                    });


        })
                .match(Message.class, p -> p.getId() == 4, p -> {
                    //id=2的操作,要求A,B都处理完
                    System.out.println(p.toString());

                    Future<Object> aResult = Patterns.ask(aOper, p, waitTime);
                    Future<Object> bResult = Patterns.ask(bOper, p, waitTime);

                    CompletableFuture<Object> bFutrue = FutureConverters.toJava(bResult).toCompletableFuture();

                    FutureConverters.toJava(aResult).toCompletableFuture()
                            .thenAcceptBoth(bFutrue, (x, y) -> {
                                System.out.println("Got result:" + x + ":" + y);
                            });
                })
                .build();
    }
}
