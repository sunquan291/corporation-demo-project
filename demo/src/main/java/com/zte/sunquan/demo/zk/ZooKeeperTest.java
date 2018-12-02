package com.zte.sunquan.demo.zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by 10184538 on 2017/6/30.
 */
public class ZooKeeperTest {
    @Test
    public void test() throws IOException, InterruptedException, KeeperException {
        ZooKeeper zk = new ZooKeeper("10.42.94.208:2181", 60000, new Watcher() {
            @Override
            public void process(WatchedEvent e) {
                if (e.getType() == Event.EventType.None) {
                    switch (e.getState()) {
                        case SyncConnected:
                            System.out.println("SyncConnected");
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

        zk.getChildren("/master$", false).forEach(System.out::println);

        System.out.println(zk.getState());

        TimeUnit.SECONDS.sleep(4);
        zk.close();
    }

    public void getXXA() {
        System.out.println("yyyyyyyyy");
    }

    private int a;
    private double b;
    private String abc = "acbsfdsfdaaaaaaaaaaaaaaaaaaa";
    private BigInteger bigInteger = new BigInteger("3232342222222222");
    private int a1;
    private double b1;
    private String abc1 = "acbsfdsfdaaaaaaaaaaaaaaaaaaa";
    private BigInteger bigInteger1 = new BigInteger("3232342222222222");

//    public static List list = new ArrayList();

    public static void main(String[] args) throws InterruptedException {
        List list = new ArrayList();
        TimeUnit.SECONDS.sleep(1);
        while (true) {
            for (int i = 0; i < 5000000; i++) {
                list.add(new ZooKeeperTest());
            }
            System.out.println(list.size());
            list.clear();
        }
    }
}
