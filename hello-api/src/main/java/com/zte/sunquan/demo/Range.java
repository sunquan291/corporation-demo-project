package com.zte.sunquan.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 10184538 on 2017/6/12.
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Range {
    String maxValue() default "";

    String minValue() default "";

    String rangeContent() default "";
}
