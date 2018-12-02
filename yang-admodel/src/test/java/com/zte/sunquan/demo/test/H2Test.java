package com.zte.sunquan.demo.test;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalListeners;
import com.google.common.cache.RemovalNotification;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by sunquan on 2017/11/20.
 */
public class H2Test {
    //simulate data
    List<String> list = Lists.newArrayList("a", "b", "c", "d", "e", "f", "g", "h", "j", "k", "m");

    private String compute(Integer key) {
        System.out.println(Thread.currentThread().getName() + "-compute value with " + key);
        return list.get(key);
    }


    @Test
    public void testCache1() throws ExecutionException {
        Cache<Integer, String> cache = CacheBuilder.<Integer, String>newBuilder().build();
        cache.put(0, "a");
        cache.put(1, "b");
        cache.put(2, "c");
        cache.put(3, "d");
        System.out.println(cache.getIfPresent(0));//a
        System.out.println(cache.getIfPresent(-1));//null
        System.out.println(cache.get(-1, () -> "bb"));//bb （无指定key的value，则执行callable,并将计算值加入缓存）
        System.out.println(cache.getIfPresent(-1));//bb
    }

    @Test
    public void testCache3() throws ExecutionException, InterruptedException {
        LoadingCache<Integer, String> cache = CacheBuilder.<Integer, String>newBuilder()
                .build(new CacheLoader<Integer, String>() {
                    //cache for what
                    public String load(Integer key) {
                        return compute(key);
                    }
                });
        //每隔1秒进行数据更新，会执行compute重新计算
        ScheduledExecutorService exe = Executors.newScheduledThreadPool(1);
        exe.scheduleAtFixedRate(() -> cache.asMap().keySet().forEach(cache::refresh), 0, 1, TimeUnit.SECONDS);
        System.out.println("v1:" + cache.get(1));
        cache.invalidate(1);//消除key为1的缓存
        Thread.sleep(2000);
        System.out.println("v2:" + cache.get(1));//重新执行compute
    }

    @Test
    public void testCache2() throws ExecutionException, InterruptedException {
        LoadingCache<Integer, String> cache = CacheBuilder.<Integer, String>newBuilder()
                .build(new CacheLoader<Integer, String>() {
                    //cache for what
                    public String load(Integer key) {
                        return compute(key);
                    }
                });
        //每隔1秒进行数据更新，会执行compute重新计算
        ScheduledExecutorService exe = Executors.newScheduledThreadPool(1);
        exe.scheduleAtFixedRate(() -> cache.asMap().keySet().forEach(cache::refresh), 0, 1, TimeUnit.SECONDS);
        System.out.println("v1:" + cache.get(1));
        Thread.sleep(1000);
        System.out.println("v2:" + cache.get(1));
        Thread.sleep(5000);
    }


    @Test
    public void testCache4() throws ExecutionException, InterruptedException {
        //增加缓存值删除监听器
        LoadingCache<Integer, String> cache = CacheBuilder.<Integer, String>newBuilder()
                .removalListener(new RemovalListener<Integer, String>() {
                    @Override
                    public void onRemoval(RemovalNotification<Integer, String> removalNotification) {
                        System.out.println(Thread.currentThread().getName() + "-remove key:" + removalNotification.getKey());
                        System.out.println(Thread.currentThread().getName() + "-remove value:" + removalNotification.getValue());
                    }
                })
                .build(new CacheLoader<Integer, String>() {
                    //cache for what
                    public String load(Integer key) {
                        return compute(key);
                    }
                });
        //每隔1秒进行数据更新，会执行compute重新计算（注意refresh会触发删除操作)
        ScheduledExecutorService exe = Executors.newScheduledThreadPool(1);
        exe.scheduleAtFixedRate(() -> cache.asMap().keySet().forEach(cache::refresh), 0, 1, TimeUnit.SECONDS);
        System.out.println("v1:" + cache.get(1));
        Thread.sleep(1000);
        System.out.println("v2:" + cache.get(1));
        Thread.sleep(3000);

        cache.invalidateAll();//invalidate亦会触发删除操作
        Thread.sleep(3000);
    }

    @Test
    public void testCache5() throws ExecutionException, InterruptedException {
        //增加缓存值删除监听器
        LoadingCache<Integer, String> cache = CacheBuilder.<Integer, String>newBuilder()
                .removalListener(new RemovalListener<Integer, String>() {
                    @Override
                    public void onRemoval(RemovalNotification<Integer, String> removalNotification) {
                        System.out.println(Thread.currentThread().getName() + "-remove key:" + removalNotification.getKey());
                        System.out.println(Thread.currentThread().getName() + "-remove value:" + removalNotification.getValue());
                    }
                }).recordStats()
                .build(new CacheLoader<Integer, String>() {
                    //cache for what
                    public String load(Integer key) {
                        return compute(key);
                    }
                });
        //每隔1秒进行数据更新，会执行compute重新计算（注意refresh会触发删除操作)
        ScheduledExecutorService exe = Executors.newScheduledThreadPool(1);
        exe.scheduleAtFixedRate(() -> cache.asMap().keySet().forEach(cache::refresh), 0, 1, TimeUnit.SECONDS);
        System.out.println("v1:" + cache.get(1));
        Thread.sleep(1000);
        System.out.println("v2:" + cache.get(1));
        Thread.sleep(3000);

        cache.invalidateAll();//invalidate亦会触发删除操作
        Thread.sleep(3000);
        System.out.println(cache.stats());
    }

    @Test
    public void testCache6() throws ExecutionException, InterruptedException {
        RemovalListener<Integer, String> listener = RemovalListeners.asynchronous(new RemovalListener<Integer, String>() {
            @Override
            public void onRemoval(RemovalNotification<Integer, String> removalNotification) {
                System.out.println(Thread.currentThread().getName() + "-remove key:" + removalNotification.getKey());
                System.out.println(Thread.currentThread().getName() + "-remove value:" + removalNotification.getValue());
            }
        }, Executors.newSingleThreadExecutor());
        //增加缓存值删除异步监听器
        LoadingCache<Integer, String> cache = CacheBuilder.<Integer, String>newBuilder()
                .removalListener(listener).recordStats()
                .build(new CacheLoader<Integer, String>() {
                    //cache for what
                    public String load(Integer key) {
                        return compute(key);
                    }
                });
        //每隔1秒进行数据更新，会执行compute重新计算（注意refresh会触发删除操作)
        ScheduledExecutorService exe = Executors.newScheduledThreadPool(1);
        exe.scheduleAtFixedRate(() -> cache.asMap().keySet().forEach(cache::refresh), 0, 1, TimeUnit.SECONDS);
        System.out.println("v1:" + cache.get(1));
        Thread.sleep(1000);
        System.out.println("v2:" + cache.get(1));
        Thread.sleep(3000);

        cache.invalidateAll();//invalidate亦会触发删除操作
        Thread.sleep(3000);
        System.out.println(cache.stats());
        cache.cleanUp();
    }

    @Test
    public void testCache7() throws ExecutionException, InterruptedException {
        ScheduledExecutorService exe = Executors.newScheduledThreadPool(1);
        //增加缓存值删除异步监听器
        LoadingCache<Integer, String> cache = CacheBuilder.<Integer, String>newBuilder()
                .build(new CacheLoader<Integer, String>() {
                    //cache for what
                    public String load(Integer key) {
                        return compute(key);
                    }
                });
        //每隔5分钟进行数据更新，会执行compute重新计算（注意refresh会触发删除操作)
        exe.scheduleAtFixedRate(() -> cache.asMap().keySet().forEach(cache::refresh), 0, 1, TimeUnit.MINUTES);
        System.out.println("v1:" + cache.get(1));
        Thread.sleep(1000);
        System.out.println("v2:" + cache.get(1));
        Thread.sleep(3000);
        cache.invalidateAll();//invalidate亦会触发删除操作
        Thread.sleep(3000);
        cache.cleanUp();
    }

    @Test
    public void testMem() throws SQLException, InterruptedException {
        Connection connection = DriverManager
                .getConnection("jdbc:h2:mem:DBName;DB_CLOSE_DELAY=-1", "foo", "bar");
        boolean flag = connection.isValid(5000);
        int count = 1;
        if (flag) {
            //连接成功
            Statement tableCreate = connection.createStatement();
            tableCreate.execute("create table sq(" +
                    "uname VARCHAR(100) NOT NULL," +
                    "upasswd VARCHAR(200) )");
            tableCreate.close();
            Statement userInsert = connection.createStatement();
            userInsert.execute("insert into sq values('sunquan','123456')");
            userInsert.close();

            Statement userQuery = connection.createStatement();
            ResultSet resultSet = userQuery.executeQuery("select * from sq");
            while (resultSet.next()) {
                System.out.println("count:" + count++);
                Assert.assertEquals("sunquan", resultSet.getString(1));//从1开始
                Assert.assertEquals("sunquan", resultSet.getString("uname"));
                Assert.assertEquals("123456", resultSet.getString("upasswd"));
            }
            resultSet.close();
            userQuery.close();
        }
    }

    @Test
    public void testEmbed() throws SQLException, InterruptedException {
        //目录存在于C:\Users\Administrator\.h2  默认是嵌入式模式=jdbc:h2:file:~/.h2/DBName;
        Connection connection = DriverManager
                .getConnection("jdbc:h2:~/.h2/DBName;DB_CLOSE_DELAY=-1", "foo", "bar");
        boolean flag = connection.isValid(5000);
        int count = 1;
        if (flag) {
            //连接成功
            Statement tableCreate = connection.createStatement();
            tableCreate.execute("create table IF NOT EXISTS sq (" +
                    "uname VARCHAR(100) NOT NULL," +
                    "upasswd VARCHAR(200) )");
            tableCreate.close();
            Statement userInsert = connection.createStatement();
            userInsert.execute("insert into sq values('sunquan','123456')");
            userInsert.close();

            Statement userQuery = connection.createStatement();
            ResultSet resultSet = userQuery.executeQuery("select * from sq");
            while (resultSet.next()) {
                System.out.println("count:" + count++);
                Assert.assertEquals("sunquan", resultSet.getString(1));//从1开始
                Assert.assertEquals("sunquan", resultSet.getString("uname"));
                Assert.assertEquals("123456", resultSet.getString("upasswd"));
            }
            resultSet.close();
            userQuery.close();
        }
        //每次执行都会进行数据插入，数据会以文件方式保留
    }

    @Test
    public void testServer1() throws SQLException, InterruptedException {
        //需要先启用h2的服务 org.h2.tools.Server
        Connection connection = DriverManager
                .getConnection("jdbc:h2:tcp://localhost:9092/E:/idmlight.db", "foo", "bar");
        boolean flag = connection.isValid(5);
        int count = 1;
        if (flag) {
            //连接成功
            Statement tableCreate = connection.createStatement();
            tableCreate.execute("create table IF NOT EXISTS sq (" +
                    "uname VARCHAR(100) NOT NULL," +
                    "upasswd VARCHAR(200) )");
            tableCreate.close();
            Statement userInsert = connection.createStatement();
            userInsert.execute("insert into sq values('sunquan','123456')");
            userInsert.close();

            Statement userQuery = connection.createStatement();
            ResultSet resultSet = userQuery.executeQuery("select * from sq");
            while (resultSet.next()) {
                System.out.println("count:" + count++);
                Assert.assertEquals("sunquan", resultSet.getString(1));//从1开始
                Assert.assertEquals("sunquan", resultSet.getString("uname"));
                Assert.assertEquals("123456", resultSet.getString("upasswd"));
            }
            resultSet.close();
            userQuery.close();
        }
    }

}

