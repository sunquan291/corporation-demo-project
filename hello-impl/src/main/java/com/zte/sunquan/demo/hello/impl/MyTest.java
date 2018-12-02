package com.zte.sunquan.demo.hello.impl;

/**
 * Created by 10184538 on 2017/6/29.
 */
public class MyTest {
    private static MyTest test
                        = new MyTest(10);
    private int num1;
    private static int num2 = 100;

    public MyTest(int a) {
        num1 = num2 - a;
    }

    public static void main(String[] args) {
        System.out.println(MyTest.test.num1);
        MyTest test = new MyTest(10);
        System.out.println(test.num1);
    }
}
