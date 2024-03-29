package com.zte.sunquan.demo.model2;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Cat class
 *
 * @author 10184538
 * @date 2019/6/14
 */
@Data
@AllArgsConstructor
public class Cat implements Animal{
    private int id;
    private String name;
}
