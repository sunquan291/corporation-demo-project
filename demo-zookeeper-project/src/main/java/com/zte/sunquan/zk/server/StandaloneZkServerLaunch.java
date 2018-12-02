package com.zte.sunquan.zk.server;


import static com.zte.sunquan.zk.server.StandaloneZKServer.clearLog;
import static com.zte.sunquan.zk.server.StandaloneZKServer.stop;

/**
 * Created by 1018538 on 2018/3/20.
 */
public class StandaloneZkServerLaunch {
    private static StandaloneZKServer server = new StandaloneZKServer();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("zookeeper server start..");
        clearLog();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("zookeeper start");
                server.start();
            }
        }).start();

        Thread.sleep(5000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                server.stop();
                System.out.println("zookeeper server stop..");
            }
        }).start();
    }
}
