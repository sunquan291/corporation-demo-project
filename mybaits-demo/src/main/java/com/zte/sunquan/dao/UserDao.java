package com.zte.sunquan.dao;

import java.util.List;

import com.zte.sunquan.bean.User;

public interface UserDao {
    List<User> getAllUser();

    boolean addUser(User user);
}
