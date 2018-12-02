package com.zte.sunquan.demo.mask;

/**
 * Created by 10184538 on 2017/3/10.
 */
public class StringSwitchTest {

    public static void test() {
        String tag = "hello";
        switch (tag) {
            case "a":
                break;
            case "b":
                break;
            case "c":
                break;
            case "d":
                break;
            case "e":
                break;
            case "f":
                break;
            case "g":
                break;
            case "h":
                break;
            case "i":
                break;
            case "j":
                break;
            case "k":
                break;
            case "l":
                break;
            case "i1":
                break;
            case "j1":
                break;
            case "k1":
                break;
            case "l1":
                break;
            case "i2":
                break;
            case "j2":
                break;
            case "k2":
                break;
            case "l2":
                break;
            case "i3":
                break;
            case "j3":
                break;
            case "k3":
                break;
            case "l3":
                break;
            case "i4":
                break;
            case "j4":
                break;
            case "k4":
                break;
            case "hello":
                System.out.println(tag);
                break;

        }
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 1000; i ++)
            StringSwitchTest.test();
        System.out.println(System.currentTimeMillis() - begin);
    }

}
