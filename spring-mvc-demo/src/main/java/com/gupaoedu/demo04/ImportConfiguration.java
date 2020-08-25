package com.gupaoedu.demo04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
@Configuration
public class ImportConfiguration {


    @Bean
    public ImportService importService(){
        return new ImportService();
    }
}
