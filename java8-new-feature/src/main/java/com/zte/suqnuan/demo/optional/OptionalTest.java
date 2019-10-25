package com.zte.suqnuan.demo.optional;

import java.util.Optional;

public class OptionalTest {
    static String B() {
        System.out.println("B()...");
        return "B";
    }
    public static void main(String[] args) {
        //结论：Optional的orElse(T)若方法不是纯计算型的，有与数据库交互或者远程调用的，都应该使用orElseGet()
        //避免不必要的麻烦，都使用orElseGet
        System.out.println(Optional.of("A").orElse(B()));
        System.out.println(Optional.of("A").orElseGet(() -> B()));
    }
}
