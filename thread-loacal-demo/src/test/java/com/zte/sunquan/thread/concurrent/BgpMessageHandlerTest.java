package com.zte.sunquan.thread.concurrent;

import org.junit.Test;

public class BgpMessageHandlerTest {
    private BgpMessageHandlerThreadGroup threadGroup = new BgpMessageHandlerThreadGroup();

    @Test
    public void testThread() {
        threadGroup.start();
        for (int i = 0; i < 100; i++) {
            Message message = new Message();
            message.setId("sunquan" + i);
            message.setContent("sunquan loves " + i);
            threadGroup.handleMessage(message);
        }
    }
}
