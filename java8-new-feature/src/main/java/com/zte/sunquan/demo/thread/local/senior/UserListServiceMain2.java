package com.zte.sunquan.demo.thread.local.senior;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Livio
 * @Date: 2020/5/7 22:55
 */
public class UserListServiceMain2 {
    private static final AtomicInteger creator = new AtomicInteger(1);

    /**
     * 如果parastream如果之前没有用过，那在声明的地方其内置线程的所有父线程为其父线程，如下面代码的sqxxx
     * 但如果parastream在前面有用过，那则会导致所有forkjoin线程其父线程不再是sqxx
     *ForkJoinPool.commonPool-worker-2,111
     * ForkJoinPool.commonPool-worker-2,1
     * ForkJoinPool.commonPool-worker-1,11
     *
     * 则12不父线程不是sqxx自然也不会继承线程变量
     *
     * 下面加入，去掉12，有
     *
     * sqxxx添加用户信息2:2
     * ForkJoinPool.commonPool-worker-3添加用户信息2:1
     * sqxxx添加用户信息2:3
     * ForkJoinPool.commonPool-worker-2添加用户信息2:1
     * ForkJoinPool.commonPool-worker-4添加用户信息2:1
     * ForkJoinPool.commonPool-worker-3添加用户信息2:2
     * ForkJoinPool.commonPool-worker-1添加用户信息2:1
     * ForkJoinPool.commonPool-worker-1添加用户信息2:2
     * ForkJoinPool.commonPool-worker-3添加用户信息2:3
     * ForkJoinPool.commonPool-worker-7添加用户信息2:1
     * ForkJoinPool.commonPool-worker-4添加用户信息2:2
     * ForkJoinPool.commonPool-worker-2添加用户信息2:2
     * sqxxx添加用户信息2:4
     * ForkJoinPool.commonPool-worker-1添加用户信息2:3
     * ForkJoinPool.commonPool-worker-5添加用户信息2:1
     *
     * 所以callService打印为sqxx加入个数
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Vector<String> vector = new Vector<>();
        vector.add("1");
        vector.add("11");
        vector.add("111");
        vector.add("111");
        vector.parallelStream().forEach(p -> {
            System.out.println(Thread.currentThread().getName() + "," + p);
        });

        UserListService userService = new UserListService();
        new Thread(() -> {
            userService.setContext();
            userService.addUser(initUser(Thread.currentThread().getName()));
            userService.printUser();
            System.out.println("----1---------1-----------1------");
            final List<String> input = Lists.newArrayList("1", "3", "4", "1", "3", "4", "1", "3", "4", "1", "3", "4", "1", "3", "4");
            new Thread(() -> {
                input.parallelStream().forEach(p -> {
                    userService.addUser(initUser(Thread.currentThread().getName() + "id:" + p));
                });
            }
                    , "sqxxx").start();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("------------------------------");
            userService.printUser();
        }, "callService").

                start();
        Thread.sleep(500);
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
