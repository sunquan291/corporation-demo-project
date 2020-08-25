package com.zte.sunquan.demo.dao;

import com.zte.sunquan.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Livio
 * @Date: 2020/7/17 23:22
 */
@Mapper
public interface UserMapper {
    void addUser(User user);
}
