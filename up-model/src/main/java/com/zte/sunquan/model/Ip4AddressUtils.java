package com.zte.sunquan.model;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Created by xxxx on 2018/3/19.
 */
public class Ip4AddressUtils {


    private enum OSType {
        Linux, Windows;

        public static OSType getOSType() {
            OSType osType = null;
            final String osName = System.getProperty("os.name");
            if (osName.contains(Linux.name()))
                osType = Linux;
            else if (osName.contains(Windows.name()))
                osType = Windows;
            return osType;
        }
    }

    public static String getLocalIp4Address() {
        if (OSType.getOSType() == OSType.Windows) {
            return getLocalIp();
        } else
            return getLinuxLocalIp();

    }

    private static String getLocalIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getLinuxLocalIp() {
        StringBuffer sb = new StringBuffer();
        Enumeration allNetInterfaces = null;
        try {
            allNetInterfaces = NetworkInterface.getNetworkInterfaces();

            InetAddress ip = null;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                sb.append(netInterface.getName() + ":");
                Enumeration addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    ip = (InetAddress) addresses.nextElement();
                    if (ip != null && ip instanceof Inet4Address) {
                        sb.append(ip.getHostAddress() + "\n");
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) throws SocketException {
        System.out.println(Ip4AddressUtils.getLocalIp4Address());
    }
}
