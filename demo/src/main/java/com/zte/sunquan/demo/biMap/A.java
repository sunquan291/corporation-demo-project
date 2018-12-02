package com.zte.sunquan.demo.biMap;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

/**
 * Created by 10184538 on 2017/4/19.
 */
public class A {
    List<String> result = Lists.newArrayList();

    @Test
    public void test() {
        for (int i = 0; i < 1000; i++) {
            result.add("hello,world," + i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            Optional<String> first = result.stream().filter((s) -> s.equals("hello,world,32")).findFirst();
//            System.out.println(first.orElse(null));
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void test2() {
        for (int i = 0; i < 1000; i++) {
            result.add("hello,world," + i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            Optional<String> first = result.parallelStream().filter((s) -> s.equals("hello,world,32")).findFirst();
//            System.out.println(first.orElse(null));
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
