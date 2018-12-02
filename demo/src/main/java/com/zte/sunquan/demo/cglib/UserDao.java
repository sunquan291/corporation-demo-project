package com.zte.sunquan.demo.cglib;

/**
 * Created by 10184538 on 2017/2/24.
 */
public class UserDao extends Dao implements UserInterface{
    private String name;
    private int gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
