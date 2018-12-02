package com.zte.sunquan.demo.jms.mbean;

/**
 * Created by 10184538 on 2017/9/29.
 */
public class Hobby {
    private String name;

    public Hobby(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hobby{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
