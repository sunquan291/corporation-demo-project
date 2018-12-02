package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result;

import com.zte.sdn.oscp.persistence.annotations.Table;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.Result;

    //interface-declare.txt
@Table
public interface Fail extends Result {

    /**
     * "The failed reason info."
     * @return 
    */
    String getReason();

    String getParentPath();


    /**
     * "The failed reason info."
     * @param reason 
    */
    void setReason(String reason);

    void setParentPath(String parentPath);


}

