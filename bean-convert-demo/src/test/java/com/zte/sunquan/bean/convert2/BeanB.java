package com.zte.sunquan.bean.convert2;

import lombok.Data;
import lombok.ToString;

import com.zte.sunquan.bean.convert.Base;

@Data
@ToString(callSuper = true)
public class BeanB extends Base {
    private String name;
    private int age;
    private int gender;
    private String aSubBean;
    private ASubBean bSubBean;
    private int bGender;
}
