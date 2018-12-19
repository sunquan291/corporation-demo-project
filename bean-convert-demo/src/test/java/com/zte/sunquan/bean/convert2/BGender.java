package com.zte.sunquan.bean.convert2;

import com.zte.sunquan.bean.covert.Indexable;

public enum BGender implements Indexable<BGender> {
    UNKNOWN(0), BOY(1), GIRL(2);
    int index;

    BGender(int index) {
        this.index = index;
    }

    public static int toIndex(String name) {
        BGender gender = BGender.valueOf(name);
        if (gender != null) {
            return gender.index;
        } else
            return BGender.UNKNOWN.index;
    }

    @Override
    public Integer index(BGender bGender) {
        return bGender == null ? UNKNOWN.index : bGender.index;
    }
}
