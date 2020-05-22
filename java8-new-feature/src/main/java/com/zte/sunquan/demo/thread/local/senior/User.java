package com.zte.sunquan.demo.thread.local.senior;

import lombok.Data;

/**
 * @Author: Livio
 * @Date: 2020/5/7 22:53
 */
@Data
public class User {
    private int id;
    private String name;
    private int age;
    private String threadName;
}
