package com.zte.sunquan.ext;

import com.zte.sunquan.demo.service.LoginService;
import com.zte.sunquan.demo.service.impl.LoginServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Livio
 * @Date: 2020/7/22 22:03
 */
@Configuration
public class SpringBootGp2Config {
    @Bean
    public LoginService loginService() {
        return new LoginServiceImpl();
    }
}
