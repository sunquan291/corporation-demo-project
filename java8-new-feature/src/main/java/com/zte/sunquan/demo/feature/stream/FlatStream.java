package com.zte.sunquan.demo.feature.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * 遍平化流示例
 */
public class FlatStream {

    public static void main(String[] args) {
        List<School> schools = new ArrayList<>();
        School school1 = new School();
        school1.cls.add("s1");
        school1.cls.add("s2");
        school1.cls.add("s3");
        School school2 = new School();
        school2.cls.add("a1");
        school2.cls.add("a2");
        school2.cls.add("a3");

        schools.add(school1);
        schools.add(school2);

        boolean b = schools.stream().flatMap(s -> s.cls.stream()).anyMatch("a2"::equals);
        System.out.println(b);
        b = schools.stream().flatMap(s -> s.cls.stream()).anyMatch("a4"::equals);
        System.out.println(b);
    }

}


class School {
    public List<String> cls = new ArrayList<>();
}