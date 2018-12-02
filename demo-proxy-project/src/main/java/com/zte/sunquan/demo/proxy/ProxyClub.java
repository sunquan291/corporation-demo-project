package com.zte.sunquan.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by 10184538 on 2018/5/31.
 * 静态代理
 * 第一步：创建代理Club用于代理真实对象
 * 第二步：一般编写切入方法的逻辑（或直接修改方法执行逻辑）
 * 第三步：根据代理Club创建代理实例(基于接口）
 * 第四步：执行方法
 */
public class ProxyClub<T> implements InvocationHandler {
    private T t;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        Object result = method.invoke(t, args);
        after();
        return result;
    }

    private void doBefore() {
        System.out.println("before invoke");
    }

    private void after() {
        System.out.println("after invoke");
    }

    public void setRealObject(T t) {
        this.t = t;
    }
}
