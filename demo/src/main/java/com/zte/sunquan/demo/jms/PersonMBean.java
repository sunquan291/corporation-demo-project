package com.zte.sunquan.demo.jms;

import java.util.List;

/**
 * Created by sunquan on 2017/9/29.
 */
public interface PersonMBean {
    String getName();

    void setName(String name);

    int getAge();

    Gender getGender();

    List<String> getBooks();

    long[] getLongs();

    Integer[] getIntegers();

    byte[] getBytes();

    List<Hobby> getHobby();

    void printHello();

    void printHello(String whoName);

    enum Gender {
        boy, girl;
    }
}
