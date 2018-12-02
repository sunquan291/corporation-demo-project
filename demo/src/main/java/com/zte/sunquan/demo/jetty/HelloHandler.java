package com.zte.sunquan.demo.jetty;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

/**
 * Created by 10184538 on 2017/11/6.
 */
public class HelloHandler extends AbstractHandler {
    @Override
    public void handle(String s, Request baseRequest, HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("a hello,world");
        // 声明response的编码和文件类型
        response.setContentType("text/html; charset=utf-8");

        // 声明返回状态码
        response.setStatus(HttpServletResponse.SC_OK);

        // 请求的返回值
        response.getWriter().println("<h1>Hello World</h1>");

        // 通知Jettyrequest使用此处理器处理请求
    }
}
