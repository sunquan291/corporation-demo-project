package com.zte.sunquan.zk.server;

/**
 * Created by 10184538 on 2017/3/30.
 */

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.zookeeper.server.PurgeTxnLog;
import org.apache.zookeeper.server.ServerConfig;
import org.apache.zookeeper.server.ZooKeeperServerMain;
import org.apache.zookeeper.server.quorum.QuorumPeerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StandaloneZKServer {

    private static final Logger logger = LoggerFactory.getLogger(StandaloneZKServer.class);
    private static String dataPath = StandaloneZKServer.class.getClassLoader().getResource("").getPath();
    private static String zookeeperDataPath = dataPath +  "/zookeeperData";
    private static String zookeeperLogDataPath = dataPath +  "/zookeeperLogData";
    /**
     * 启动单例zk server
     *
     * @param tickTime   Zookeeper中最小时间单元的长度
     * @param dataDir    Zookeeper服务器存储快照文件的目录
     * @param clientPort 当前服务器对外的服务端口
     * @param initLimit  Leader服务器等待Follower启动，并完成数据同步的时间
     * @param syncLimit  Leader服务器和Follower之间进行心跳检测的最大延时时间
     */
    private static ZooKeeperServerMain zkServer;
    private static int count = 0;
    private static ExecutorService startExec = Executors.newSingleThreadExecutor();
    private static ExecutorService stopExec = Executors.newSingleThreadExecutor();

    public static void start() {
        startExec.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("zookeeper data path:" + zookeeperDataPath);
                start("2000", zookeeperDataPath, zookeeperLogDataPath, "2182", "10", "5");
            }
        });

    }

    public static void start(String tickTime, String dataDir, String dataLogDir, String clientPort, String initLimit, String syncLimit) {
        if (count > 0) {
            count++;
            logger.info("the zkServer has been started ");
            return;
        }
        Properties props = new Properties();
        props.setProperty("tickTime", tickTime);
        props.setProperty("dataDir", dataDir);
        props.setProperty("dataLogDir", dataLogDir);
        props.setProperty("clientPort", clientPort);
        props.setProperty("initLimit", initLimit);
        props.setProperty("syncLimit", syncLimit);
        props.setProperty("server.1", "127.0.0.1:2888:3888");
        count++;
        QuorumPeerConfig quorumConfig = new QuorumPeerConfig();
        try {
            quorumConfig.parseProperties(props);
            zkServer = new ZooKeeperServerMain();
            final ServerConfig config = new ServerConfig();
            config.readFrom(quorumConfig);
            zkServer.runFromConfig(config);
        } catch (Exception e) {
            logger.error("Start standalone server faile", e);
        }
    }

    public static void stop() {
        stopExec.submit(new Runnable() {
            @Override
            public void run() {
                count--;
                if (count <= 0) {
//                    zkServer.shutdown();
                    logger.info("the zkServer has been stoped");
                    return;
                }
                logger.info("the zkServer has not been stoped");
            }
        });

        clearLog();
    }
    public static void clearLog() {
        try {
            System.out.println("clear log");
            PurgeTxnLog.purge(new File(zookeeperLogDataPath),new File(zookeeperDataPath),3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}