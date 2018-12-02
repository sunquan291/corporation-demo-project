package com.zte.sunquan.demo.jms.mbean;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 10184538 on 2018/5/29.
 * 这层的主要作用是用于实现在JConsole中显示对象的信息
 */
public abstract class AbstractPersonMBean implements PersonMBean {
    @Override
    public List<String> getHobbyContent() {
        return getHobby().stream().map(p -> p.getName()).collect(Collectors.toList());
    }

    public abstract List<Hobby> getHobby();
}
