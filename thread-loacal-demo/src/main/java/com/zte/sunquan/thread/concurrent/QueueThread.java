package com.zte.sunquan.thread.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueThread {
    private static final int THREAD_COUNT = 2;
    private static final int QUEUE_CAPACITY = 10;
    private List<Thread> threads = new ArrayList<>();
    private List<BlockingQueue<Message>> queues = new ArrayList<BlockingQueue<Message>>();

    public void init() {
        for (int i = 0; i < THREAD_COUNT; i++) {
            BlockingQueue queue = new ArrayBlockingQueue(QUEUE_CAPACITY);
            queues.add(queue);
            threads.add(new Thread(() -> {
                try {
                    while (true) {
                        Message message = (Message) queue.take();
                        //模拟慢消费数据
                        Thread.sleep(200);
                        System.out.println("Handled message id:"+message.getId()+" in thread: " + Thread.currentThread().getName());
                        System.out.println(message);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));
        }
        threads.forEach(Thread::start);
    }


    public void addMessge(Message message) {
        int queueIndex = (message.getId().hashCode() & Integer.MAX_VALUE) % THREAD_COUNT;
        System.out.println("Add message with id:" + message.getId() + " to queue:" + queueIndex);
        try {
            queues.get(queueIndex).put(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        QueueThread queueThread = new QueueThread();
        queueThread.init();
        for (int i = 0; i < 100; i++) {
            Message message = new Message();
            message.setId("sunquan" + i);
            message.setContent("sunquan loves " + i);
            queueThread.addMessge(message);
        }

    }

}
