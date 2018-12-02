package com.zte.sunquan.demo.test.cases.util;

/**
 * Created by 10184538 on 2018/5/31.
 */
public class ExecutePlatform {
    public static boolean isOSGIPlatform() {
        String getenv = System.getenv("sun.java.command");
        String property = System.getProperty("sun.java.command");
        return (getenv != null && getenv.equals("org.apache.karaf.main.Main"))
                || (property != null && property.equals("org.apache.karaf.main.Main"));
    }
}
