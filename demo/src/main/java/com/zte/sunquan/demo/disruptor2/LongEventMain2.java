package com.zte.sunquan.demo.disruptor2;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 10184538 on 2018/4/12.
 */
public class LongEventMain2 {

    private static final int CPUS = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) throws Exception {
        LongEventHandler longEventHandler = new LongEventHandler();
        AfterEventHandler afterEventHandler = new AfterEventHandler();
        ExecutorService executor = Executors.newFixedThreadPool(CPUS);
        LongEventFactory factory = new LongEventFactory();
        int ringBufferSize = 4 * 4; //

        Disruptor<LongEvent> disruptor =
                new Disruptor<LongEvent>(factory, ringBufferSize, executor, ProducerType.MULTI,
                        new BlockingWaitStrategy());
        disruptor.handleEventsWith(longEventHandler);//.then(afterEventHandler);
        disruptor.start();

        ExecutorService executor2 = Executors.newFixedThreadPool(CPUS);
        executor2.submit(new Runnable() {
            @Override
            public void run() {
                RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

                LongEventProducerWithTranslator producer = new LongEventProducerWithTranslator(ringBuffer);
                ByteBuffer byteBuffer = ByteBuffer.allocate(8);
                for (long l = 0; l < 200; l++) {
                    byteBuffer.putLong(0, l);
                    disruptor.publishEvent(producer.TRANSLATOR, byteBuffer);
                    System.out.println("eeeeee:" + l);
                }
            }
        });
    }


}
