package com.zte.sunquan.demo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by 10184538 on 2017/7/31.
 */
@Retention(RetentionPolicy.RUNTIME)
@interface TestCases {
    TestCase[] value();
}
