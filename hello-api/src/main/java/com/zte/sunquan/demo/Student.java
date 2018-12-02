package com.zte.sunquan.demo;

/**
 * Created by 10184538 on 2017/6/12.
 */
public class Student {
    @Range(rangeContent = "1 .. 3.14 | 10 | 20..max", maxValue = "100")
    private int age;
}
