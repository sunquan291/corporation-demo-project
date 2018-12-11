package com.zte.sunquan.bean.json;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Data
@JsonTypeName(value = "dog")
//@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,property = "class")//使用类名赋值class
public class Dog extends Animal {
    private int age;
}
