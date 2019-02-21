package com.zte.sunquan.lombok.demo;

import lombok.EqualsAndHashCode;

/**
 * SuperCat class
 *
 * @author 10184538
 * @date 2019/2/21
 */
@EqualsAndHashCode(of = "cat")
public class SuperCat {
    private Cat cat;

    public SuperCat(Cat cat) {
        this.cat = cat;
    }
}
