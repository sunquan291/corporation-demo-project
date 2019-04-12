package com.zte.sunquan.demo.model;

import java.util.List;

/**
 * Created by james on 6/6/17.
 * 为演示GraphQL创建的实体
 * <p>
 * blog: www.zhaiqianfeng.com
 */
public class User {
    private String id;
    private String sex;
    private String name;
    private String intro;
    private String[] skills;

    private List<Hobby> hobbys;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Hobby> getHobbys() {
        return hobbys;
    }

    public void setHobbys(List<Hobby> hobbys) {
        this.hobbys = hobbys;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }
}
