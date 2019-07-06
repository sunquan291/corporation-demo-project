package com.zte.sunquan.spi;

import com.zte.sunquan.spi.demo.Cow;

/**
 * Animal class
 *
 * @author 10184538
 * @date 2019/7/6
 */
public interface Handler {
    void process(String input);

    void process(Cow input);

    default Integer getPriority() {
        return 10;
    }
}
