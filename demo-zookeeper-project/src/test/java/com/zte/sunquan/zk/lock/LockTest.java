package com.zte.sunquan.zk.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by 10184538 on 2018/6/1.
 */
public class LockTest {
    private ZooKeeper zk;

    @Before
    public void init() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        zk = new ZooKeeper("10.42.94.233:2181", 60000, new Watcher() {
            @Override
            public void process(WatchedEvent e) {
                if (e.getType() == Event.EventType.None) {
                    switch (e.getState()) {
                        case SyncConnected:
                            System.out.println("SyncConnected");
                            latch.countDown();
                            break;
                        case Disconnected:
                            System.out.println("Disconnected");
                            break;
                        case Expired:
                            System.out.println("Expired");
                            break;
                        default:
                            System.out.println("default");
                            break;
                    }
                }
            }
        });
        latch.await();
    }

    @Test
    public void testLock() throws InterruptedException {
        LockResource lock = new LockResource(zk);
        Thread t1 = new Thread(() -> {
            if (lock.getLock("/lock")) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("GetLock1 Success");
                System.out.println("UnLock1:" + lock.unLock("/lock"));
            } else {
                System.out.println("No lock1");
            }
        });
        Thread t2 = new Thread(() -> {
            if (lock.getLock("/lock")) {
                System.out.println("GetLock2 Success");
                System.out.println("UnLock2:" + lock.unLock("/lock"));
            } else {
                System.out.println("No lock2");
            }
        });
        Thread t3 = new Thread(() -> {
            if (lock.getLock("/lock")) {
                System.out.println("GetLock3 Success");
                System.out.println("UnLock3:" + lock.unLock("/lock"));
            } else {
                System.out.println("No lock3");
            }
        });

        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.start();
        //加延迟是防止高并发情况下
        //因为在高并发下，各线程可能会同时判断lock不存在，而进行Lock的创建，以期获得到锁
        TimeUnit.SECONDS.sleep(1);
        t2.start();
        Thread.sleep(20000);

        //分析结果
//        SyncConnected  1.连接zookeeper成功
//        t1:/lock       2. t1线程获取到锁(创建/lock) 会隔2s后解锁
//        t2:abc         3. t2线程无法获取到锁
//        GetLock1 Success 4. t1线程获取到锁
//        /lock:NodeDeleted  6. t2线程监听到t1释放了锁
//        t2:/lock           7. t2线程获取到锁
//        GetLock2 Success   8. t2线程获取到锁成功
//        UnLock1:true       5. t1解锁
//        UnLock2:true       9. t2解锁
    }
}
