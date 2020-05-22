package com.zte.sunquan.mvcframework.v3.servlet;

import com.zte.sunquan.mvcframework.v3.context.SQApplicationContext;
import com.zte.sunquan.mvcframework.v3.context.SQApplicationContextImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Livio
 * @Date: 2020/5/6 22:50
 */
public class SQDispatcher extends HttpServlet {
    private SQApplicationContext applicationContext;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String contextConfigLocation = config.getInitParameter("contextConfigLocation");
        applicationContext = new SQApplicationContextImpl(contextConfigLocation);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
