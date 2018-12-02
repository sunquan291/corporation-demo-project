package com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20170324;

import com.zte.sdn.oscp.yang.gen.v1.ip.net.sub.subnet.My;
import com.zte.sdn.oscp.persistence.annotations.Table;

    //interface-declare.txt
@Table
public interface Network {

    //getter.txt
    My getManufacturer();

    //getter.txt
    String getHwVersion();

    //getter.txt
    String getSwVersion();

    //getter.txt
    String getSerialNumber();

    //getter.txt
    String getIp();

    //getter.txt
    String getHardwareType();

    //getter.txt
    String getParentPath();


    //setter.txt
    void setManufacturer(My manufacturer);

    //setter.txt
    void setHwVersion(String hwVersion);

    //setter.txt
    void setSwVersion(String swVersion);

    //setter.txt
    void setSerialNumber(String serialNumber);

    //setter.txt
    void setIp(String ip);

    //setter.txt
    void setHardwareType(String hardwareType);

    //setter.txt
    void setParentPath(String parentPath);


}

