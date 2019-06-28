package com.zte.sunquan.demo.model;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by james on 6/6/17.
 * 为演示GraphQL创建的实体
 * <p>
 * blog: www.zhaiqianfeng.com
 */
@Data
@NoArgsConstructor
public class User {
    private String id;
    private String gender;
    private String name;
    private String intro;
    private String[] skills;
    private List<Hobby> hobbys;
    private List<Vehicle> vehicles;
}
