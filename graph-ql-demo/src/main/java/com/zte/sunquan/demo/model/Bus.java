package com.zte.sunquan.demo.model;

/**
 * Bus class
 *
 * @author 10184538
 * @date 2019/4/13
 */
public class Bus implements Vehicle{
    private String id;
    private String userId;
    private String name;
    private long price;
    private int seats;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
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
