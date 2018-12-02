package com.zte.sunquan.demo.proxy;

import net.sf.cglib.proxy.CallbackHelper;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.NoOp;

/**
 * Created by 10184538 on 2017/2/24.
 */
public class CGLibUtils {
    public static <T> T createProxy(Class<T> targetClass) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass);
        enhancer.setCallback(NoOp.INSTANCE);
        return (T) enhancer.create();
    }

    public static <T> T createProxy(Class<T> targetClass, MethodInterceptor... interceptors) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass);
        enhancer.setCallbacks(interceptors);
        return (T) enhancer.create();
    }

    public static <T> T createProxy(Class<T> targetClass, InvocationHandler... interceptors) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass);
        enhancer.setCallbacks(interceptors);
        return (T) enhancer.create();
    }

    public static <T> T createProxy(Class<T> targetClass, FixedValue... interceptors) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass);
        enhancer.setCallbacks(interceptors);
        return (T) enhancer.create();
    }

    public static <T> T createProxy(Class<T> targetClass, CallbackHelper interceptors) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass);
        enhancer.setCallbackFilter(interceptors);
        return (T) enhancer.create();
    }
}
