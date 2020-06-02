package com.zte.sunquan.dao;

import com.zte.sunquan.bean.User;

import java.util.List;

public interface UserDao {
    User getById(int id);

    List<User> getAllUser();

    boolean addUser(User user);
}
