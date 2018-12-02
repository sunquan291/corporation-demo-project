package com.zte.sunquan.demo;

/**
 * Created by 10184538 on 2017/7/31.
 */
public interface BaseInterface {
    public static void printA() {
        System.out.println("A");
    }

    default void printB() {
        System.out.println("B");
    }
}
