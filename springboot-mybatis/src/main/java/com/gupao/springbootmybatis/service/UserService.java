package com.gupao.springbootmybatis.service;

import com.gupao.springbootmybatis.dao.UserMapper;
import com.gupao.springbootmybatis.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findByUsername(String username) {
        return userMapper.find(username);
    }


    public List<User> listUser() {
        return userMapper.list();
    }


    public int insertUser(User user) {
        return userMapper.insert(user);
    }


    public int updateUser(User user) {
        return userMapper.update(user);
    }


    public int delete(int id) {
        return userMapper.delete(id);
    }
}
