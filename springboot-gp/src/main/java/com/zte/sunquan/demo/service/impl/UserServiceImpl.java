package com.zte.sunquan.demo.service.impl;

import com.zte.sunquan.demo.bean.User;
import com.zte.sunquan.demo.dao.UserMapper;
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
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }
}
