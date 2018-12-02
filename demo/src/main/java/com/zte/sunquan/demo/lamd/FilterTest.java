package com.zte.sunquan.demo.lamd;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 10184538 on 2017/3/6.
 */
public class FilterTest {

    public static void main(String[] args) {
        List<String> addressDataList = Lists.newArrayList("a", "b", "c", "a", "d");
        addressDataList.forEach(System.out::println);
//        addressDataList.stream()
//                .filter(addr -> addr.equals("a")).collect(Collectors.toList())
//                .forEach(addressDataList::remove);
        List<String> addressDataListt=addressDataList.stream()
                .filter(addr -> addr.equals("a")).collect(Collectors.toList());
        System.out.println("---------");
        addressDataList.forEach(System.out::println);
    }

}
