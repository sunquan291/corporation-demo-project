package com.zte.sunquan.demo.consum;

import org.junit.Test;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;

/**
 * Created by 10184538 on 2017/8/9.
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
    public void test(){
        ConsumerTest consumerTest=new ConsumerTest();
        consumerTest.addAnnotationChangedNotify(p->p.setName("hello,world"),p->p.getName());
        System.out.println(consumerTest.annotationAddedNotifies.size());
        consumerTest.removeAnnotationChangedNotify(p->p.setName("hello,world"),p->p.getName());
        System.out.println(consumerTest.annotationAddedNotifies.size());
    }

}
class User{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
