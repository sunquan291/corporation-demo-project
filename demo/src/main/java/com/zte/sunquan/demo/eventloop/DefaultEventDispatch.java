package com.zte.sunquan.demo.eventloop;

import com.google.common.collect.Queues;
import com.zte.sunquan.demo.executor.GroupedThreadFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 10184538 on 2017/4/15.
 */
public class DefaultEventDispatch {

    private ExecutorService execute;
    private ExecutorService eventService;
    private BlockingQueue eventQueue;

    public DefaultEventDispatch() {
        init();
    }

    private void init() {
        eventQueue = Queues.newLinkedBlockingQueue();
        eventService = Executors.newFixedThreadPool(4, GroupedThreadFactory.groupedThreadFactory("event-handler"));
        execute = Executors.newFixedThreadPool(1, GroupedThreadFactory.groupedThreadFactory("event-dispatch"));
        execute.submit(this::start);
    }

    private void start() {
        while (true) {
            try {
                //1.get event
                Object event = eventQueue.take();
                System.out.println(event);
                //2. get event listener
                eventService.submit(this::process);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void process() {
        //start watchdog
    }

    public void postEvent(String event) {
        eventQueue.offer(event);
    }
}
