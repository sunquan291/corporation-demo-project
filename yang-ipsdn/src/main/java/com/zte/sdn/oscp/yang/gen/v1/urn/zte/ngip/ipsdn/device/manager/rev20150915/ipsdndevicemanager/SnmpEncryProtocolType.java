package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager;

import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.snmpencryprotocoltype.SnmpEncryProtocolTypeEnum;

    /**
     * "The type of SNMP's encry connection between controller and device."
    */
@Table
public interface SnmpEncryProtocolType {

    String getParentPath();


    void setParentPath(String parentPath);


}

