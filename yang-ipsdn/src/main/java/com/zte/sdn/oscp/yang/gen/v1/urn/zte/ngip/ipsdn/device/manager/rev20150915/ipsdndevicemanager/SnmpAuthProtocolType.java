package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager;

import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.snmpauthprotocoltype.SnmpAuthProtocolTypeEnum;

    /**
     * "The type of SNMP's auth connection between controller and device."
    */
@Table
public interface SnmpAuthProtocolType {

    String getParentPath();


    void setParentPath(String parentPath);


}

