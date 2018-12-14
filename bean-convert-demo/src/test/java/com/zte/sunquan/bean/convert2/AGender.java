package com.zte.sunquan.bean.convert2;

public enum AGender {
    UNKNOWN(0), BOY(1), GIRL(2);
    int index;

    AGender(int index) {
        this.index = index;
    }

    public static int toIndex(String name) {
        AGender gender = AGender.valueOf(name);
        if (gender != null) {
            return gender.index;
        } else
            return AGender.UNKNOWN.index;
    }
}
