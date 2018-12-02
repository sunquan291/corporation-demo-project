package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.authenticationdevicesnotification;

import com.zte.sdn.oscp.persistence.annotations.Table;

@Table
public interface Devices {

    String getSerialId();

    String getNeType();

    String getIpAddress();

    String getMac();

    String getParentPath();


    /**
     *
     * @param serialId 
    */
    void setSerialId(String serialId);

    /**
     *
     * @param neType 
    */
    void setNeType(String neType);

    /**
     *
     * @param ipAddress 
    */
    void setIpAddress(String ipAddress);

    /**
     *
     * @param mac 
    */
    void setMac(String mac);

    void setParentPath(String parentPath);


}

