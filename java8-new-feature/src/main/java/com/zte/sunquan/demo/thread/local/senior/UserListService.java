package com.zte.sunquan.demo.thread.local.senior;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.google.common.collect.Lists;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: Livio
 * @Date: 2020/5/7 22:53
 */
public class UserListService {

    private ThreadLocal<CopyOnWriteArrayList<User>> context = new TransmittableThreadLocal<CopyOnWriteArrayList<User>>() {
        @Override
        protected CopyOnWriteArrayList<User> initialValue() {
            return Lists.newCopyOnWriteArrayList();
        }
    };

    public void setContext() {
        context = new TransmittableThreadLocal<CopyOnWriteArrayList<User>>() {
            @Override
            protected CopyOnWriteArrayList<User> initialValue() {
                return Lists.newCopyOnWriteArrayList();
            }
        };
    }

    public void printUser() {
        System.out.println(Thread.currentThread().getName() + "打印用户信息1:" + context.get().size());
    }

    public void addUser(User user) {
        context.get().add(user);
        System.out.println(Thread.currentThread().getName() + "添加用户信息2:" + context.get().size());
    }
}
