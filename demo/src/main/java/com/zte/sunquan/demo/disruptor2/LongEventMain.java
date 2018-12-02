package com.zte.sunquan.demo.disruptor2;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SequenceBarrier;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by sunquan on 2018/4/12.
 */
public class LongEventMain {
    private static final int CPUS = Runtime.getRuntime().availableProcessors();
    private static ThreadFactory build = new ThreadFactoryBuilder().setPriority(Thread.NORM_PRIORITY)
            .setDaemon(false)
            .setNameFormat("LongEventMain-%d")
            .build();
    //消费者1
    private static final LongEventHandler longEventHandler = new LongEventHandler();
    //消费者2
    private static final EventHandler<LongEvent> afterHandler = new EventHandler<LongEvent>() {
        @Override
        public void onEvent(final LongEvent event, final long sequence, final boolean endOfBatch) {
            System.out.println("afterHandler:" + sequence);
        }
    };

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(CPUS);
        //创建工厂
        LongEventFactory factory = new LongEventFactory();
        //创建bufferSize ,也就是RingBuffer大小，必须是2的N次方
        int ringBufferSize = 4 * 4; //
        //创建disruptor
        Disruptor<LongEvent> disruptor =
                new Disruptor<LongEvent>(factory, ringBufferSize, executor, ProducerType.MULTI,
                        new BlockingWaitStrategy());
        SequenceBarrier seqb = disruptor.handleEventsWith(longEventHandler).asSequenceBarrier();
//                .then(afterHandler);
        disruptor.after(longEventHandler).handleEventsWith(afterHandler);
        // 启动
        disruptor.start();
        //生产者
        ExecutorService executor2 = Executors.newFixedThreadPool(CPUS);
        executor2.submit(new Runnable() {
            @Override
            public void run() {
                RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
                LongEventProducer producer = new LongEventProducer(ringBuffer);
                ByteBuffer byteBuffer = ByteBuffer.allocate(8);
                for (long l = 0; l < 100; l++) {
                    byteBuffer.putLong(0, l);
                    try {
                        producer.onData(byteBuffer);
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
