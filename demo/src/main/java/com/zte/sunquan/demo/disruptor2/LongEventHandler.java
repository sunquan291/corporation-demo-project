package com.zte.sunquan.demo.disruptor2;

import com.google.common.base.Throwables;
import com.lmax.disruptor.EventHandler;

/**
 * Created by sunquan on 2018/4/12.
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent longEvent, final long sequence, final boolean endOfBatch) throws Exception {
        System.out.println("Consumer:" + longEvent.getValue() + ",sequence:" + sequence);
        Thread.sleep(1000);
        //如里在消费Event中，不进行异常捕获，任其抛出，则会影响依赖事件处理器的等待，从而导致死循环
        //因为当前事件在异常退出后，是不会进行序列号的增加的，所以依赖该事件的线程会一直进行循环判断等待
//        try {
//            if (longEvent.getValue() == 50)
//                throw new IllegalStateException("50 is illegal integer.....");
//        } catch (Exception e) {
//            Throwables.propagate(e);
//        }
    }

}