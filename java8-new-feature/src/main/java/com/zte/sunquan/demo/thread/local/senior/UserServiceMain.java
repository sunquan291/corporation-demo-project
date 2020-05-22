package com.zte.sunquan.demo.thread.local.senior;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Livio
 * @Date: 2020/5/7 22:55
 */
public class UserServiceMain {
    private static final AtomicInteger creator = new AtomicInteger(1);

    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.setUser(initUser(Thread.currentThread().getName()));
        new Thread(() -> userService.printUser(), "callService").start();
        //同时10个调用
   /*     for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                userService.setUser(initUser(Thread.currentThread().getName()));
                //进行调用
                userService.printUser();
            }, "callService-" + i).start();
        }*/
    }

    private static User initUser(String name) {
        User user = new User();
        user.setId(creator.getAndIncrement());
        user.setName(name);
        user.setThreadName(name);
        return user;
    }
}
