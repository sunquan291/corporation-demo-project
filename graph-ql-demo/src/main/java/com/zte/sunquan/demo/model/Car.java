package com.zte.sunquan.demo.model;

/**
 * Car class
 *
 * @author 10184538
 * @date 2019/4/13
 */
public class Car implements Vehicle {
    private String id;
    private String userId;
    private String name;
    private long price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
