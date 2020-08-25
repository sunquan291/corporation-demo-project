package com.gupaoedu.demo06;

import com.gupaoedu.demo03.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
public class Task02Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new
                AnnotationConfigApplicationContext(TaskConfiguration.class);
    }
}
