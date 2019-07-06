package com.zte.sunquan.demo.domain;

import java.util.Objects;

import com.zte.sunquan.spi.Handler;

/**
 * HandlerExt class
 *
 * @author 10184538
 * @date 2019/7/6
 */
public class HandlerExt<T extends Handler> implements Comparable<HandlerExt<T>> {
    private T handler;
    private Integer pri;

    public HandlerExt(T handler, Integer pri) {
        this.handler = handler;
        this.pri = pri;
    }

    public T getHandler() {
        return handler;
    }

    public Integer getPri() {
        return pri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HandlerExt<?> that = (HandlerExt<?>) o;
        return Objects.equals(handler, that.handler) &&
                Objects.equals(pri, that.pri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pri);
    }

    @Override
    public int compareTo(HandlerExt<T> o) {
        return this.getPri() - o.getPri();
    }
}
