package com.zte.sunquan.demo.actor.ask;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.DeadLetterActorRef;
import akka.actor.Props;
import akka.dispatch.Futures;
import akka.dispatch.Mapper;
import akka.dispatch.OnComplete;
import akka.pattern.Patterns;
import akka.util.Timeout;
import com.google.common.collect.Lists;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import static akka.pattern.Patterns.pipe;

/**
 * Created by 10184538 on 2017/10/10.
 */
public class ProcessActor extends AbstractActor {
    final Timeout timeout = new Timeout(Duration.create(5, TimeUnit.SECONDS));
    private ActorRef sub1Actor = getContext().actorOf(ProcessSub1Actor.props());
    private ActorRef sub2Actor = getContext().actorOf(ProcessSub2Actor.props());
    private ActorRef printActor = getContext().actorOf(PrintActor.props());

    public static Props props() {
        return Props.create(ProcessActor.class);
    }
    public static Props props(String name) {
        return Props.create(ProcessActor.class,name);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(String.class, p -> {
            System.out.println("ProcessActor receive:" + p);
//            Thread.sleep(6000);
            getSender().tell("process success", getSelf());
        }).match(Message.class, p -> {
            //多actor参与计算-->最后合并结果
            Future<Object> process1 = Patterns.ask(sub1Actor, p, timeout);
            Future<Object> process2 = Patterns.ask(sub2Actor, p, timeout);

            //主要是为了控制返回结果顺序
            final Future<Iterable<Object>> aggregate = Futures.sequence(
                    Lists.newArrayList(process1, process2),
                    getContext().system().dispatcher());
            //可使用get直接获取结果，这里使用map对结果进行转换
            final Future<String> aggResult = aggregate.map(
                    new Mapper<Iterable<Object>, String>() {
                        public String apply(Iterable<Object> coll) {
                            final Iterator<Object> it = coll.iterator();
                            final String process1Result = (String) it.next();
                            final String process2Result = (String) it.next();
                            return process1Result + "---" + process2Result;
                        }
                    }, getContext().system().dispatcher());

            // aggregated result is piped to another actor
            if (getSender() == null || getSender() == ActorRef.noSender()
                    || getSender() instanceof DeadLetterActorRef) {

                aggResult.onComplete(new OnComplete<String>() {
                    @Override
                    public void onComplete(Throwable throwable, String s) throws Throwable {
                        if (throwable == null&&aggResult.isCompleted())
                            System.out.println("Result:" + aggResult.value());
                        else
                            System.out.println(throwable);
                    }
                }, getContext().system().dispatcher());
            } else {
//                pipe(aggResult, getContext().system().dispatcher()).to(
//                        printActor);
                pipe(aggResult, getContext().system().dispatcher()).to(
                        getSender());
            }
        })
                .build();
    }
}
