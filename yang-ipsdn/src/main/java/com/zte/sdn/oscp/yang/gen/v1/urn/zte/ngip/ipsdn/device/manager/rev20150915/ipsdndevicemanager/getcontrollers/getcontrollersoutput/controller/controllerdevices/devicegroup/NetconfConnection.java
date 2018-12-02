package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getcontrollers.getcontrollersoutput.controller.controllerdevices.devicegroup;

import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddress;
import com.zte.sdn.oscp.persistence.annotations.Table;

@Table
public interface NetconfConnection {

    /**
     * "The ip of a connection between controller and device."
     * @return 
    */
    IpAddress getNetconfIp();

    /**
     * "The port of a connection between controller and device."
     * @return 
    */
    Integer getNetconfPort();

    /**
     * "The name of a connection between controller and device."
     * @return 
    */
    String getUserName();

    /**
     * "The password of a connection between controller and device."
     * @return 
    */
    String getPassword();

    String getParentPath();


    /**
     * "The ip of a connection between controller and device."
     * @param netconfIp 
    */
    void setNetconfIp(IpAddress netconfIp);

    /**
     * "The port of a connection between controller and device."
     * @param netconfPort 
    */
    void setNetconfPort(Integer netconfPort);

    /**
     * "The name of a connection between controller and device."
     * @param userName 
    */
    void setUserName(String userName);

    /**
     * "The password of a connection between controller and device."
     * @param password 
    */
    void setPassword(String password);

    void setParentPath(String parentPath);


}

