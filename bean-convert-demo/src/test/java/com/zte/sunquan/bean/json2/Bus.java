package com.zte.sunquan.bean.json2;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
@Data
//@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "class")
public class Bus extends Vechile{
    private String busName;
}
