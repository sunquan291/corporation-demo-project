package com.zte.sdn.oscp.mdb;

import com.zte.sdn.oscp.mdb.client.MySqlClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Livio
 * @Date: 2020/10/9 23:08
 */
@Configuration
@EnableConfigurationProperties(MydbProperties.class)
public class MydbAutoConfiguration {

    @Bean
    public MySqlClient mySqlClient(MydbProperties mydbProperties) {
        //返回一个操作Mysql的客户端对象
        return new MySqlClient(mydbProperties.getHost(),mydbProperties.getPort());
    }
}
