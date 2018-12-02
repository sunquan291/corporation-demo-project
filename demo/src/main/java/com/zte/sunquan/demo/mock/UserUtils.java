package com.zte.sunquan.demo.mock;

import java.io.File;

/**
 * Created by sunquan on 2017/12/6.
 */
public class UserUtils {
    public static final String LINE = "line";
    private String name;

    public UserUtils() {
    }

    public UserUtils(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static String getOutput() {
        return "hello,world";
    }

    public boolean isExit(File file) {
        return file.exists();
    }

    public String copyFile(File file) {
        if (isExit(file))
            return "success";
        else
            return "failure";
    }
}
