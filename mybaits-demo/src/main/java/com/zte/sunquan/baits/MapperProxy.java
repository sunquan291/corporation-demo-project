package com.zte.sunquan.baits;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: Livio
 * @Date: 2020/6/1 23:04
 */
public class MapperProxy implements InvocationHandler {
    private SqlSession session;

    public MapperProxy(SqlSession session) {
        this.session = session;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1.查找SQL语句
        String intCls = method.getDeclaringClass().getName();
        String methodName = method.getName();
        String statement = intCls + "." + methodName;


        //2.执行SQL语句
        return session.selectOne(statement, method.getReturnType(), args);
    }
}
