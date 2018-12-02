package com.zte.sunquan.demo.actor.ask;

import java.io.Serializable;

/**
 * Created by 10184538 on 2017/10/10.
 */
public class Message implements Serializable{
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Message{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
