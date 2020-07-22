package com.zte.sunquan.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationImportSelector;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author sunquan
 * https://blog.csdn.net/shiyan719902675/article/details/106378107/
 */
@MapperScan("com.zte.sunquan.demo.dao")
@SpringBootApplication
@EnableAutoConfiguration
@Import({SpringBootGpSelectImport.class, AutoConfigurationImportSelector.class})
public class SpringBootGpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGpApplication.class, args);
    }

}
