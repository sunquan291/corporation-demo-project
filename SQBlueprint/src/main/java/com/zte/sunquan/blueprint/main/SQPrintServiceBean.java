package com.zte.sunquan.blueprint.main;

/**
 * Created by 10184538 on 2017/11/25.
 */
public class SQPrintServiceBean {
    private Object printService;
    private String value;

    public void init() {
        System.out.println("printService:" + printService);
        System.out.println("value:" + value);
    }

    public void setPrintService(Object printService) {
        this.printService = printService;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
