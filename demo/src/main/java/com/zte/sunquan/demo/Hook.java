package com.zte.sunquan.demo;

import java.util.Scanner;

/**
 * Created by 10184538 on 2018/3/21.
 */
public class Hook {
    public static void start() {
        System.out.println("The JVM is started");
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    //do something
                    System.out.println("The JVM Hook is execute");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        start();

        System.out.println("The Application is doing something");


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
