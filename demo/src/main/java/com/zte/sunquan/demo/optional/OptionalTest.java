package com.zte.sunquan.demo.optional;

import java.util.Optional;

/**
 * Created by 10184538 on 2017/8/25.
 */
public class OptionalTest {

    public static void main(String[] args) {

        User user = null;
        String aDefault = Optional.ofNullable(user).map(User::getName).orElse("default");
        System.out.println(aDefault);
    }
}

class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}