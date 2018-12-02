package com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20160524.device;

import com.zte.sdn.oscp.persistence.annotation.Table;
import com.zte.sdn.oscp.core.transaction.domain.Unit;

    //interface-declare.txt
@Table
public interface ConnectPointUnit {

    //getter.txt
    Unit<String> getNetworkId();

    //getter.txt
    String getParentPath();


    //setter.txt
    void setNetworkId(Unit<String> networkId);

    //setter.txt
    void setParentPath(String parentPath);


}

