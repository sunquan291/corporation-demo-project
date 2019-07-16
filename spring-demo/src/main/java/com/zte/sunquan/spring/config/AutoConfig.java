package com.zte.sunquan.spring.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;

import com.zte.sunquan.spring.bean.Book;

/**
 * AutoConfig class
 *
 * @author 10184538
 * @date 2019/7/16
 */
@ConditionalOnClass({Book.class})
public class AutoConfig {
}
