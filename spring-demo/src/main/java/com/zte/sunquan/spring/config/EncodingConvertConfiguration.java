package com.zte.sunquan.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.zte.sunquan.spring.condition.GBKCondition;
import com.zte.sunquan.spring.condition.UTF8Condition;
import com.zte.sunquan.spring.convert.EncodingConvert;
import com.zte.sunquan.spring.convert.GBKEncodingConvert;
import com.zte.sunquan.spring.convert.UTF8EncodingConvert;

/**
 * EncodingConvertConfiguration class
 *
 * @author 10184538
 * @date 2019/7/16
 */
@Configuration
public class EncodingConvertConfiguration {

    @Bean
    @Conditional(GBKCondition.class)
    public EncodingConvert createGBKEncodingConvert() {
        return new GBKEncodingConvert();
    }

    @Bean
    @Conditional(UTF8Condition.class)
    public EncodingConvert createUTF8EncodingConvert() {
        return new UTF8EncodingConvert();
    }
}
