package com.zte.sunqun.demo.queue;

import com.zte.sunquan.demo.future.complete.UserThreadFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

/**
 * @Author 10184538
 * @Date 2019/11/23 18:49
 **/
public class BatchQueueImpl2<T> implements BatchQueue<T> {
    private static final String BATCH_COMMIT_THREAD = "batch-commit";
    private int batchSize;
    private final Consumer<List> consumer;
    private final int elementProcessTime;
    private int timeoutInMs;

    private AtomicBoolean isLooping = new AtomicBoolean(false);
    /**
     * 可以进行反压支持
     */
    private BlockingQueue queue = new ArrayBlockingQueue<>(10);
    private AtomicLong start = new AtomicLong(System.currentTimeMillis());
    private String name;

    public BatchQueueImpl2(String name, int batchSize, int elementProcessTime, Consumer<List> consumer) {
        this.batchSize = batchSize;
        this.elementProcessTime = elementProcessTime;
        this.timeoutInMs = elementProcessTime * batchSize;
        this.consumer = consumer;
    }

    public BatchQueueImpl2(int batchSize, Consumer<List> consumer) {
        this("default", batchSize, 5000, consumer);
    }

    private void startLoop() {
        ExecutorService service = Executors.newFixedThreadPool(1, UserThreadFactory.build(BATCH_COMMIT_THREAD));
        service.submit(() -> {
            start = new AtomicLong(System.currentTimeMillis());
            while (true) {
                long last = System.currentTimeMillis() - start.get();
                int tempSize = queue.size() - batchSize;
                if (tempSize == 0) {
                    drainToConsume();
                } else if (tempSize > 0) {
//TDOO::超过队列长度，有无异常
                    batchSize = batchSize * 2;
                    timeoutInMs = elementProcessTime * batchSize;
                    drainToConsume();
                } else if ((!queue.isEmpty() && last > timeoutInMs)) {
                    drainToConsume();
                } else if (queue.isEmpty()) {
                    isLooping.set(false);
                    break;
                } else {
//<0 队列不为空

                    batchSize = batchSize / 2;
                    timeoutInMs = elementProcessTime * batchSize;
                    System.out.println("3-batch commit with batchSize:" + batchSize + ",and timeout:" + timeoutInMs);
                }
            }
            service.shutdown();
        });
    }

    private void drainToConsume() {
        List drained = new ArrayList<>();
        int num = queue.drainTo(drained, batchSize);
        if (num > 0) {
            consumer.accept(drained);
            start.set(System.currentTimeMillis());
        }
    }

    private AtomicLong beginTime = new AtomicLong(System.currentTimeMillis());

    @Override
    public boolean add(T t) {
//System.out.println(“queue.size=” + queue.size());
        try {
            queue.put(t);
            if (!isLooping.get()) {
                isLooping.set(true);
                startLoop();
            }
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public long getCommitSize() {
        return batchSize;
    }

    @Override
    public long getTimeOut() {
        return timeoutInMs;
    }

    @Override
    public void commit() {
        while (!queue.isEmpty()) {
            drainToConsume();
        }
    }

    @Override
    public long getQueueSize() {
        return queue.size();
    }
}