package com.zte.sunquan.demo.multiparam;

import scala.Int;

/**
 * Created by 10184538 on 2017/3/10.
 */
public class MulitiParam {
    public static final String EVENT_GROUP_NAME = "net-ip";

    public static void postEvent(Integer event) {
        System.out.println(event);
    }

    public static void postEvent(Integer event, String... groups) {
        System.out.println("2");
        for (String group : groups)
            postEvent(event);
    }

    public static void main(String[] args) {

        MulitiParam param=new MulitiParam();
        param.postEvent(1);
    }
}
