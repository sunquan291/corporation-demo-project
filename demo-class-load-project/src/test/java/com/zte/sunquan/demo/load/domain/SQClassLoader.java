package com.zte.sunquan.demo.load.domain;

/**
 * Created by 10184538 on 2017/11/29.
 */
public class SQClassLoader extends ClassLoader {

    public Class defineClass(byte[] b, String className) {
        return super.defineClass(className, b, 0, b.length);
    }
}
