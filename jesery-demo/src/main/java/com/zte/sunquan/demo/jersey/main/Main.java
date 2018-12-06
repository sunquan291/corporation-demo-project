package com.zte.sunquan.demo.jersey.main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

//import com.sun.jersey.spi.container.servlet.ServletContainer;
import com.zte.sunquan.demo.jersey.config.DemoResourceConfig;

import org.glassfish.jersey.servlet.ServletContainer;//使用这个数据目前配置无法返回数据

/**
 * Created by 10184538 on 2018/7/16.
 */
public class Main {

    public static void startServer1(int port) throws Exception {
        Server server = new Server(port);
        ServletContextHandler context = new ServletContextHandler(
                ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        ServletHolder sh = new ServletHolder(ServletContainer.class);
        sh.setInitParameter(
                "com.sun.jersey.config.property.resourceConfigClass",
                "com.sun.jersey.api.core.PackagesResourceConfig");
        sh.setInitParameter("com.sun.jersey.config.property.packages",
                "com.zte.sunquan.demo.jersey");
        context.addServlet(sh, "/*");
        server.start();
        System.out.println("start jetty in " + port);
    }

    public static void startServer2(int port) throws Exception {
        Server server = new Server(port);
        DemoResourceConfig config = new DemoResourceConfig();
        ServletContainer servletContainer = new ServletContainer(config);
        ServletHolder servlet = new ServletHolder(servletContainer);
//        servlet.setInitParameter("com.sun.jersey.config.property.resourceConfigClass", "com.sun.jersey.api.core.PackagesResourceConfig");
//        servlet.setInitParameter("com.sun.jersey.config.property.packages", "jersey");
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/jsery");
        handler.addServlet(servlet, "/*");
        server.setHandler(handler);
        server.start();
        System.out.println("start jetty in " + port);
    }

    public static void main(String[] args) throws Exception {
        //com.sun.jersey.spi.container.servlet.ServletContainer
        // startServer1(8085);

        startServer2(8086);
    }
}
