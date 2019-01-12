package com.zte.sunquan.bean.json.test;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")//通过该字段判断真实类型
@JsonSubTypes({
        @JsonSubTypes.Type(value = Dog.class,
                name = "dog"),
        @JsonSubTypes.Type(value = Cat.class,
                name = "cat")
})
public class Animal {
    private String name;
}
