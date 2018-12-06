package com.zte.sunquan.demo.jersey.action;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;


/**
 * Created by 10184538 on 2018/7/16.
 */
@PreMatching
public class EncrytRequestFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        System.out.println(".aaaaaaaaa");
    }
}

