package com.zte.sunquan.demo.spring.v1;

import com.zte.sunquan.demo.spring.v1.bean.MessageBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author sunquan
 */
public class MainTest {
    public static void main(String[] args) {
        //ApplicationContext ctx=new ClassPathXmlApplicationContext("spring_config.xml");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
        MessageBean sm = (MessageBean) ctx.getBean("myBean");
        sm.show();
    }
}
