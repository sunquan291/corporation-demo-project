package com.zte.sunquan.demo;

import com.zte.sunquan.demo.service.LoginService;
import com.zte.sunquan.demo.service.impl.LoginServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Livio
 * @Date: 2020/7/22 21:56
 * 在扫描目录下，会被spring自动扫描
 */
//@Configuration
public class SpringBootGpConfig {
    @Bean
    public LoginService loginService() {
        return new LoginServiceImpl();
    }
}
