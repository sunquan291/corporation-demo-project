package com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20160524;

import com.zte.sdn.oscp.persistence.annotation.Table;
import com.zte.sdn.oscp.core.transaction.domain.Unit;
import java.util.Set;
import com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20160524.device.ConnectPointUnit;

    //interface-declare.txt
@Table
public interface DeviceUnit {

    //getter.txt
    Unit<String> getManufacturer();

    //getter.txt
    Unit<String> getHwVersion();

    //getter.txt
    Unit<String> getSwVersion();

    //getter.txt
    Unit<String> getSerialNumber();

    //getter.txt
    Unit<String> getIp();

    //getter.txt
    Set<Unit<String>> getFlows();

    //getter.txt
    Set<ConnectPointUnit> getConnectPoint();

    //get-from.txt
    ConnectPointUnit getFromConnectPointUnit(String key);
    //getter.txt
    String getParentPath();


    //setter.txt
    void setManufacturer(Unit<String> manufacturer);

    //setter.txt
    void setHwVersion(Unit<String> hwVersion);

    //setter.txt
    void setSwVersion(Unit<String> swVersion);

    //setter.txt
    void setSerialNumber(Unit<String> serialNumber);

    //setter.txt
    void setIp(Unit<String> ip);

    //setter.txt
    void  setFlows(Set<Unit<String>> flows);

    //setter.txt
    void  setConnectPoint(Set<ConnectPointUnit> connectPoint);

    //setter.txt
    void setParentPath(String parentPath);


    //addTo.txt
    void addToFlows(Unit<String> addTo);

    //addTo.txt
    void addToConnectPointUnit(ConnectPointUnit addTo);


    //removeFrom.txt
    void removeFromFlows(String key);

    //removeFrom.txt
    void removeFromConnectPointUnit(String key);


}

