package com.zte.sunquan.bean.convert2;

import lombok.Data;

import com.zte.sunquan.bean.annoation.Store;
import com.zte.sunquan.bean.annoation.StoreConvert;
import com.zte.sunquan.bean.convert.Base;

@Data
public class BeanA extends Base {
    private String name;
    private int age;
    private AGender gender;

    @Store(ASubBean2.class)
    private ASubBean subBean;

    @StoreConvert(converter = ASubBeanConvert.class)
    private ASubBean aSubBean;

    private String infoDetails;

    private String params;

    private ASubBean bSubBean;

    private BGender bGender;

}
