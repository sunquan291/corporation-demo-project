package com.zte.sunquan.demo.graph.domain;

import lombok.Data;

/**
 * Bus class
 *
 * @author 10184538
 * @date 2019/7/6
 */
@Data
public class Bus implements Vehicle {
    private float price;
    private int seats;
}
