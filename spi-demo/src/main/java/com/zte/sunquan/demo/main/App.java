package com.zte.sunquan.demo.main;

import java.util.ServiceLoader;

import com.zte.sunquan.spi.Animal;

/**
 * App class
 *
 * @author 10184538
 * @date 2019/7/6
 */
public class App {
    //这样方式可以取代目前的handler机制吗，省去注册的步骤
    //优先级控制
    public static void main(String[] args) {
        ServiceLoader<Animal> shouts = ServiceLoader.load(Animal.class);
        for (Animal s : shouts) {
            System.out.println(s.getClass().getName());
            s.sayHello();
        }
    }
}
