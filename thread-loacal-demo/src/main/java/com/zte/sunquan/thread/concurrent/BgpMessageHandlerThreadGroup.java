package com.zte.sunquan.thread.concurrent;

import java.util.ArrayList;
import java.util.List;

public class BgpMessageHandlerThreadGroup {
    private static final int THREAD_COUNT = 16;//2的N次方
    private List<BgpMessageHandlerThread> threads = new ArrayList<>();

    public BgpMessageHandlerThreadGroup() {
        init();
    }


    private void init() {
        for (int i = 0; i < THREAD_COUNT; i++) {
            BgpMessageHandlerThread thread = new BgpMessageHandlerThread("bgp-thread-" + i);
            threads.add(thread);
        }
    }

    public void handleMessage(Message message) {
        //int queueIndex = (message.getId().hashCode() & Integer.MAX_VALUE) % THREAD_COUNT;
        int queueIndex = (message.getId().hashCode() & Integer.MAX_VALUE) & (THREAD_COUNT - 1);
        System.out.println("Add message with id:" + message.getId() + " to queue:" + queueIndex);
        threads.get(queueIndex).handleMessage(message);
    }

    public void start() {
        threads.forEach(Thread::start);
    }
}
