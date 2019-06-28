package com.zte.sunquan.lombol;

import lombok.Getter;

public enum Gender implements BaseEnum<Integer, String> {
    /**
     *
     */
    Male(0, "BOY"),
    Female(1, "GIRl");

    @Getter
    private Integer value;
    @Getter
    private String desc;

    private static final java.util.Map<Integer, Gender> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<Integer, Gender> b = com.google.common.collect.ImmutableMap.builder();
        for (Gender enumItem : Gender.values()) {
            b.put(enumItem.getValue(), enumItem);
        }
        VALUE_MAP = b.build();
    }

    public static Gender forValue(Integer valueArg) {
        if (VALUE_MAP != null && VALUE_MAP.containsKey(valueArg)) {
            return VALUE_MAP.get(valueArg);
        }
        return Gender.Male;
    }

    Gender(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }


}
