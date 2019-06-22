package com.zte.sdn.oscp.topology.framework.core.handler;


import java.util.List;
import java.util.function.Function;

/**
 * 本地处理注册器
 *
 * @author 10043533 2018-7-12
 */
public interface HandlerRegister<T extends Handler> {

    /**
     * 添加处理器
     *
     * @param handler 处理器
     */
    void addHandler(T handler);

    /**
     * 添加处理器，可指定优先级
     *
     * @param handler 处理器
     * @param pri     优先级
     */
    void addHandler(T handler, Integer pri);

    /**
     * 移除处理器
     *
     * @param handler 处理器
     */
    void removeHandler(T handler);

    /**
     * 按类型移除处理器
     *
     * @param handlerClass 处理器类型
     */
    void removeHandler(Class<T> handlerClass);

    /**
     * 获得所有处理器
     *
     * @return 处理器列表
     */
    List<T> getHandlerList();

    <R> R foreach(Function<T, R> consumer);


}
