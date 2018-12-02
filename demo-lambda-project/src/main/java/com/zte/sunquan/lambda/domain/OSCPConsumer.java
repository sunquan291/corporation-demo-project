package com.zte.sunquan.lambda.domain;

/**
 * Created by 10184538 on 2018/6/1.
 */
@FunctionalInterface
public interface OSCPConsumer<T> {
    void invoke(T t);
}
