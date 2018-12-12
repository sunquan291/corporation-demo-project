package com.zte.sunquan.bean.json;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")//返回的JSON中会生成一个type字段，但为dog或cat
@JsonSubTypes({
        @JsonSubTypes.Type(value = Dog.class,
                name = "dog"),
        @JsonSubTypes.Type(value = Cat.class,
                name = "cat")
})
public class Animal {
    private String name;
}
