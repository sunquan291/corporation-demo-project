package com.zte.sunquan.bean.json.test;

import lombok.Data;
import lombok.ToString;

@Data
//@JsonTypeName(value = "dog")
@ToString(callSuper = true)
//@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,property = "class")//使用类名赋值class
//@JsonIgnoreProperties(ignoreUnknown=true)
public class Dog extends Animal {
    private int age;
}
