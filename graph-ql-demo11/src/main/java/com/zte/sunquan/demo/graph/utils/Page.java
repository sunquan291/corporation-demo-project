package com.zte.sunquan.demo.graph.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Page class
 *
 * @author 10184538
 * @date 2019/7/6
 */
@Data
@AllArgsConstructor
public class Page {
    private int offset;
    private int limit;
}
