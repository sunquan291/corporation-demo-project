package com.zte.sunquan.demo.enu;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 10184538 on 2017/2/20.
 */
public class TestEnum {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println(NetType.Net1);
//        System.out.println(NetType.Net2.name());
        Object[] enumArray = NetType.class.getEnumConstants();
        Method getValue = NetType.class.getDeclaredMethod("getValue");
    }
}
