package com.zte.sunquan.demo.multi.list;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

/**
 * ListTest class
 *
 * @author 10184538
 * @date 2019/5/9
 */
public class ListTest {

    public void test() {
        ListMultimap<String, Object> mapNormal = ArrayListMultimap.create();
        Multimap<String, Object> map = Multimaps.synchronizedMultimap(mapNormal);

        map.put("1", "abc1");
        map.put("1", "abc1");
        map.put("1", "abc2");
        map.put("1", "abc3");
        map.put("1", "abc4");
        map.put("2", "abc5");
        map.put("2", "abc6");

        Set<Map.Entry<String, Collection<Object>>> entries = map.asMap().entrySet();
        for (Map.Entry<String, Collection<Object>> entry : entries) {
            List<Object> objects = printList((List<Object>) entry.getValue());
            for (Object obj : objects) {
                System.out.println(obj);
            }
        }

    }

    public void test2() {
        ListMultimap<String, Object> mapNormal = ArrayListMultimap.create();
        Multimap<String, Object> map = Multimaps.synchronizedMultimap(mapNormal);

        map.put("1", "abc1");
        map.put("1", "abc1");
        map.put("1", "abc2");
        map.put("1", "abc3");
        map.put("1", "abc4");
        map.put("2", "abc5");
        map.put("2", "abc6");

        map.asMap().entrySet().stream().map(tClass -> CompletableFuture.runAsync(() -> {
            List<Object> lists = printList((List<Object>) tClass.getValue());
            if (lists != null && lists.size() > 0) {
                lists.parallelStream().forEach(list -> {
                    System.out.println(list);
                });
            }

        })).collect(Collectors.toList()).forEach(CompletableFuture::join);

    }


    private List<Object> printList(List<Object> objects) {
        System.out.println("......");
        return objects;
    }

    public static void main(String[] args) {
        ListTest listTest = new ListTest();
        listTest.test2();
    }

}
