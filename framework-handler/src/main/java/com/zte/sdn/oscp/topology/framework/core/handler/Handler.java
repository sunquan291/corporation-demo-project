package com.zte.sdn.oscp.topology.framework.core.handler;

/**
 * 本地处理器
 *
 * @author 10043533 2018-7-12
 */
public interface Handler {
    /**
     * 缺省优先级，不指定优先级时使用
     */
    Integer DEFAULT_PRI = 10000;

    /**
     * 获取优先级
     *
     * @return 优先级
     */
    default Integer getPriority() {
        return DEFAULT_PRI;
    }

    /**
     * 当前handler是否启动,默认启用
     *
     * @return
     */
    default boolean enable() {
        return true;
    }
}
