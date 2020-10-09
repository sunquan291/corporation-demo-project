package com.zte.sdn.oscp.mdb.client;

/**
 * @Author: Livio
 * @Date: 2020/10/9 23:09
 */
public class MySqlClient {
    private String host;
    private int port;

    public MySqlClient(String host, int port) {
        System.out.println("host:" + host + ",port:" + port);
        this.host = host;
        this.port = port;
    }

    public String getUrl() {
        return "SQ://" + this.host + ":" + port;
    }
}
