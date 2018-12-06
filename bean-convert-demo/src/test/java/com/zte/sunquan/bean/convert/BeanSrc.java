package com.zte.sunquan.bean.convert;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class BeanSrc extends Base {
    private String name;
    private int age;
    private Gender gender;

    private SubBean subBean;

    private String infoDetails;
    @JsonProperty("not-params")
    private String params;
    //private String[] params;
    //private List<String> params2;
    //private List<SubBean> subBeans;

}
