package com.zte.sunquan.demo.jms.mbean;

import java.util.List;

/**
 * Created by sunquan on 2017/9/29.
 */
public interface PersonMBean {
    String getName();

    void setName(String name);

    int getAge();

    Gender getGender();//代码中可以获取，但JConsole显示为unavailable

    List<String> getBooks();

    long[] getLongs();

    Integer[] getIntegers();

    byte[] getBytes();

    //代码中可以获取，但JConsole显示为unavailable,所以增加了AbstractPersonMBean用于处理该对象字段
    List<Hobby> getHobby();

    List<String> getHobbyContent();

    void printHello();

    void printHello(String whoName);

    enum Gender {
        boy, girl;
    }
}
