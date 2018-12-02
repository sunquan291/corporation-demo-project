package com.zte.sunquan.demo.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by 10184538 on 2017/2/24.
 */
public class AuthorizationInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, objects);
//        Object result = method.invoke(o,objects);循环调用
        after();
        return result;
    }

    private void after() {
        System.out.println("after...");
    }

    private void before() {
        System.out.println("before...");
    }
}
