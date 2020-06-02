package com.zte.sunquan.baits;

import com.zte.sunquan.bean.User;
import com.zte.sunquan.dao.UserDao;

/**
 * @Author: Livio
 * @Date: 2020/6/1 23:00
 */
public class MainTest {
    public static void main(String[] args) {
        SqlSession session=new SqlSession(new Configuration(),new Executor());
        UserDao mapper = session.getMapper(UserDao.class);
        User byId = mapper.getById(2);
        System.out.println(byId);
    }
}
