package com.zte.sunquan.demo.service.impl;

import com.zte.sunquan.demo.bean.User;
import com.zte.sunquan.demo.dao.UserDao;
import com.zte.sunquan.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Livio
 * @Date: 2020/7/17 23:24
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
}
