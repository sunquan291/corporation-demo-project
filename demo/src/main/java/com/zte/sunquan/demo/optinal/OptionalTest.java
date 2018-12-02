package com.zte.sunquan.demo.optinal;

import org.junit.Test;

import java.util.Optional;

/**
 * Created by 10184538 on 2017/4/13.
 */
public class OptionalTest {
    private static final String PRETTY = "-pretty";
    private static final String SHORT_PRETTY = "-p";

    private static final String SIZE = "-size";
    private static final String SHORT_SIZE = "-s";

    private boolean isPretty(String arg) {
        return Optional.ofNullable(arg).map(a -> {
            if (arg.equalsIgnoreCase(PRETTY) || arg.equalsIgnoreCase(SHORT_PRETTY))
                return true;
            return false;
        }).orElse(false);
    }

    private boolean isSize(String arg) {
        return Optional.ofNullable(arg).map(a -> {
            if (arg.equalsIgnoreCase(SIZE) || arg.equalsIgnoreCase(SHORT_SIZE))
                return true;
            return false;
        }).orElse(false);
    }

    @Test
    public void test() {
        OptionalTest test = new OptionalTest();
        boolean flag = test.isPretty("S");
        System.out.println(flag);
    }

    @Test
    public void test2(){
        boolean a = Object.class.isAssignableFrom("A".getClass());
        System.out.println(a);
    }
}
