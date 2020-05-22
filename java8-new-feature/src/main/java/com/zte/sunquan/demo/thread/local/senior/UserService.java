package com.zte.sunquan.demo.thread.local.senior;

/**
 * @Author: Livio
 * @Date: 2020/5/7 22:53
 */
public class UserService {

    private static final ThreadLocal<User> context = new InheritableThreadLocal<>();

    public void printUser() {
        System.out.println(Thread.currentThread().getName() + "添加用户信息1:" + context.get());
    }

    public void setUser(User user) {
        context.set(user);
        System.out.println(Thread.currentThread().getName() + "添加用户信息2:" + context.get());
    }
}
