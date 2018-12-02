package com.zte.sunquan.demo.proxy;

/**
 * Created by 10184538 on 2017/11/29.
 */
public class HelloImpl implements Hello{
    public void sayHello(String to) {
        System.out.println("Say hello to " + to);
    }
    public void print(String s) {
        System.out.println("print : " + s);
    }
}
