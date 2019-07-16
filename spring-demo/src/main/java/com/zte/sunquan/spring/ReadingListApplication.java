package com.zte.sunquan.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zte.sunquan.spring.convert.EncodingConvert;

/**
 * ReadingListApplication class
 *
 * @author 10184538
 * @date 2019/3/21
 */

@SpringBootApplication
public class ReadingListApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ReadingListApplication.class, args);
        System.out.println(context.getBeansOfType(EncodingConvert.class));
    }
}
