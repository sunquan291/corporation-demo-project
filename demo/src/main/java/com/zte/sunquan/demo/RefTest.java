package com.zte.sunquan.demo;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by 10184538 on 2018/3/13.
 */
public class RefTest {
    @Test
    public void method() throws NoSuchMethodException {
        Class inter=ExampleInterface.class;
        Method getCtrl = inter.getMethod("getCtrl", String.class);
        System.out.println(getCtrl);
    }
}
