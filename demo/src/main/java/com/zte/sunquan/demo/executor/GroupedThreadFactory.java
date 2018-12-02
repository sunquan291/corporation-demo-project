package com.zte.sunquan.demo.executor;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.ThreadFactory;

/**
 * Created by sunquan on 2017/4/15.
 */
public class GroupedThreadFactory implements ThreadFactory {
    private final ThreadGroup group;
    private static final Map<String, GroupedThreadFactory> FACTORIES = Maps.newConcurrentMap();

    public GroupedThreadFactory(ThreadGroup group) {
        this.group = group;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(group, r);
    }

    public static GroupedThreadFactory groupedThreadFactory(String groupName) {
        //oscp/a/b/c
        GroupedThreadFactory groupedThreadFactory = FACTORIES.get(groupName);
        if (groupedThreadFactory != null) {
            return groupedThreadFactory;
        }

        int i = groupName.lastIndexOf("/");
        if (i > 0) {
            String parentGroupName = groupName.substring(0, i);
            ThreadGroup parentGroup = groupedThreadFactory(parentGroupName).getGroup();
            groupedThreadFactory = new GroupedThreadFactory(new ThreadGroup(parentGroup, groupName));
        } else {
            groupedThreadFactory = new GroupedThreadFactory(new ThreadGroup(groupName));
        }
        FACTORIES.putIfAbsent(groupName,groupedThreadFactory);
        return groupedThreadFactory;
    }

    public ThreadGroup getGroup() {
        return group;
    }
}
