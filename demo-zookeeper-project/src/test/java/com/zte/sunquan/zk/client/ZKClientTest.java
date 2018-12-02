package com.zte.sunquan.zk.client;

import static com.zte.sunquan.zk.net.NetUtils.getLocalAddress;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by 10184538 on 2018/5/30.
 */
public class ZKClientTest {
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
    public void test() throws IOException, InterruptedException, KeeperException {
        if (zk.getState() == ZooKeeper.States.CONNECTED) {
            zk.create("/sunquan", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.PERSISTENT);
            Stat exists = zk.exists("/sunquan", false);
            Assert.assertTrue(exists != null);
            zk.delete("/sunquan", -1);
        }
        TimeUnit.SECONDS.sleep(4);
        zk.close();
    }


    @Test
    public void testGetLocalAddress() {
        String ip = getLocalAddress();
        System.out.println(ip);
    }
}
