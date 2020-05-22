package com.gupaoedu.vip.spring.framework.aop.aspect;

import java.lang.reflect.Method;

/**
 * Created by Tom.
 */
public interface GPJoinPoint {
     Method getMethod();

     Object[] getArguments();

     Object getThis();

     void setUserAttribute(String key,Object value);

     Object getUserAttribute(String key);
}
