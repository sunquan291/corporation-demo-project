package com.zte.sunquan.demo.disruptor2;

import com.lmax.disruptor.EventFactory;

/**
 * Created by 10184538 on 2018/4/12.
 */
public class LongEventFactory  implements EventFactory {

    @Override
    public Object newInstance() {
        return new LongEvent();
    }
}
