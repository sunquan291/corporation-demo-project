package com.zte.sunquan.bean.convert2;

import com.zte.sunquan.bean.annoation.Store;
import com.zte.sunquan.bean.annoation.StoreSerialize;
import com.zte.sunquan.bean.convert.Base;
import lombok.Data;

@Data
public class BeanA extends Base {
    private String name;
    private int age;
    private AGender gender;

    @Store(ASubBean2.class)
    private ASubBean subBean;

    @StoreSerialize
    private ASubBean aSubBean;

    private String infoDetails;

    private String params;

    private ASubBean bSubBean;

}
