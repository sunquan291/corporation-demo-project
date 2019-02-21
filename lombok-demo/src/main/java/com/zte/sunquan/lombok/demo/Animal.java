package com.zte.sunquan.lombok.demo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Animal class
 *
 * @author 10184538
 * @date 2019/2/21
 */
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Animal {
    private String id;
}
