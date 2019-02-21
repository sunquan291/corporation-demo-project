package com.zte.sunquan.demo.thread.local;

/**
 * ThreadLocalTest class
 *
 * @author 10184538
 * @date 2019/2/21
 */
public class ThreadLocalTest {
    private static final ThreadLocal<String> nameThreadLocal = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "sunquan";
        }
    };

    public static void main(String[] args) throws InterruptedException {
        nameThreadLocal.set("abc");
        Thread th1 = new Thread(() -> {
            //sunquan
            System.out.println(Thread.currentThread().getName() + ":" + nameThreadLocal.get());
        });
        th1.start();
        //abc
        System.out.println(Thread.currentThread().getName() + ":" + nameThreadLocal.get());
        Thread.sleep(1000);
    }
}
