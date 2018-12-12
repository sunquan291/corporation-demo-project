package com.zte.sunquan.bean.json2;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "class")//原则上不需要这行
public class Car extends Vechile {
    private String carName;
}
