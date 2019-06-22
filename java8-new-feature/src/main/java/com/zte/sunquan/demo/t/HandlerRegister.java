package com.zte.sunquan.demo.t;

import java.util.function.Consumer;

/**
 * HandlerRegister class
 *
 * @author 10184538
 * @date 2019/4/25
 */
public interface HandlerRegister<T extends Handler> {
    void foreach(Consumer<T> consumer);
    void addHandler(T handler);
}
