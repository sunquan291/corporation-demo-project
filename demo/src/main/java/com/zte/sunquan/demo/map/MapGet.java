package com.zte.sunquan.demo.map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;
import com.zte.sunquan.j8.work.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/**
 * Created by 10184538 on 2017/4/12.
 */
public class MapGet {
    private Map<ApiKey, User> map = Maps.newConcurrentMap();

    @Before
    public void init() {
//        for (int i = 0; i < 100; i++) {
//            ApiKey apiKey = new ApiKey();
//            apiKey.setApiClass(User.class);
//            apiKey.setGroup("default");
//            apiKey.setTopic("default"+i);
//            map.put(apiKey, new User("sunquan", 27));
//        }
    }

    @Test
    public void test() {
        ApiKey apiKey = new ApiKey();
        apiKey.setApiClass(User.class);
        apiKey.setGroup("default");
        apiKey.setTopic("default99");
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            getByApi(apiKey);
        }
        System.out.println(System.currentTimeMillis() - begin);
    }

    @Test
    public void test2() {
        ApiKey apiKey = new ApiKey();
        apiKey.setApiClass(User.class);
        apiKey.setGroup("default");
        apiKey.setTopic("default99");
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            getByApi2(apiKey);
        }
        System.out.println(System.currentTimeMillis() - begin);
    }

    private User getByApi(ApiKey key) {
        if (!map.containsKey(key)) {
            map.put(key, new User("xx", 12));
        }
        return map.get(key);
    }

    private User getByApi2(ApiKey key) {
        return map.computeIfAbsent(key, k -> createUser(k));
    }

    private User createUser(ApiKey k) {
        return new User("xxaa", 22);
    }


    @Test
    public void addQueueBlock() {
        BlockingQueue<String> objects = Queues.newLinkedBlockingQueue();
        List<String> array = Lists.newArrayList();
        for (int i = 0; i < 9000000; i++) {
            String s1 = new String("xxxx," + i);
            array.add(s1);
        }
        long begin = System.currentTimeMillis();
        for (String s : array)
            objects.offer(s);
        System.out.println(System.currentTimeMillis() - begin);

    }

    @Test
    public void addQueueBlock2() {
        BlockingQueue<String> objects = Queues.newLinkedBlockingQueue();
        List<String> array = Lists.newArrayList();
        for (int i = 0; i < 9000000; i++) {
            String s1 = new String("hello," + i);
            array.add(s1);
        }
        long begin = System.currentTimeMillis();
        for (String s : array)
            objects.add(s);
        System.out.println(System.currentTimeMillis() - begin);

    }
}
