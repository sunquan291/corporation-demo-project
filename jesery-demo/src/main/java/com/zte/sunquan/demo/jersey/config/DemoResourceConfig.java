package com.zte.sunquan.demo.jersey.config;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

//import com.sun.jersey.api.container.filter.LoggingFilter;
import com.zte.sunquan.demo.jersey.action.Encryt2ResponseFilter;
import com.zte.sunquan.demo.jersey.action.EncrytRequestFilter;
import com.zte.sunquan.demo.jersey.action.EncrytResponseFilter;


/**
 * Created by 10184538 on 2018/7/16.
 */
public class DemoResourceConfig extends ResourceConfig {
    public DemoResourceConfig() {
        packages("com.zte.sunquan.demo.jersey");//自动扫描
        register(LoggingFilter.class);
        register(EncrytResponseFilter.class);
        register(EncrytRequestFilter.class);
        register(Encryt2ResponseFilter.class);
        System.out.println("Application starting");
    }

}
