package com.zte.sunquan.demo.disruptor2;

import com.lmax.disruptor.EventHandler;

/**
 * Created by 10184538 on 2018/4/12.
 */
public class AfterEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent longEvent, final long sequence, final boolean endOfBatch) throws Exception {
        System.out.println("after:" + longEvent.getValue() + ",sequence:" + sequence);
    }

}