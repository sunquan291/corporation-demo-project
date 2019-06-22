package com.zte.sunquan.demo.gson.test;

import java.util.List;

import lombok.Data;

import com.zte.sunquan.demo.model2.Animal;

/**
 * Zoo class
 *
 * @author 10184538
 * @date 2019/6/18
 */
@Data
public class Zoo {
    private List<Animal> animals;
}
