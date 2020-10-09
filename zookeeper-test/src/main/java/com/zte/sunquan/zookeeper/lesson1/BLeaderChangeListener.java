package com.zte.sunquan.zookeeper.lesson1;

import org.apache.curator.framework.recipes.leader.LeaderLatchListener;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Livio
 * @Date: 2020/9/24 22:21
 */
public class BLeaderChangeListener implements LeaderLatchListener {
    private String threadName;
    private ScheduledExecutorService executorService;

    public BLeaderChangeListener(String threadName, ScheduledExecutorService executorService) {
        this.threadName = threadName;
        this.executorService = executorService;
    }

    @Override
    public void isLeader() {
        System.out.println(threadName + " is leader.");
        executorService.scheduleAtFixedRate(() -> {
            System.out.println("test with " + threadName);
        }, 1000, 3000, TimeUnit.MILLISECONDS);
    }

    @Override
    public void notLeader() {
        System.out.println(threadName + " is not leader.");
        executorService.shutdown();
    }
}
