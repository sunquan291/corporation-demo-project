package com.zte.sunquan.thread.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BgpMessageHandlerThread extends Thread {

    private static final int QUEUE_CAPACITY = 100;

    private BlockingQueue<Message> queue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

    public BgpMessageHandlerThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            while (true) {
                Message message = (Message) queue.take();
                //模拟慢消费数据
                Thread.sleep(200);
                System.out.println("Handled message id:" + message.getId() + " in thread: " + Thread.currentThread().getName());
                System.out.println(message);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void handleMessage(Message message) {
        try {
            queue.put(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
