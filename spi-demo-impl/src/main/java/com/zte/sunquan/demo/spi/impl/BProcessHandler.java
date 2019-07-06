package com.zte.sunquan.demo.spi.impl;


import com.zte.sunquan.spi.Handler;
import com.zte.sunquan.spi.demo.Cow;

/**
 * AProcessHandler class
 *
 * @author 10184538
 * @date 2019/7/6
 */
public class BProcessHandler implements Handler {
    @Override
    public void process(String input) {
        System.out.println("BProcessHandler:" + input);
        input += "BProcessHandler:";
    }

    @Override
    public void process(Cow input) {
        System.out.println("BProcessHandler:" + input);
        String name = input.getName();
        input.setName(name + "BProcessHandler");
    }

    @Override
    public Integer getPriority() {
        return 5;
    }
}
