package com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20160524.device;

import com.zte.sdn.oscp.persistence.annotation.Table;

    //interface-declare.txt
@Table
public interface ConnectPoint {

    //getter.txt
    String getNetworkId();

    //getter.txt
    String getParentPath();


    //setter.txt
    void setNetworkId(String networkId);

    //setter.txt
    void setParentPath(String parentPath);


}

