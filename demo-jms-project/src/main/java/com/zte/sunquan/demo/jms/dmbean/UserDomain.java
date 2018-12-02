package com.zte.sunquan.demo.jms.dmbean;

import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.collect.Lists;
import com.zte.sunquan.demo.jms.mbean.Hobby;

/**
 * Created by 10184538 on 2018/5/29.
 * 如果某个对象想成为MBean,唯一针对开发者要求是指定其地址（或者使用默认包名来加类名来替换）
 * 存在一个问题，即name始终为null
 * 主要是由于注册mbean在父的默认构造函数中
 * 而name的设置，在有参构造函数中，滞后于注册逻辑（面向切面编程,代理？)
 */
public class UserDomain extends AbstractDynamicMBean {
    @ShowInBean
    private String name;
    @ShowInBean
    private int age;
    private AtomicInteger child;

    //非基本类型(默认以toString显示)
    //如果是列表，需要返回List<String>
    @ShowInBean("translateHobby")
    private Hobby hobby;

    public UserDomain() {
    }

    public UserDomain(String name) {
        this.name = name;
    }

    @Override
    public String[] beanParameters() {
        //Dynamic-Bean:type=UserDomain,Category=Default,name=##
        return new String[]{"Dynamic-Bean", this.getClass().getSimpleName(), "Default"
                , name};
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        notifyAttributeChange("Age", "java.lang.int", this.age, age);
        this.age = age;
    }

    @ShowInBean
    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    public void setChild(AtomicInteger child) {
        this.child = child;
    }

    @ShowInBean
    public void print() {
        System.out.println("hello,world");
    }

    public String translateHobby() {
        return "new Translate value:" + hobby.getName();
    }
}
