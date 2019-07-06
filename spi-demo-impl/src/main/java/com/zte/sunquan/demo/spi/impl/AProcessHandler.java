package com.zte.sunquan.demo.spi.impl;


import com.zte.sunquan.spi.Handler;
import com.zte.sunquan.spi.demo.Cow;

/**
 * AProcessHandler class
 *
 * @author 10184538
 * @date 2019/7/6
 */
public class AProcessHandler implements Handler {
    @Override
    public void process(String input) {
        System.out.println("AProcessHandler:" + input);
        input += "AProcessHandler:";
    }

    @Override
    public void process(Cow input) {
        System.out.println("AProcessHandler:" + input);
        String name = input.getName();
        input.setName(name + "AProcessHandler");
    }

    @Override
    public Integer getPriority() {
        return 15;
    }
}
