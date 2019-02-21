package com.zte.sunquan.demo.thread.local;

/**
 * ThreadLocalTest class
 *
 * @author 10184538
 * @date 2019/2/21
 */
public class InheritThreadLocal2Test {
    private static final ThreadLocal<String> nameThreadLocal = new InheritableThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "sunquan";
        }
    };

    public static void main(String[] args) throws InterruptedException {
        nameThreadLocal.set("abc");
        Thread th1 = new Thread(() -> {
            //abc(子线程中会引起父线程变更)
            System.out.println(Thread.currentThread().getName() + ":" + nameThreadLocal.get());
            //修改线程变量
            nameThreadLocal.set("efg");

        });
        Thread th2 = new Thread(() -> {
            //abc(子线程中会引起父线程变更)
            System.out.println(Thread.currentThread().getName() + ":" + nameThreadLocal.get());

        });
        th1.start();
        th1.sleep(1000);
        th2.start();
        //abc
        System.out.println(Thread.currentThread().getName() + ":" + nameThreadLocal.get());
        Thread.sleep(1000);
    }
}
