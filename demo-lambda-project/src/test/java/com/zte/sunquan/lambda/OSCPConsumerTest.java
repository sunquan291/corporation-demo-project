package com.zte.sunquan.lambda;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.junit.Test;

import com.zte.sunquan.lambda.domain.OSCPConsumer;
import com.zte.sunquan.lambda.domain.User;

/**
 * Created by 10184538 on 2018/6/1.
 */
public class OSCPConsumerTest {
    Collection<OSCPConsumer<User>> annotationAddedNotifies = new ConcurrentLinkedQueue<>();

    @Test
    public void test() {
        OSCPConsumer<User> t = p -> p.setName("hello,world");//只有先声明
        Collection<OSCPConsumer<User>> consumers = new ConcurrentLinkedQueue<>();
        consumers.add(t);
        consumers.remove(t);
        System.out.println(consumers.size());
    }

    @Test
    public void test2() {
        Collection<OSCPConsumer<User>> consumers = new ConcurrentLinkedQueue<>();
        consumers.add(p -> p.setName("hello,world"));
        //这种增加，无法进行删除
        consumers.removeIf(p -> p.hashCode() == 1);
        System.out.println(consumers.size());
    }

}
