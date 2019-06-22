package com.zte.sunquan.demo.model2;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Animal class
 *
 * @author 10184538
 * @date 2019/6/14
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "class"
)
@JsonSubTypes({
        @JsonSubTypes.Type(
                value = Cat.class),
        @JsonSubTypes.Type(
                value = Fish.class)}
)
public interface Animal {
}
