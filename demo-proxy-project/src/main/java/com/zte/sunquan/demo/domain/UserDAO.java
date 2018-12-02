package com.zte.sunquan.demo.domain;

/**
 * Created by 10184538 on 2018/5/31.
 */
public interface UserDAO {
    boolean addUser(String id, String name, String password);

    boolean delUser(String id);
}
