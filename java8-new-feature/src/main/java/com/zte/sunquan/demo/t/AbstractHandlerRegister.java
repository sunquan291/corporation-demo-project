package com.zte.sunquan.demo.t;

import java.util.function.Consumer;

/**
 * AbstractHandlerRegister class
 *
 * @author 10184538
 * @date 2019/4/26T
 */
public abstract class AbstractHandlerRegister<T extends Handler> implements HandlerRegister<T> {
    @Override
    public void foreach(Consumer<T> consumer) {

    }

    @Override
    public void addHandler(T handler) {
            Handler handler1=(Handler)handler;
    }
}
