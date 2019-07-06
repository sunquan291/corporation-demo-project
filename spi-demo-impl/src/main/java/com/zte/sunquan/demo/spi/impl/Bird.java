package com.zte.sunquan.demo.spi.impl;

import com.zte.sunquan.spi.Animal;

/**
 * Bird class
 *
 * @author 10184538
 * @date 2019/7/6
 */
public class Bird implements Animal {
    @Override
    public String sayHello() {
        System.out.println("bird say hello.");
        return "bird say hello.";
    }
}
