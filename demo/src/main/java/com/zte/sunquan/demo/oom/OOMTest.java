package com.zte.sunquan.demo.oom;

import com.zte.sunquan.demo.la.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SQ on 2017/11/4.
 */
public class OOMTest {
    static List<User> list = new ArrayList<>();
    public static void main(String[] args) {

        while (true) {
            User user = new User("sunquan", 12);
            list.add(user);
            System.out.println(list.size());
        }
    }
}
