package com.zte.sunquan.demo.thread.local.senior;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Livio
 * @Date: 2020/5/7 22:55
 */
public class UserListServiceMain {
    private static final AtomicInteger creator = new AtomicInteger(1);

    public static void main(String[] args) throws InterruptedException {
        UserListService userService = new UserListService();
        userService.addUser(initUser(Thread.currentThread().getName()));
        new Thread(() -> {
            userService.addUser(initUser(Thread.currentThread().getName()));
            userService.printUser();
        }, "callService").start();
        Thread.sleep(40);
        userService.printUser();

        CompletableFuture.runAsync(()->{
            userService.addUser(initUser(Thread.currentThread().getName()));
            System.out.println("*********************");
            userService.printUser();
        }).join();
        System.out.println("------------------------------");
        userService.printUser();

        List<String> input= Lists.newArrayList("1","3","4","1","3","4","1","3","4","1","3","4","1","3","4");
        input.parallelStream().forEach(p->{
            userService.addUser(initUser(Thread.currentThread().getName()+"id:"+p));
        });
        System.out.println("------------------------------");
        userService.printUser();
    }

    private static User initUser(String name) {
        User user = new User();
        user.setId(creator.getAndIncrement());
        user.setName(name);
        user.setThreadName(name);
        return user;
    }
}
