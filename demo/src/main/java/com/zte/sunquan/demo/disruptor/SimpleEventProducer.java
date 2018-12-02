package com.zte.sunquan.demo.disruptor;

/**
 * Created by sunquan on 2018/4/9.
 */

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

public class SimpleEventProducer {
    private final RingBuffer<UserEvent> ringBuffer;

    public SimpleEventProducer(RingBuffer<UserEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    private static final EventTranslatorOneArg TRANSLATOR = new EventTranslatorOneArg<UserEvent, String>() {
        @Override
        public void translateTo(UserEvent event, long sequence, String value) {
            System.out.println("Producer --- sequence=" + sequence + ", event = "
                    + value);
            event.setValue(value);
        }
    };

    /**
     * onData用来发布事件
     *
     * @param value
     */
    public void onData(final String value) {
        ringBuffer.publishEvent(TRANSLATOR, value);
    }

}