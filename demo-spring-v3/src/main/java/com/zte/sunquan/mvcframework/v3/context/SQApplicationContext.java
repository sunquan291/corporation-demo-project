package com.zte.sunquan.mvcframework.v3.context;

/**
 * @Author: Livio
 * @Date: 2020/5/6 23:08
 */
public interface SQApplicationContext {
    Object getBean(String beanName);

    Object getBean(Class beanClsName);
}
