package com.zte.sunquan.demo.pstream;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by 10184538 on 2017/3/7.
 */
public class StreamTest {
//    public static String query(String question) {
//        List<String> engines = new ArrayList<String>() {{
//            add("http://www.google.com/?q=");
//            add("http://duckduckgo.com/?q=");
//            add("http://www.bing.com/search?q=");
//        }};
//        // get element as soon as it is available
//        Optional<String> result = engines.stream().parallel().map((base) -> {
//            String url = base + question;
//            // open connection and fetch the result
//            return WS.url(url).get();
//        }).findAny();
//        return result.get();
//    }

    public static void main(String[] args) {
        long a = IntStream.range(0, 100).mapToLong(x -> {
            for (int i = 0; i < 100_000_000; i++) {
                System.out.println("X:" + i);
            }
            return x;
        }).sum();
    }

    @Test
    public void testConnectionStream() {
        List<String> list = new LinkedList<>();
        list.add("hello");
        list.add("hello java!");
        list.add("hello word!");
        list.add("are you stupid?");
        list.add("nothing is not possible");
        list.add("today is a good day");
        for (int i = 0; i < 10000; i++)
            list.add("hello,sunquan " + i);

        long begin = System.currentTimeMillis();
        list.stream().forEach(System.out::println);
        System.out.println(System.currentTimeMillis() - begin);

        System.out.println("88888888888888");

        begin = System.currentTimeMillis();
        list.stream().filter(str -> str.contains("hello")).toArray();//流对象过滤制定内容(在内部进行了一次迭代筛选?)
        System.out.println(System.currentTimeMillis() - begin);
        System.out.println("88888888888888");
        begin = System.currentTimeMillis();
        for (String string : list) {//旧方法
            System.out.println(string);
        }
        System.out.println(System.currentTimeMillis() - begin);
        System.out.println("88888888888888");
        List<String> list2 = Lists.newArrayList();
        begin = System.currentTimeMillis();
        for (String string : list) {//旧方法
            if (string.contains("hello"))
                list2.add(string);
        }
        System.out.println(System.currentTimeMillis() - begin);

    }
}
