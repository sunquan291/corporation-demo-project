package com.zte.sunquan.demo.mbean.utils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by 10184538 on 2018/5/30.
 */
public class NetUtils {
    public static String getLocalAddress() {
        Vector<InetAddress> addresses = new Vector<>();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface networkInterface = networkInterfaces.nextElement();
                    if (networkInterface.isLoopback() || networkInterface.isVirtual() || !networkInterface.isUp())
                        continue;
                    networkInterface.getInterfaceAddresses().stream()
                            .map(InterfaceAddress::getAddress)
                            .forEach(addresses::add);
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        String ip = addresses.stream()
                .filter(address -> address instanceof Inet4Address)
                .map(InetAddress::getHostAddress)
                .findFirst()
                .orElse(null);
        return ip;
    }
}
