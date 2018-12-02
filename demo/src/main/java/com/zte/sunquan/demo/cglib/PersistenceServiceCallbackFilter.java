package com.zte.sunquan.demo.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * Created by 10184538 on 2017/2/24.
 */
public class PersistenceServiceCallbackFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if (method.getName().startsWith("set"))
            return 0;
        else
            return 1;
    }
}
