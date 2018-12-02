package com.zte.sunquan.demo.proxy;

/**
 * Created by 10184538 on 2017/2/20.
 */
public class RealSubject implements Subject,Subject2 {
    @Override
    public void opration() {
        System.out.println("I am a RealSubject");
    }

    @Override
    public void opration2() {
        System.out.println("I am a RealSubject,opration2");
    }

    @Override
    public String toString() {
        System.out.println("toString");
        return "RealSubject{}";
    }
}
