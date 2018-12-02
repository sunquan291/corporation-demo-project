package com.zte.sunquan.zookeeper.lock;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 10184538 on 2017/7/7.
 */
public class IDGenerator {
    CountDownLatch countDownLatch = new CountDownLatch(1);

    public boolean getLock() throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = new ZooKeeper("10.42.94.208:2181", 60000, null);
        if (zk.exists("/lock", false) == null) {
            zk.create("lock", "m".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            return true;
        }

        if (zk.exists("lock", false) != null) {
            zk.register(new Watcher() {
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
            countDownLatch.await();
        }
        return false;
    }

    public boolean unLock() throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = new ZooKeeper("10.42.94.208:2181", 60000, null);
        if (zk.exists("/lock", false) != null) {
            zk.delete("/lock", 0);
            countDownLatch.countDown();
            return true;
        }
        return false;
    }

    private void a() {
        Frame frame = new Frame("abc");
        Button button = new Button("open");
        frame.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
                FileDialog fileDialog = new FileDialog(frame, "open", FileDialog.LOAD);
                fileDialog.setFile("*.txt");
                fileDialog.setVisible(true);
            }
        });
        frame.setVisible(true);

    }

    private void b() {
        String input = "\"hello world\"";
        int[] result = new int[128];
        boolean firstTime = true;
        for (char c : input.toCharArray()) {
            result[c]++;
            if (firstTime && result[c] > 1) {
                System.out.printf("first repeat character:%c\n", c);
                firstTime = false;
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] > 1) {
                System.out.printf("repeat character:%c,tims:%d.\n", (char) i, result[i]);
            }
        }
    }

    public static void main(String[] args) {
//        String input = "this is a book , that is a desk .";
        String input = "book";
        Pattern pattern = Pattern.compile("\\bbook\\b");
//        String input = "The dog plays dogdog in the yard.";
//        Pattern pattern = Pattern.compile("\\bdog\\b");
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        while (matcher.find()) {
            System.out.printf("I found the text \"%s\" starting at index %d " +
                            "and ending at index %d.%n",
                    matcher.group(), matcher.start(), matcher.end());
            count++;
        }
        System.out.println(count);
    }

    @Test
    public void testA(){
        String REGEX = "\\bcat\\b";
        String INPUT = "cat cat cat cattie cat";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT); // 获取 matcher 对象
        int count = 0;
        while(m.find()) {
            count++;
            System.out.println("Match number "+count);
            System.out.println("start(): "+m.start());
            System.out.println("end(): "+m.end());
        }
    }
}
