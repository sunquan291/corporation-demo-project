package com.zte.sunquan.dataStore.service;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 10184538 on 2017/11/27.
 */
public class DataApplication extends Application {
    @Override
    public Set<Object> getSingletons() {
        final Set<Object> singletons = new HashSet<>();
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa");
        singletons.add(new DataService());
        return singletons;
    }
}
