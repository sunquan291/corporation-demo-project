package com.zte.sdn.oscp.topology.framework.core.handler;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Deactivate;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.zte.sdn.oscp.framework.service.MainServiceBase;
import com.zte.sdn.oscp.framework.service.ServiceProvider;

/**
 * 抽象处理注册器，实现公共方法
 *
 * @author 10043533 2018-7-12
 */
public abstract class AbstractHandlerRegister<T extends Handler> extends MainServiceBase implements HandlerRegister<T> {

    private final Object lock = new Object();
    private List<HandlerExt<T>> handlerList = Lists.newLinkedList();
    private List<T> immutableServiceList = ImmutableList.of();

    protected AbstractHandlerRegister() {
        this(null);
    }

    protected AbstractHandlerRegister(ServiceProvider parent) {
        super(parent);
    }

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void addHandler(T handler) {
        addHandler(handler, handler.getPriority());
        logger.info("Add handler:{} instance:{},priority:{}", handler.getClass().getSimpleName(), handler, handler.getPriority());
        System.out.println(handler.getClass().getSimpleName() + "," + handler.getPriority());
    }

    @Override
    public void addHandler(T handler, Integer pri) {
        synchronized (lock) {
            handlerList.add(new HandlerExt<>(handler, pri));
            Collections.sort(handlerList);
            immutableServiceList = ImmutableList.copyOf(handlerList.stream()
                    .map(HandlerExt::getHandler).collect(Collectors.toList()));
        }
    }

    @Override
    public void removeHandler(T handler) {
        synchronized (lock) {
            handlerList = handlerList.stream()
                    .filter((handlerExt) -> handlerExt.getHandler() != handler).collect(Collectors.toList());
            immutableServiceList = ImmutableList.copyOf(handlerList.stream()
                    .map(HandlerExt::getHandler).collect(Collectors.toList()));
        }
    }

    @Override
    public void removeHandler(Class<T> handlerClass) {
        synchronized (lock) {
            handlerList = handlerList.stream()
                    .filter((handlerExt) -> handlerExt.getHandler().getClass() != handlerClass).collect(Collectors.toList());
            immutableServiceList = ImmutableList.copyOf(handlerList.stream()
                    .map(HandlerExt::getHandler).collect(Collectors.toList()));
        }
    }

    @Override
    public List<T> getHandlerList() {
        return immutableServiceList;
    }

    @Override
    public <R> R foreach(Function<T, R> function) {
        List<T> handlers = immutableServiceList.stream()
                .filter(Handler::enable).collect(Collectors.toList());
        if (!handlers.isEmpty()) {
            R result = function.apply(handlers.get(0));
            handlers.remove(0);
            for (Handler handler : handlers) {
                result = function.apply(result);
            }
        }
    }



    @Activate
    @Override
    protected void activate(BundleContext bundleContext) {
        super.activate(bundleContext);
    }

    @Deactivate
    @Override
    protected void deactivate() {
        super.deactivate();
    }

    private class HandlerExt<T extends Handler> implements Comparable<HandlerExt<T>> {
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


}
