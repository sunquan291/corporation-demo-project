package com.zte.sunquan.bean.json.test;

import java.util.Timer;
import java.util.TimerTask;

import lombok.Data;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@Data
@ToString(callSuper = true)
//@JsonNaming(PropertyNamingStrategy.KebabCaseStrategy.class)
public class Cat extends Animal {
    //@JsonProperty("old")
    private int age;

    //@JsonProperty("n-route-id")
    private String nRouteId;

}
