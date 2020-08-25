package com.gupaoedu.demo03;

import com.gupaoedu.demo04.ImportConfiguration;
import com.gupaoedu.demo04.ImportService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
public class Demo04Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext=new
                AnnotationConfigApplicationContext(SpringConfiguration.class);
        System.out.println(applicationContext.getBean(ImportService.class));
    }
}
