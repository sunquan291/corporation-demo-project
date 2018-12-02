package com.zte.sunquan.demo.hello.impl;

        import com.zte.sunquan.demo.hello.HelloService;
        import org.apache.felix.scr.annotations.Component;

/**
 * Created by 10184538 on 2017/1/12.
 */
//@Component//不一定需要
public abstract class AbstractHelloImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello,"+name;
    }
}
