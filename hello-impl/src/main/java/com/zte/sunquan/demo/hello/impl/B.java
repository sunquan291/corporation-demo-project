package com.zte.sunquan.demo.hello.impl;

/**
 * Created by 10184538 on 2017/6/29.
 */
public class B  extends A{
    private int a=2;
    public B(){
//        System.out.println(this.a);
        this.a=109;
    }
    public void display() {
        System.out.println(a);
    }
    public static void main(String[] args) {
        new B();
//        B b = new B();
//        System.out.println(b.a);
    }
}
