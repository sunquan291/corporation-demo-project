package com.zte.sunquan.demo.jms.mbean;

import java.util.List;

/**
 * Created by sunquan on 2017/9/29.
 */
public class Person extends AbstractPersonMBean {


    private String name;
    private int age;
    private Gender gender;
    private List<String> books;
    private long[] longs;
    private Integer[] integers;
    private byte[] bytes;
    private List<Hobby> hobbies;
    public Person(){

    }
    public Person(String name, int age, Gender gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public Person(String name, int age, Gender gender, List<String> books, long[] longs, Integer[] integers, byte[] bytes, List<Hobby> hobbies) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.books = books;
        this.longs = longs;
        this.integers = integers;
        this.bytes = bytes;
        this.hobbies = hobbies;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public List<String> getBooks() {
        return books;
    }

    @Override
    public long[] getLongs() {
        return longs;
    }

    @Override
    public Integer[] getIntegers() {
        return integers;
    }

    @Override
    public byte[] getBytes() {
        return bytes;
    }

    @Override
    public List<Hobby> getHobby() {
        return hobbies;
    }

    @Override
    public void printHello() {
        System.out.println("hello,world");
    }

    @Override
    public void printHello(String whoName) {
        System.out.println("hello,world-" + whoName);
    }
}
