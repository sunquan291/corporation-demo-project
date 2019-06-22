package com.zte.sunquan.demo.thread;

import java.util.Vector;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import com.alibaba.ttl.TtlRunnable;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

/**
 * MapTest class
 *
 * @author 10184538
 * @date 2019/4/24
 */
public class MapTest {

    //private ListMultimap<String, Object> map = ArrayListMultimap.create();
    private ListMultimap<String, Object> mapNormal = ArrayListMultimap.create();
    private Multimap<String, Object> map = Multimaps.synchronizedMultimap(mapNormal);

    public void start() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put("1", "content" + i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put("1", "add" + i);
            }
        });
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put("1", "del" + i);
            }
        });
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                map.put("1", "a" + i);
            }
        });
        Thread t5 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                map.put("1", "b" + i);
            }
        });
        Thread t6 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put("1", "c" + i);
            }
        });
        Thread t7 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put("1", "d" + i);
            }
        });
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
//        t6.start();
//        t7.start();

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 10000; j++) {
                map.put(i + "xy", "6a" + j);
            }

        }
    }

    private void print() {
        System.out.println("------------------");
//        map.asMap().forEach((k, v) -> {
//            System.out.println("k=" + k + ",v=" + v);
//        });
    }

    private void handle() {
        Vector vector = new Vector();
        map.asMap().entrySet().stream().map(k -> CompletableFuture.runAsync(
                TtlRunnable.get(() -> {
                    System.out.println("k=" + k.getKey() + ",vsize=" + k.getValue().size());
                    k.getValue().parallelStream().forEach(x -> {
                        Object a = (Object) k.getKey();
//                        try {
//                            Thread.sleep(1);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                        //vector.add(x);
                    });
                })

                , Executors.newFixedThreadPool(20))).collect(Collectors.toList()).forEach(CompletableFuture::join);
        System.out.println("VEC=" + vector.size());
    }

    public static void main(String[] args) throws InterruptedException {
        MapTest test = new MapTest();
        test.start();

        Thread.sleep(5000);
        test.print();
        test.handle();
    }
}
