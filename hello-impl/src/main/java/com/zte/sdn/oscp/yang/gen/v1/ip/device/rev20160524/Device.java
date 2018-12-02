package com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20160524;

import com.zte.sdn.oscp.persistence.annotation.Table;
import com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20160524.device.ConnectPoint;
import java.util.Set;
import com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20160524.device.System;

    //interface-declare.txt
@Table
public interface Device {

    //getter.txt
    String getManufacturer();

    //getter.txt
    String getHwVersion();

    //getter.txt
    String getSwVersion();

    //getter.txt
    String getSerialNumber();

    //getter.txt
    String getIp();

    //getter.txt
    Set<String> getFlows();

    //getter.txt
    Set<ConnectPoint> getConnectPoint();

    //get-from.txt
    ConnectPoint getFromConnectPoint(String key);
    //getter.txt
    System getSystem();

    //getter.txt
    String getParentPath();


    //setter.txt
    void setManufacturer(String manufacturer);

    //setter.txt
    void setHwVersion(String hwVersion);

    //setter.txt
    void setSwVersion(String swVersion);

    //setter.txt
    void setSerialNumber(String serialNumber);

    //setter.txt
    void setIp(String ip);

    //setter.txt
    void  setFlows(Set<String> flows);

    //setter.txt
    void  setConnectPoint(Set<ConnectPoint> connectPoint);

    //setter.txt
    void setSystem(System system);

    //setter.txt
    void setParentPath(String parentPath);


    //addTo.txt
    void addToFlows(String addTo);

    //addTo.txt
    void addToConnectPoint(ConnectPoint addTo);


    //removeFrom.txt
    void removeFromFlows(String key);

    //removeFrom.txt
    void removeFromConnectPoint(String key);


}

