package com.zte.sunquan.demo.jersey.action;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

//import com.sun.jersey.api.NotFoundException;

/**
 * Created by 10184538 on 2018/7/16.
 */
@Provider
public class DemoExceptionMapper implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception e) {

        Response.ResponseBuilder responseBuilder = null;
        if (e instanceof NotFoundException) {
            String msg = e.getMessage();
            System.out.println(msg);//特殊处理...
            responseBuilder = Response.ok(msg, MediaType.APPLICATION_JSON);
            System.out.println("执行自定义异常NotFoundException");
        } else if (e instanceof NullPointerException) {
            String msg = e.getMessage();
            System.out.println(msg);//特殊处理...
            responseBuilder = Response.ok(msg, MediaType.APPLICATION_JSON);
            System.out.println("执行自定义异常NullPointerException");
        }

        return responseBuilder.build();
    }
}
