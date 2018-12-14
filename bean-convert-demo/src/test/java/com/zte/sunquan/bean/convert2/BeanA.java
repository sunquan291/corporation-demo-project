package com.zte.sunquan.bean.convert2;

import com.zte.sunquan.bean.annoation.Persistence;
import com.zte.sunquan.bean.annoation.PersistenceSerialize;
import com.zte.sunquan.bean.convert.Base;
import lombok.Data;

@Data
public class BeanA extends Base {
    private String name;
    private int age;
    private AGender gender;

    @Persistence(ASubBean2.class)
    private ASubBean subBean;

    @PersistenceSerialize
    private ASubBean aSubBean;

    private String infoDetails;

    private String params;

    private ASubBean bSubBean;

}
