package com.zte.sunquan.baits;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

/**
 * @Author: Livio
 * @Date: 2020/6/1 23:01
 */
public class Configuration {

    private static final ResourceBundle sqlMapping;

    static {
        sqlMapping = ResourceBundle.getBundle("sql");
    }


    public <T> T getMapper(Class cls, SqlSession session) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{cls},
                new MapperProxy(session));
    }

    public static ResourceBundle getSqlMapping() {
        return sqlMapping;
    }
}
