package com.zte.sunquan.spring.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * GBKCondition class
 *
 * @author 10184538
 * @date 2019/7/16
 */
public class UTF8Condition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String encoding = System.getProperty("file.encoding");
        if(encoding != null){
            return "utf-8".equals(encoding.toLowerCase());
        }
        return false;
    }
}
