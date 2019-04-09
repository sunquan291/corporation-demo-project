package com.zte.sunquan.demo.model2;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Dog class
 *
 * @author 10184538
 * @date 2019/4/8
 */
@Data
@AllArgsConstructor
public class Dog implements Serializable {
    private int id;
    private String dogName;
}
