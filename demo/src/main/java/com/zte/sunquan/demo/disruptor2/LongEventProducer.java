package com.zte.sunquan.demo.disruptor2;

import com.lmax.disruptor.RingBuffer;
import java.nio.ByteBuffer;

/**
 * Created by 10184538 on 2018/4/12.
 */
public class LongEventProducer {

    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    /**
     * onData用来发布事件，每调用一次就发布一次事件
     * 它的参数会用过事件传递给消费者
     */
    public void onData(ByteBuffer bb) throws Exception {
//        //1.可以把ringBuffer看做一个事件队列，那么next就是得到下面一个事件槽
//        long sequence = ringBuffer.next();
//        try {
//            //2.用上面的索引取出一个空的事件用于填充（获取该序号对应的事件对象）
//            LongEvent event = ringBuffer.get(sequence);
//            //3.获取要通过事件传递的业务数据
//            event.setValue(bb.getLong(0));
//        } finally {
//            //4.发布事件
//            //注意，最后的 ringBuffer.publish 方法必须包含在 finally 中以确保必须得到调用；
//            // 如果某个请求的 sequence 未被提交，将会堵塞后续的发布操作或者其它的 producer。
//            ringBuffer.publish(sequence);
//        }
        ////////////////////////
        long sequence = ringBuffer.next();

        LongEvent event = ringBuffer.get(sequence);
        event.setValue(bb.getLong(0));
        //生产者，中如果进行了异常抛出，而不处理，则程序会进行waiting状态，因为该生产者会一直占用该事件槽，
        //导致消费者无法使用该事件槽，等待占用的使用完成，所以一定要在final中执行ringBuffer.publish
        // cursor.set(sequence);
        if (event.getValue() == 50)
            throw new Exception("unknow exception....");
        ringBuffer.publish(sequence);
        System.out.println("lequence::::" + sequence);

    }

}