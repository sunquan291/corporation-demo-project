package com.zte.sunquan.deom.black;

import com.google.common.collect.EvictingQueue;

import java.util.*;

public class BlackProcess {

    private final double BLACK_RATE = 0.6;
    private Queue<Message> queue = EvictingQueue.create(5);
    private List<String> black = new ArrayList<>();
    private Set<Message> lastMessages = new HashSet<>();


    private List<String> calculateBlack(Message msg) {
        if ("UP".equals(msg.getType())) {
            if (black.contains(msg.getId())) {
                lastMessages.add(msg);
            }
            return black;
        }
        queue.add(msg);
        List<String> black = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();
        queue.forEach(p -> {
            if (countMap.containsKey(p.getId())) {
                countMap.put(p.getId(), countMap.get(p.getId()) + 1);
            } else {
                countMap.put(p.getId(), 1);
            }
        });
        countMap.forEach((k, v) -> {
            if (v >= queue.size() * BLACK_RATE) {
                System.out.println("add black item:" + k);
                black.add(k);
            }
        });
        return black;
    }

    public boolean doBlack(Message msg) {
        long current = System.currentTimeMillis();
        boolean isBlack = false;
        List<String> blackIds = calculateBlack(msg);
        if (blackIds.contains(msg.getId())) {
            isBlack = true;
        }
        black.removeAll(blackIds);
        black.forEach(p -> {
            System.out.println("remove black item:" + p);
            lastMessages.stream().filter(x -> x.getId().equals(p))
                    .forEach(m -> {
                        System.out.println("do last up:" + p);
                    });
        });
        black = blackIds;
        System.out.println("cost time:" + (System.currentTimeMillis() - current));
        return isBlack;
    }

    public static void main(String[] args) {
        BlackProcess process = new BlackProcess();
        Message message1 = new Message();
        message1.setId("1");
        Message message2 = new Message();
        message2.setId("1");
        Message message3 = new Message();
        message3.setId("1");
        Message message4 = new Message();
        message4.setId("4");
        Message message5 = new Message();
        message5.setId("5");
        process.doBlack(message1);
        process.doBlack(message2);
        process.doBlack(message3);
        process.doBlack(message4);
        process.doBlack(message5);
        process.black.forEach(System.out::println);
        process.queue.forEach(System.out::println);
        Message message6 = new Message();
        message6.setId("6");
        process.doBlack(message6);
        System.out.println("---------1");
        process.black.forEach(System.out::println);
        process.doBlack(message1);
        process.doBlack(message1);
        process.doBlack(message1);
        Message message7 = new Message();
        message7.setId("1");
        message7.setType("UP");
        process.doBlack(message7);
        System.out.println("---------2");
        process.black.forEach(System.out::println);
        process.doBlack(message6);
        process.doBlack(message5);
        process.doBlack(message4);
        System.out.println("---------3");
        process.black.forEach(System.out::println);
    }

}
