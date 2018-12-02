package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getauthenticationdevices.getauthenticationdevicesinput;

import com.zte.sdn.oscp.persistence.annotations.Table;

@Table
public interface SerialIds {

    String getSerialId();

    String getParentPath();


    /**
     *
     * @param serialId 
    */
    void setSerialId(String serialId);

    void setParentPath(String parentPath);


}

