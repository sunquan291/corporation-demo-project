package com.zte.sdn.oscp.mdb;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: Livio
 * @Date: 2020/10/9 23:12
 */
@ConfigurationProperties(prefix = "sq")
public class MydbProperties {
    private String host = "locahost";
    private int port = 2000;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
