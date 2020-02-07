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

public class BatchQueueImplBack<T> implements BatchQueue<T> {
    private static final String BATCH_COMMIT_THREAD = "batch-commit";
    private int batchSize;
    private final Consumer<List> consumer;
    private int timeoutInMs;

    private AtomicBoolean isLooping = new AtomicBoolean(false);
//private BlockingQueue queue = new LinkedBlockingQueue<>();
    /**
     * 可以进行反压支持
     */
    private BlockingQueue queue = new ArrayBlockingQueue<>(100);
    private AtomicLong start = new AtomicLong(System.currentTimeMillis());

    private String name;

    public BatchQueueImplBack(String name, int batchSize, int timeoutInMs, Consumer<List> consumer) {
        this.batchSize = batchSize;
        this.timeoutInMs = timeoutInMs;
        this.consumer = consumer;
    }

    public BatchQueueImplBack(int batchSize, Consumer<List> consumer) {
        this("default", batchSize, 5000, consumer);
    }

    private void startLoop() {
        ExecutorService service = Executors.newFixedThreadPool(1, UserThreadFactory.build(BATCH_COMMIT_THREAD));
        service.submit(() -> {
            start = new AtomicLong(System.currentTimeMillis());
            while (true) {
                long last = System.currentTimeMillis() - start.get();
                if (queue.size() >= batchSize) {
                    System.out.println("batch commit");
                    if ((queue.size() / batchSize) > 3) {
                        batchSize = batchSize * batchSize;
                        timeoutInMs = timeoutInMs * 2;
                    } else {
                        batchSize = batchSize / 2;
                        timeoutInMs = timeoutInMs / 2;
                    }
                    drainToConsume();
                } else if ((!queue.isEmpty() && last > timeoutInMs)) {
                    System.out.println("timeout commit");
                    drainToConsume();
                } else if (queue.isEmpty()) {
                    isLooping.set(false);
                    break;
                }

// if (queue.size() >= batchSize || (!queue.isEmpty() && last > timeoutInMs)) {
// drainToConsume();
// } else if (queue.isEmpty()) {
// isLooping.set(false);
// break;
// }
            }
            service.shutdown();
        });
    }

    private void drainToConsume() {
        List<T> drained = new ArrayList<>();
        System.out.println("queue size:" + queue.size());
        int num = queue.drainTo(drained, batchSize);
        if (num > 0) {
            consumer.accept(drained);
            start.set(System.currentTimeMillis());

            //long a = (getCommitSize() * getTimeOut()) / (5 * (getCommitSize() - 1));
            //System.out.println("A==" + a);
            long b = start.longValue() - beginTime.longValue();
            System.out.println("B==" + b);
            if (start.longValue() - beginTime.longValue() > getTimeOut()) {
                //调整
                //batchSize = batchSize * 2;
                //timeoutInMs = timeoutInMs * 2;
                System.out.println("batchSize:" + batchSize);
                System.out.println("timeoutInMs:" + timeoutInMs);

            }
            beginTime.set(System.currentTimeMillis());

        }
    }

    private AtomicLong beginTime = new AtomicLong(System.currentTimeMillis());
// @Override
// public boolean add(T t) {
// boolean result = queue.add(t);
// if (!isLooping.get() && result) {
// isLooping.set(true);
// startLoop();
// }
// return result;
// }

    @Override
    public boolean add(T t) {
        System.out.println("before add data queue.size=" + queue.size());
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