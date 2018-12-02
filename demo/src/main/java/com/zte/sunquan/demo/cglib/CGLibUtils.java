package com.zte.sunquan.demo.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * Created by 10184538 on 2017/2/24.
 */
public class CGLibUtils {
    public static <T> T createProxy(Class<T> targetClass) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass);
        enhancer.setCallback(NoOp.INSTANCE);
        return (T)enhancer.create();
//        Enhancer.create(targetClass,NoOp.INSTANCE);
    }
}
