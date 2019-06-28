package com.zte.sunquan.lombol;

import java.io.Serializable;

/**
 * BaseEnum class
 *
 * @author 10184538
 * @date 2019/6/27
 */
public interface BaseEnum<V extends Serializable, D> /*extends IEnum<V>*/ {
    V getValue();
}
