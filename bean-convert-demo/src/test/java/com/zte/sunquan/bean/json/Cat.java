package com.zte.sunquan.bean.json;

import lombok.Data;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Data
@JsonTypeName(value = "cat")
@ToString(callSuper = true)
//@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,property = "class")//使用类名赋值class
public class Cat extends Animal {
    private int age;
}
