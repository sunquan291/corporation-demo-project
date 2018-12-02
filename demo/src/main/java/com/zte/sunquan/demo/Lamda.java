package com.zte.sunquan.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by 10184538 on 2017/7/11.
 */

@FunctionalInterface
interface TriFunction<T, K, V, R> {
    R appaly(T t, K k, V v);
}

class Apple {
    private int a;
    private int b;
    private String c;

    public Apple(int a, int b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String getC() {
        return c;
    }

    public int getA() {
        return a;
    }
}

public class Lamda {
    public static void main(String[] args) {
        TriFunction<Integer, Integer, String, Apple> function = Apple::new;
        Apple apple = function.appaly(2, 3, "hello");
        System.out.println(apple.getC());
        List<Apple> apples = new ArrayList<>();
        apples.sort(Comparator.comparing(Apple::getA));
    }
}
