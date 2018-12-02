package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portsconfignodes.nodeports.ports.accesstype;

import com.zte.sdn.oscp.persistence.annotations.Table;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portsconfignodes.nodeports.ports.AccessType;

    //interface-declare.txt
@Table
public interface Port extends AccessType {

    String getParentPath();


    void setParentPath(String parentPath);


}

