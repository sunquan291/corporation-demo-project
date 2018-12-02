package com.zte.sunquan.demo.enu;

/**
 * Created by 10184538 on 2017/2/20.
 */
public enum NetType {
    Net1("1net1"), Net2("2net2");
    private String value;

    NetType(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "NetType{" +
                "value='" + value + '\'' +
                '}';
    }
}
