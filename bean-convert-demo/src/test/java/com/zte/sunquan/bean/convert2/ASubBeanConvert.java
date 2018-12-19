package com.zte.sunquan.bean.convert2;

import com.google.gson.Gson;
import com.zte.sunquan.bean.annoation.Converter;

public class ASubBeanConvert implements Converter<ASubBean, String> {
    private static final Gson gson = new Gson();

    @Override
    public String convert(ASubBean value) {
        return gson.toJson(value);
    }

    @Override
    public ASubBean reConvert(String value) {
        return gson.fromJson(value, ASubBean.class);
    }
}
