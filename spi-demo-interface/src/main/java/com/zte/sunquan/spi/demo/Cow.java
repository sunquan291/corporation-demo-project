package com.zte.sunquan.spi.demo;

/**
 * Cow class
 *
 * @author 10184538
 * @date 2019/7/6
 */
public class Cow {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cow{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
