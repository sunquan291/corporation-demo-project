package com.zte.sunquan.bean.convert;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class BeanDst extends Base{
    private String name;
    private int age;
    private int gender;
    //private String topic;
    private SubBean subBean;
}
