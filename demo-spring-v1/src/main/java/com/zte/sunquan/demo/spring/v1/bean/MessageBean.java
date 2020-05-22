package com.zte.sunquan.demo.spring.v1.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author sunquan
 */
@Component("myBean")
//@ComponentScan
public class MessageBean {
    @Value("abc")
    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    public void show() {
        System.out.println("Message: " + getMsg());
    }
}
