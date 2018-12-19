package com.zte.sunquan.bean.json;

import lombok.Data;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Data
@JsonTypeName(value = "dog")
@ToString(callSuper = true)
//@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,property = "class")//使用类名赋值class
@JsonIgnoreProperties(ignoreUnknown=true)
public class Dog extends Animal {
    private int age;
}
