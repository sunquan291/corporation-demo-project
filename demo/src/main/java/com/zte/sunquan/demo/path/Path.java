package com.zte.sunquan.demo.path;

import java.io.File;
import java.net.URISyntaxException;

/**
 * Created by 10184538 on 2016/11/17.
 */
public class Path {

    /***
     * 取程序运行时的目录路径<br>
     * 即程序在那里双击或BAT文件所在的路径
     *
     * @return E:\demo\target\classes
     */
    public static String getClassPath() {
        String path = "";
        try {
            path = new File(Path.class.getClassLoader().getResource("").toURI()).getPath();
        } catch (URISyntaxException ex) {
        }
        return path;
    }

    /**
     * @return E:\demo
     */
    public static String getUserDir() {
        String path = "";
        path = System.getProperty("user.dir");
        return path;
    }

    /**
     *
     * @return E:\demo\target\classes
     */
    public static String getClassPath2() {
        String path = "";
            path = new File(Path.class.getResource("/").getPath()).getPath();
        return path;
    }

    public static void main(String[] args) {
        String path = "";
        path = getClassPath();
        System.out.println(path);
        path = getUserDir();
        System.out.println(path);
        path = getClassPath2();
        System.out.println(path);
    }
}
