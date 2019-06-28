package com.zte.sunquan.lombol;

import java.io.Serializable;

/**
 * IEnum class
 *
 * @author 10184538
 * @date 2019/6/27
 */
public interface IEnum<T extends Serializable> {
    /**
     *
     * @return
     */
    T getValue();
}
