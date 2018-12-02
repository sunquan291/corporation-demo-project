package com.zte.sunquan.demo.th;

/**
 * Created by 10184538 on 2016/12/3.
 */
public class ThreadTest {

    public static void main(String[] args) {
        MyThread th=new MyThread();
        th.start();
        System.out.println("main stop.");

        Thread th2=new Thread(th);
        th2.start();

        MyThread th3=new MyThread();

    }

}

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("Thread.currentThread().getName()="+Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()="+Thread.currentThread().isAlive());
        System.out.println("this.getName()="+this.getName());
        System.out.println("this.isAlive()="+this.isAlive());
        System.out.println("----------");
    }
}
