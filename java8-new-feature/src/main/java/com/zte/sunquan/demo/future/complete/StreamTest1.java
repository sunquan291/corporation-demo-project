package com.zte.sunquan.demo.future.complete;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * StreamTest1 class
 *
 * @author 10184538
 * @date 2019/4/13
 */
public class StreamTest1 {


    public static void main(String[] args) throws InterruptedException {
        List<String> linkList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            linkList.add("abc" + i);
        }
        Vector<String> linkList2 = new Vector<>();
        linkList.parallelStream().forEach(linkInfo -> {
            System.out.println(linkInfo);
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(10);
                linkList2.add(linkInfo);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });
        System.out.println(linkList2.size());
        Thread.sleep(12000);
    }
}
