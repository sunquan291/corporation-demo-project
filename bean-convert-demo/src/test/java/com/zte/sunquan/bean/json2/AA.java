package com.zte.sunquan.bean.json2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AA implements Comparable<AA> {
    private int ab;

    public AA(int ab) {
        this.ab = ab;
    }

    public int getAb() {
        return ab;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AA{");
        sb.append("ab=").append(ab);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(AA o) {
        return this.ab - o.getAb();
    }

    public static void main(String[] args) {
         List<AA> handlerList = new ArrayList<>();
         handlerList.add(new AA(2));
        handlerList.add(new AA(1));
        Collections.sort(handlerList);
        handlerList.forEach(System.out::println);
    }
}
