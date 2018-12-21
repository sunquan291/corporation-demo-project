package com.zte.sunquan.bean.convert;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Set;

@Data
public class BeanSrc extends Base {
    private String name;
    private int age;
    private Gender gender;

    private SubBean subBean;
    @JsonProperty("info-details")
    private String infoDetails;
    @JsonProperty("not-params")
    private String params;
//    private String[] stringArray;
//    private List<String> stringList;
//    private Set<String> stringSet;
    //private List<SubBean> subBeans;

}
