package com.zte.sunquan.lambda;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;

import org.junit.Test;

import com.zte.sunquan.lambda.domain.User;

/**
 * Created by 10184538 on 2018/6/1.
 */
public class ConsumerTest {
    Collection<Consumer<User>> annotationAddedNotifies = new ConcurrentLinkedQueue<>();
    Collection<Consumer<User>> annotationRemovedNotifies = new ConcurrentLinkedQueue<>();


    public void addAnnotationChangedNotify(Consumer<User> annotationAddedNotify, Consumer<User> annotationRemovedNotify) {
        annotationAddedNotifies.add(annotationAddedNotify);
        annotationRemovedNotifies.add(annotationRemovedNotify);
    }


    public void removeAnnotationChangedNotify(Consumer<User> annotationAddedNotify, Consumer<User> annotationRemovedNotify) {
        annotationAddedNotifies.remove(annotationAddedNotify);
        annotationRemovedNotifies.remove(annotationRemovedNotify);
    }

    @Test
    public void test() {
        ConsumerTest consumerTest = new ConsumerTest();
        consumerTest.addAnnotationChangedNotify(p -> p.setName("hello,world"), p -> p.getName());
        System.out.println(consumerTest.annotationAddedNotifies.size());
        //针对与JAVA内置的lambda表达式 无法比较
        consumerTest.removeAnnotationChangedNotify(p -> p.setName("hello,world"), p -> p.getName());
        System.out.println(consumerTest.annotationAddedNotifies.size());
    }

}
