package com.zte.sunquan.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by 10184538 on 2017/2/20.
 */
public class ProxyInvocationHandler implements InvocationHandler {
    private Object beProxy;

    public ProxyInvocationHandler(Object beProxy) {
        super();
        this.beProxy = beProxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("proxy class:" + proxy.getClass() + "proxy method:" + method);

        return method.invoke(beProxy, args);
    }
}
