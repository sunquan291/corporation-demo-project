package com.zte.sunquan.bean.annoation;

public interface Converter<IN, OUT> {
    public OUT convert(IN value);

    public IN reConvert(OUT value);
}
