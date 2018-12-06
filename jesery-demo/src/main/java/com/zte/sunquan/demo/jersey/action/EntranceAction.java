package com.zte.sunquan.demo.jersey.action;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by 10184538 on 2018/7/16.
 */
@Path("service")
public class EntranceAction {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Welcome to Jersey world";
    }

    @GET
    @Path("/exception")
    public void testException() throws NullPointerException {
        throw new NullPointerException("sunquan null");
    }
}
