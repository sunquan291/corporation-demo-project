package com.zte.sunquan.demo.jersey.main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

import com.zte.sunquan.demo.jersey.config.DemoResourceConfig;

//import com.sun.jersey.spi.container.servlet.ServletContainer;

/**
 * Created by 10184538 on 2018/7/16.
 */
public class Main2 {


    public static void main(String[] args) throws Exception {
        Server server = new Server();
        ServerConnector serverConnector1 = new ServerConnector(server);
        serverConnector1.setPort(8085);
        ServerConnector serverConnector2 = new ServerConnector(server);
        serverConnector2.setPort(8086);


        DemoResourceConfig config = new DemoResourceConfig();
        ServletContainer servletContainer = new ServletContainer(config);
        ServletHolder servlet = new ServletHolder(servletContainer);

        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/jsery2");
        handler.addServlet(servlet, "/*");

        server.setHandler(handler);
        server.addConnector(serverConnector1);
        server.addConnector(serverConnector2);
        server.start();
       // server.join();
    }
}
