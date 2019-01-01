package com.zte.sunquan.bean.json;

import java.util.Timer;
import java.util.TimerTask;

import lombok.Data;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Data
@JsonTypeName(value = "cat")
@ToString(callSuper = true)
//@JsonNaming(PropertyNamingStrategy.KebabCaseStrategy.class)
//@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,property = "class")//使用类名赋值class
public class Cat extends Animal {
    private int age;

    //@JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("n-route-id")
    //@ApiModelProperty(name = "n-route-id", value = "nrouteId", hidden = true)
    private String nRouteId;

    public static void timer1() {
        Timer nTimer = new Timer();
        nTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("----设定要指定任务-----");
                nTimer.cancel();
            }
        }, 2000);
    }

    public static void main(String[] args) {
        Cat.timer1();
    }
}
