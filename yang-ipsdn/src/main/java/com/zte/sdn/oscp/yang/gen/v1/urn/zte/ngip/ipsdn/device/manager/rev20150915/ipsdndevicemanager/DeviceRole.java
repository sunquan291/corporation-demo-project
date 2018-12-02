package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devicerole.DeviceRoleEnum;
import com.zte.sdn.oscp.persistence.annotations.Table;

@Table
public interface DeviceRole {

    String getParentPath();


    void setParentPath(String parentPath);


}

