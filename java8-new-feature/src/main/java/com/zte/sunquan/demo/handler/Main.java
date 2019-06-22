package com.zte.sunquan.demo.handler;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * Main class
 *
 * @author 10184538
 * @date 2019/5/27
 */
public class Main {
    public static void main(String[] args) {
        List immutableServiceList = ImmutableList.of();
        List<HandlerExt> handlerList = Lists.newLinkedList();
        AHandler aHandler = new AHandler();
        BHandler bHandler = new BHandler();
        handlerList.add(new HandlerExt<>(aHandler, aHandler.getPriority()));
        handlerList.add(new HandlerExt<>(bHandler, bHandler.getPriority()));
        System.out.println(handlerList.size());
        Collections.sort(handlerList);
        immutableServiceList = ImmutableList.copyOf(handlerList.stream()
                .map(HandlerExt::getHandler).collect(Collectors.toList()));
        System.out.println(immutableServiceList.size());
    }
}
