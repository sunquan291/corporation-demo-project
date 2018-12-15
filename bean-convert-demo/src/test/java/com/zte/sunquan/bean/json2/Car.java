package com.zte.sunquan.bean.json2;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "class")//原则上不需要这行
public class Car extends Vechile {
    private String carName;

    private boolean isVirtual;

    private List<Tel> tels;

    @Data
    static class Tel{
        public Tel(){}
    }
}
