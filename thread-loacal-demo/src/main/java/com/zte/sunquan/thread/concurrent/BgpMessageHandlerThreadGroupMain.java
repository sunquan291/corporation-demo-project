package com.zte.sunquan.thread.concurrent;

public class BgpMessageHandlerThreadGroupMain {

    /**
     * 如果是100线程，200ms一次处理（包括入库），理论上的吞吐量是 500*60=3w即每分钟3w
     *
     * @param args
     */
    public static void main(String[] args) {
        BgpMessageHandlerThreadGroup threadGroup = new BgpMessageHandlerThreadGroup();
        threadGroup.start();
        for (int i = 0; i < 100; i++) {
            Message message = new Message();
            message.setId("sunquan" + i);
            message.setContent("sunquan loves " + i);
            threadGroup.handleMessage(message);
        }
        System.out.println("end");
    }
}
