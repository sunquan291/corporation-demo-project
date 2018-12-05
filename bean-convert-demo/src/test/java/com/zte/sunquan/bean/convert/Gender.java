package com.zte.sunquan.bean.convert;

public enum Gender {
    UNKNOWN(0), BOY(1), GIRL(2);
    int index;

    Gender(int index) {
        this.index = index;
    }

    public static int toIndex(String name) {
        Gender gender = Gender.valueOf(name);
        if (gender != null) {
            return gender.index;
        } else
            return Gender.UNKNOWN.index;
    }
}
