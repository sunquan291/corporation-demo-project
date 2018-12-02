package com.zte.sunquan.demo.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10184538 on 2017/3/28.
 */
public class ThreadTest {

    public void test(String a, int b) {
        List<Integer> list = new ArrayList<>();
        Runnable runnable = () -> {
            if (b < 2) {
                System.out.println(b);
                list.add(b);
            }
        };
    }

    public static void main(String[] args) {
        MyThread m1 = new MyThread("a");
        MyThread m2 = new MyThread("b");
        MyThread m3 = new MyThread("c");
        MyThread m4 = new MyThread("d");
        MyThread m5 = new MyThread("e");
        MyThread m6 = new MyThread("f");
        MyThread m7 = new MyThread("g");
        MyThread m8 = new MyThread("f");
        MyThread m9 = new MyThread("g");
        MyThread m10 = new MyThread("f");
        MyThread m11 = new MyThread("g");
    }
}
