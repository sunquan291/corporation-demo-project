package com.zte.sunquan.demo.main;

import java.util.Collections;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.zte.sunquan.demo.domain.HandlerExt;
import com.zte.sunquan.spi.Handler;
import com.zte.sunquan.spi.demo.Cow;

/**
 * App class
 *
 * @author 10184538
 * @date 2019/7/6
 */
public class App2 {
    //这样方式可以取代目前的handler机制吗，省去注册的步骤(如下是可以的)
    //优先级控制
    public static void main(String[] args) {
        ServiceLoader<Handler> shouts = ServiceLoader.load(Handler.class);
        List<Handler> handlers = Lists.newArrayList(shouts.iterator());
        List<HandlerExt<Handler>> handlerList = Lists.newLinkedList();

        handlers.forEach(handler -> {
            handlerList.add(new HandlerExt<>(handler,handler.getPriority()));
        });
        Collections.sort(handlerList);


        ImmutableList<Handler> handlers1 = ImmutableList.copyOf(handlerList.stream()
                .map(HandlerExt::getHandler).collect(Collectors.toList()));

        String input = "sunquan";
        shouts.forEach(handler -> handler.process(input));
        //如果入参是对象，这种方式数据变更可以传递
        Cow cow = new Cow();
        cow.setName("sunquan");
        handlers1.forEach(handler -> handler.process(cow));
    }
}
