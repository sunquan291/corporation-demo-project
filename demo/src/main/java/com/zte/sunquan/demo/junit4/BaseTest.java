package com.zte.sunquan.demo.junit4;

import org.junit.Before;

/**
 * Created by 10184538 on 2016/12/23.
 */
public class BaseTest {
    @Before
    public void before(){
        System.out.println("base test @before");
    }
    @Before
    public void ini(){
        System.out.println("init");
    }
}
