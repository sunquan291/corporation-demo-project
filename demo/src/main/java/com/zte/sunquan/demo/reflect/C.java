package com.zte.sunquan.demo.reflect;

/**
 * Created by 10184538 on 2016/12/15.
 */
public class C extends B{

    @Override
    public void fun() {
        System.out.println("C");
    }
    public void test(){
        super.test();
    }

    public static void main(String[] args) {
        new C().test();
    }

}
