package com.zte.sunquan.zookeeper.lesson1;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Author: Livio
 * @Date: 2020/9/24 22:10
 */
public class BZookeeper {
    public static void main(String[] args) throws Exception {
        String name = "abcd";
        if (args != null && args.length > 0) {
            name = args[0];
        }
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
                .connectString("localhost:2181")
                .sessionTimeoutMs(5000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .connectionTimeoutMs(4000).build();
        curatorFramework.start();
        long current=System.currentTimeMillis();
        CountDownLatch latch = new CountDownLatch(1);
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        LeaderLatch leaderLatch = new LeaderLatch(curatorFramework, "/leader");
        leaderLatch.addListener(new BLeaderChangeListener(name, scheduledExecutorService));
        leaderLatch.start();
        Thread.sleep(20000);
        leaderLatch.close();
        latch.await();

        Map<String,String> myMap=new HashMap<>();
        myMap.put("first","sunquan");


        //LeaderSelector leaderSelector=new LeaderSelector(curatorFramework,"/leader2");

    }
}
