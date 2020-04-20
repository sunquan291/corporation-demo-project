package com.zte.sunquan.demo.jvm;

import java.util.Vector;

public class HeapTest {
    public static void main(String[] args) throws InterruptedException {
        Vector vector=new Vector();
        while (true){
            //每隔1秒进行5M空间申请
            byte[] input=new byte[1024*1024*5];
            vector.add(input);
            Thread.sleep(1000);
        }
    }
}
