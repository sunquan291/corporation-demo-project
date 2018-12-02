package com.zte.sunquan.demo.disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import java.util.concurrent.TimeUnit;

/**
 * Created by sunquan on 2018/4/9.
 * EventHandlers是BatchEventProcessor要用到的，
 * WorkHandler是WorkerPool要用到的。为简便放在了一起
 */
public class UserEventHandler implements EventHandler<UserEvent>,
        WorkHandler<UserEvent> {
    private String handlerName;

    public UserEventHandler(String handlerName) {
        this.handlerName = handlerName;
    }

    @Override
    public void onEvent(UserEvent event, long sequence, boolean endOfBatch) throws Exception {
//        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Consumer:" + sequence + ":" + handlerName + " before  deal : " + "Event: " + event.getValue());
        //重新设置消费的值
        event.setValue(event.getValue() + "--" + handlerName);//不能进行事件的修改
        //消费者在等待生产者生产数据时，可能拿到的是上一个消费者设置的旧数据？？
        System.out.println("Consumer:" + sequence + ":" + handlerName + " after  deal : " + "Event: " + event.getValue());
    }

    @Override
    public void onEvent(UserEvent event) throws Exception {
//        TimeUnit.MILLISECONDS.sleep(100);
        event.setValue(event.getValue() + "--" + handlerName);
        System.out.println(handlerName + " after  deal : "
                + " Event: " + event.getValue());
    }
}
