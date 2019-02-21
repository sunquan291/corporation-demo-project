package com.zte.sunquan.lombok.demo;

import java.util.HashSet;
import java.util.Set;

/**
 * Main class
 *
 * @author 10184538
 * @date 2019/2/21
 */
public class Main {
    public static void main(String[] args) {
        Set<SuperCat> cats=new HashSet<>();
        Cat cat1=new Cat();
        cat1.setId("1");
        cat1.setName("cat1");

        SuperCat superCat1=new SuperCat(cat1);

        Cat cat2=new Cat();
        cat2.setId("2");
        cat2.setName("cat2");

        SuperCat superCat2=new SuperCat(cat2);
        Cat cat3=new Cat();
        cat3.setId("1");
        cat3.setName("cat3");

        //包装类型亦要实现hashCode和equals方法
        SuperCat superCat3=new SuperCat(cat3);
        cats.add(superCat1);
        cats.add(superCat2);
        cats.add(superCat3);

        System.out.println(cats);
    }
}
