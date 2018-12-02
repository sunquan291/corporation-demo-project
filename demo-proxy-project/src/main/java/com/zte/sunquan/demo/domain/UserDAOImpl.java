package com.zte.sunquan.demo.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10184538 on 2018/5/31.
 */
public class UserDAOImpl implements UserDAO {

    private List<String> names=new ArrayList<>();

    @Override
    public boolean addUser(String id, String name, String password) {
        System.out.printf("Add user %s success.\n", name);
        names.add(name);
        return true;
    }

    @Override
    public boolean delUser(String id) {
        System.out.printf("Add user %s success.\n", id);
        return true;
    }
}
