package com.zte.sunquan.demo.hello.impl;

import com.zte.sunquan.demo.hello.ByeService;
import com.zte.sunquan.demo.hello.HelloService;
import org.apache.felix.scr.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by 10184538 on 2017/1/12.
 */
@Component(immediate = true)
@Service
public class HelloImpl extends AbstractHelloImpl implements HelloService {

    //make ByeService activate at first
    @Reference(cardinality = ReferenceCardinality.MANDATORY_UNARY)
    private ByeService byeService;

    @Activate
    protected void activate() {
        System.out.println("HelloImpl activate");
        System.out.println(this.sayHello("sunquan"));
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 100) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (byeService != null)
                        System.out.println(byeService.sayBye("sunquan")+"---"+i);
                    i++;
                }
            }
        }).start();
    }

    @Deactivate
    protected void deActivate() {
        System.out.println("HelloImpl deActivate");
        System.out.println(byeService.sayGoodBye("sunquan"));
        System.out.println(byeService.sayBye("sunquan"));
    }

    @Override
    public String sayNice(String name) {
        return "Nice to meet you " + name;
    }
}
