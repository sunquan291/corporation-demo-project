package com.zte.sunquan.zookeeper.lesson1;

import com.google.common.collect.Lists;
import org.apache.curator.framework.AuthInfo;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @Author: Livio
 * @Date: 2020/9/23 22:48
 */
public class AZookeeper {
    public static void main(String[] args) throws Exception {
        AuthInfo authInfo = new AuthInfo("digest", "u2:u2".getBytes());
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().connectString("localhost:2181")
                .sessionTimeoutMs(5000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .authorization(Lists.newArrayList(authInfo))
                .connectionTimeoutMs(4000).build();
        curatorFramework.start();
        //创建节点
//        curatorFramework.create().creatingParentsIfNeeded()
//                .withMode(CreateMode.PERSISTENT)
//                .forPath("/second1", "sunquan hello".getBytes());
        //更新节点
//        curatorFramework.setData().forPath("/first", "sunquan update".getBytes());
        //异步创建节点
//        CountDownLatch latch = new CountDownLatch(1);
//        curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL)
//                .inBackground(new BackgroundCallback() {
//                    @Override
//                    public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
//                        System.out.println("Thread name:" + Thread.currentThread().getName());
//                        System.out.println(curatorEvent.getResultCode());
//                        latch.countDown();
//                    }
//                }).forPath("/third5", "sunquan 3".getBytes());
//        latch.await();
//
//        ACL acl1 = new ACL(ZooDefs.Perms.CREATE | ZooDefs.Perms.DELETE, new Id("digest", DigestAuthenticationProvider.generateDigest("u1:u1")));
//        ACL acl2 = new ACL(ZooDefs.Perms.ALL, new Id("digest", DigestAuthenticationProvider.generateDigest("u2:u2")));
//        curatorFramework.create().
//                withMode(CreateMode.PERSISTENT)
//                .withACL(Lists.newArrayList(acl1, acl2))
//                .forPath("/third6", "sunquan 3".getBytes());

        String s = new String(curatorFramework.getData().forPath("/third6"));
        System.out.println(s);

        //PathChildrenCache
        //TreeCache
        NodeCache nodeCache = new NodeCache(curatorFramework, "/third6", false);
        NodeCacheListener listener = new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                ChildData currentData = nodeCache.getCurrentData();
                System.out.println("path=" + currentData.getPath());
                System.out.println("data=" + new String(currentData.getData()));
            }
        };
        nodeCache.getListenable().addListener(listener);
        nodeCache.start();

        System.in.read();

    }
}
