package com.zte.sunquan.demo.executor;

import com.google.common.util.concurrent.AtomicDouble;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.sun.management.OperatingSystemMXBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;


/**
 * Created by sunquan on 2017/4/15.
 */
public final class DynamicExecutorFactory {
    private static final Logger logger = LoggerFactory.getLogger(DynamicExecutorFactory.class);
    private static final int DEFAULT_THRESHOLD = 4;
    private static AtomicDouble atomicDouble = new AtomicDouble(0L);
    private static final boolean USELOAD = false;
    private static final String GROUP_NAME = "dynamic-factory";

    private DynamicExecutorFactory() {
    }

    static {
        backgroundUpdate();
    }

    public static ExecutorService getExecutorService(int expiredNum) {
        return getExecutorService(USELOAD, expiredNum);
    }

    public static ExecutorService getExecutorService(boolean useLoad, int expiredNum) {
        int threads;
        if (useLoad) {
            threads = getThreadNum(expiredNum);
        } else {
            threads = expiredNum <= DEFAULT_THRESHOLD ? expiredNum : DEFAULT_THRESHOLD;
        }
        logger.info("create threads={} and expiredNum={}", threads, expiredNum);
        return Executors.newFixedThreadPool(threads, GroupedThreadFactory.groupedThreadFactory(GROUP_NAME));
    }

    private static int getThreadNum(int expiredNum) {
        if (expiredNum <= 2)
            return expiredNum;
        //注意第一次调用时，默认只给1个线程
        int threadNum = (int) (expiredNum * atomicDouble.get());
        return threadNum < 1 ? 1 : threadNum;
    }

    private static ThreadFactory getFactory(String groupName, String name, boolean daemon) {
        ThreadFactoryBuilder threadFactoryBuilder = new ThreadFactoryBuilder();
        threadFactoryBuilder.setNameFormat(name)
                .setThreadFactory(GroupedThreadFactory.groupedThreadFactory(groupName));
        threadFactoryBuilder.setDaemon(daemon);
        return threadFactoryBuilder.build();
    }

    private static void backgroundUpdate() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor(getFactory("dynamic-load-schedule", "s1", true));
        executorService.scheduleWithFixedDelay(new CalSysLoadTask(), 10, 3, TimeUnit.SECONDS);
    }

    private static class CalSysLoadTask implements Runnable {
        final OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        final MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        final ThreadMXBean thread = ManagementFactory.getThreadMXBean();

        @Override
        public void run() {
            double systemCpuLoad = 0;
            double processCpuLoad = 0;
            double usage = 0;
            double threadRadio = 0;
            double swapSpaceRadio = 0;
            try {
                systemCpuLoad = operatingSystemMXBean.getSystemCpuLoad();
                processCpuLoad = operatingSystemMXBean.getProcessCpuLoad();

                MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage();
                usage = (double) memoryUsage.getUsed() / (double) memoryUsage.getCommitted();

                double threadCount = (double) thread.getThreadCount();
                double peakThreadCount = (double) thread.getPeakThreadCount();
                threadRadio = 0L;
                if (threadCount < peakThreadCount) {
                    threadRadio = 1 - threadCount / peakThreadCount;
                } else {
                    threadRadio = 1 - peakThreadCount / threadCount;
                }

                long freeSwapSpaceSize = operatingSystemMXBean.getFreeSwapSpaceSize();
                long totalSwapSpaceSize = operatingSystemMXBean.getTotalSwapSpaceSize();
                swapSpaceRadio = (double) freeSwapSpaceSize / (double) totalSwapSpaceSize;
                atomicDouble.set((1 - systemCpuLoad) * 0.2 + (1 - processCpuLoad) * 0.2
                        + (1 - usage) * 0.1 + threadRadio * 0.3 + swapSpaceRadio * 0.2);
            } catch (Exception e) {
                logger.error("backgroundUpdate error =", e);
            } finally {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("systemCpuLoad:").append(systemCpuLoad)
                        .append("processCpuLoad:").append(processCpuLoad)
                        .append("usage:").append(usage)
                        .append("threadRadio:").append(threadRadio)
                        .append("swapSpaceRadio:").append(swapSpaceRadio)
                        .append("load:").append(atomicDouble.get());
                logger.info(stringBuilder.toString());
            }
        }
    }
}