package com.zte.sunquan.demo.disruptor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.lmax.disruptor.BatchEventProcessor;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SequenceBarrier;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.junit.Test;

/**
 * Created by 10184538 on 2018/4/9.
 */
public class DisruptorTest {
    private Object lock = new Object();
    private static final int COUNT = 5;

    @Test
    public void testDisruptor() throws InterruptedException {
        ThreadFactory factory = new ThreadFactoryBuilder().setPriority(Thread.NORM_PRIORITY)
                .setDaemon(false)
                .setNameFormat("DOMNotificationRouter-%d")
                .build();
        ExecutorService executors = Executors.newCachedThreadPool(factory);
        final RingBuffer<UserEvent> ringBuffer = RingBuffer
                .createSingleProducer(UserEvent.FACTORY, //事件工厂
                        2,//RingBuffer的大小，2的指数
                        new BlockingWaitStrategy());//等待策略（无可用块时）

        //消费者没有等待生产者？？
        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();
        BatchEventProcessor<UserEvent> processor1 = new BatchEventProcessor<UserEvent>(
                ringBuffer, sequenceBarrier, new UserEventHandler(
                "UserEventHandler_A"));
        executors.submit(processor1);
        ringBuffer.addGatingSequences(processor1.getSequence());
        //生产
        CountDownLatch latch = new CountDownLatch(COUNT);
        for (int i = 0; i < COUNT; i++) {
            long next = 0;
            try {
//                next = ringBuffer.tryNext();
                next = ringBuffer.next();
                UserEvent userEvent = ringBuffer.get(next);
                System.out.println("i=" + i + ",next=" + next + ",value=" + userEvent.getValue());
                userEvent.setValue("add " + i);
            }
//            catch (final InsufficientCapacityException e) {
//                System.out.println("ERROR next reject :" + next);
//            }
            catch (Exception e) {
                System.out.println("exception:" + e.getMessage());
            } finally {
                ringBuffer.publish(next);//!!!如果进行event的修改，那publish与set，应该是一个原子操作
                //考虑，你修改了环里某个数据（且该数据还未被消费），而publish被阻塞，则会产生幻读
                //所以建议在消费者中，不要进行数据的修改
                latch.countDown();
            }

        }
        latch.await();
        new Scanner(System.in).next();
        processor1.halt();
        executors.shutdown();
    }

    @Test
    public void testDis2() {
        /*
     * createSingleProducer创建一个单生产者的RingBuffer，
     * 第一个参数叫EventFactory，从名字上理解就是“事件工厂”，其实它的职责就是产生数据填充RingBuffer的区块。
     * 第二个参数是RingBuffer的大小，它必须是2的指数倍 目的是为了将求模运算转为&运算提高效率
     * 第三个参数是RingBuffer的生产都在没有可用区块的时候(可能是消费者（或者说是事件处理器） 太慢了)的等待策略
     */
//        final RingBuffer<UserEvent> ringBuffer = RingBuffer
//                .createSingleProducer(UserEvent.FACTORY, 2,
//                        new SleepingWaitStrategy());

        final RingBuffer<UserEvent> ringBuffer = RingBuffer
                .createSingleProducer(UserEvent.FACTORY, 2,
                        new BlockingWaitStrategy());
        // 创建线程池
        ExecutorService executors = Executors.newCachedThreadPool();
        // 创建SequenceBarrier
        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();

        // 创建消息处理器 ,消费者
        BatchEventProcessor<UserEvent> processor1 = new BatchEventProcessor<UserEvent>(
                ringBuffer, sequenceBarrier, new UserEventHandler(
                "EventHandler_01"));
        // 传入所有消费者线程的序号,如果只有一个消费者的情况可以省略
        ringBuffer.addGatingSequences(processor1.getSequence());
        // 把消息处理器提交到线程池
        executors.submit(processor1);
        // 如果存在多个消费者 那重复执行上面3行代码 把SimpleHandler换成其它消费者类

//        BatchEventProcessor<UserEvent> processor2 = new BatchEventProcessor<UserEvent>(
//                ringBuffer, sequenceBarrier, new UserEventHandler(
//                "EventHandler_02"));
//        ringBuffer.addGatingSequences(processor2.getSequence());
//        executors.submit(processor2);
        // 两个消费者会消费一样的事件

        // 生产者
        SimpleEventProducer producer = new SimpleEventProducer(ringBuffer);
        for (int i = 0; i < COUNT; i++) {
            producer.onData(String.valueOf(i));
        }
//        processor1.halt();// 通知事件(或者说消息)处理器可以结束了（并不是马上结束!!!）
//        processor2.halt();
//        executors.shutdown();// 终止线程

        new Scanner(System.in).next();
    }

    @Test
    public void testDis() {
        final RingBuffer<UserEvent> ringBuffer = RingBuffer
                .createSingleProducer(UserEvent.FACTORY, 2,
                        new BlockingWaitStrategy());
        ExecutorService executors = Executors.newCachedThreadPool();
        // 创建SequenceBarrier
        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();
        // 创建消息处理器 ,消费者EventHandler_01
        BatchEventProcessor<UserEvent> processor1 = new BatchEventProcessor<UserEvent>(
                ringBuffer, sequenceBarrier, new UserEventHandler(
                "EventHandler_01"));
        // 传入所有消费者线程的序号,如果只有一个消费者的情况可以省略
        ringBuffer.addGatingSequences(processor1.getSequence());
        // 把消息处理器提交到线程池
        executors.submit(processor1);

        SequenceBarrier stepTwoSequenceBarrier = ringBuffer
                .newBarrier(processor1.getSequence());

        // 创建消息处理器 ,消费者EventHandler_02
        BatchEventProcessor<UserEvent> processor2 = new BatchEventProcessor<UserEvent>(
                ringBuffer, stepTwoSequenceBarrier, new UserEventHandler(
                "EventHandler_02"));


        ringBuffer.addGatingSequences(processor2.getSequence());
        executors.submit(processor2);
        // 生产者
        SimpleEventProducer producer = new SimpleEventProducer(ringBuffer);
        for (int i = 0; i < COUNT; i++) {
            producer.onData(String.valueOf(i));
        }
//        processor1.halt();// 通知事件(或者说消息)处理器可以结束了（并不是马上结束!!!）
//        processor2.halt();
//        executors.shutdown();// 终止线程
        new Scanner(System.in).next();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        long result = 0;
        while (num > 0) {
            result += num % 10;
            num = (int) num / 10;
        }
        System.out.println(result);

    }
}
