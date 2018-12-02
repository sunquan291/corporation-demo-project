package com.zte.sunquan.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by 10184538 on 2017/11/29.
 */
public class LogHandler implements InvocationHandler {
    private Object dele;

    public LogHandler(Object obj) {
        this.dele = obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        Object result = method.invoke(dele, args);
        after();
        return result;
    }

    private void doBefore() {
        System.out.println("before....");
    }

    private void after() {
        System.out.println("after....");
    }
}
