package com.zte.sunquan.demo;


import java.util.Base64;

/**
 * Created by 10184538 on 2017/7/31.
 */
public class BaseInterfaceImpl implements BaseInterface {
    public void printC() {
        printB();
        BaseInterface.printA();
    }

    public static void main(String[] args) {
        byte[] encode = Base64.getEncoder().encode("hello,world".getBytes());
        byte[] decode = Base64.getDecoder().decode(encode);
        System.out.println(new String(decode));
    }
}
