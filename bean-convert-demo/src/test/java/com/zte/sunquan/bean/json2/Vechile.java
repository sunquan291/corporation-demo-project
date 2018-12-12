package com.zte.sunquan.bean.json2;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.zte.sunquan.bean.json.Cat;
import com.zte.sunquan.bean.json.Dog;

@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "class")//返回的JSON中会生成一个type字段，但为dog或cat
@JsonSubTypes({
        @JsonSubTypes.Type(value = Car.class,
                name = "car"),
        @JsonSubTypes.Type(value = Bus.class,
                name = "bus")
})
public class Vechile {
}
