package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.snmpversiontype.SnmpVersionTypeEnum;
import com.zte.sdn.oscp.persistence.annotations.Table;

    /**
     * "The version of SNMP."
    */
@Table
public interface SnmpVersionType {

    String getParentPath();


    void setParentPath(String parentPath);


}

