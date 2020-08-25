package com.gupaoedu.demo03;

import com.gupaoedu.demo04.ImportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
@ComponentScan("com.gupaoedu.demo03")
@Configuration  //<applicationContext.xml
@Import(ImportConfiguration.class)
public class SpringConfiguration {

    @Bean
    public Demo04Service demo04Service(Demo03Service demo03Service){
        Demo04Service demo04Service=new Demo04Service();
        demo04Service.setDemo03Service(demo03Service);
        return demo04Service;
    }

}
