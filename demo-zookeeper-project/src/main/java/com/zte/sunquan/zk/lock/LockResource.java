package com.zte.sunquan.zk.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

/**
 * Created by 10184538 on 2018/6/1.
 */
public class LockResource {
    private static final Logger LOG = LoggerFactory.getLogger(LockResource.class);
    private ZooKeeper zk;
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    public LockResource(ZooKeeper zk) {
        this.zk = zk;
    }

    public boolean getLock(String lockPath) {
        Preconditions.checkState(zk.getState() == ZooKeeper.States.CONNECTED);
        boolean lock = false;
        try {
            if (zk.exists(lockPath, false) == null) {
                String s = zk.create(lockPath, "m".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                System.out.println(Thread.currentThread().getName() + ":" + s);
                lock = true;
                countDownLatch = new CountDownLatch(1);
                return lock;
            }
            System.out.println(Thread.currentThread().getName() + ":abc");
            //获取不到锁(已经存在该列表)
            if (zk.exists(lockPath, false) != null) {
                zk.getChildren(lockPath, new Watcher() {
                    @Override
                    public void process(WatchedEvent watchedEvent) {
                        System.out.println(watchedEvent.getPath() + ":" + watchedEvent.getType());
                        countDownLatch.countDown();
                    }
                });
                countDownLatch.await();
                return getLock(lockPath);

            }
        } catch (Exception e) {
            LOG.error("Get Lock Error", e);
            e.printStackTrace();
        }
        return lock;
    }

    public boolean unLock(String lockPath) {
        try {
            if (zk.exists(lockPath, false) != null) {
                zk.delete(lockPath, 0);
                TimeUnit.SECONDS.sleep(4);
                //解锁需要通知等待锁的线程(或者借助getLock中的监听得知)
//                countDownLatch.countDown();
                return true;
            }
        } catch (Exception e) {
            LOG.error("UnLock Lock Error", e);
            e.printStackTrace();
        }

        return false;
    }
}
