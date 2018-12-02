package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getcontrollers.getcontrollersoutput.controller.controllerdevices.devicegroup;

import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddress;
import com.zte.sdn.oscp.persistence.annotations.Table;
import java.util.Set;

@Table
public interface RestconfConnection {

    /**
     * "The ip of the connection."
     * @return 
    */
    IpAddress getRestconfIp();

    /**
     * "The port of the connection."
     * @return 
    */
    Integer getRestconfPort();

    /**
     * "The user-name of the connection."
     * @return 
    */
    String getUserName();

    /**
     * "The password of the connection."
     * @return 
    */
    String getPassword();

    /**
     * "The messages of the notifications."
     * @return 
    */
    Set<String> getNotification();

    String getParentPath();


    /**
     * "The ip of the connection."
     * @param restconfIp 
    */
    void setRestconfIp(IpAddress restconfIp);

    /**
     * "The port of the connection."
     * @param restconfPort 
    */
    void setRestconfPort(Integer restconfPort);

    /**
     * "The user-name of the connection."
     * @param userName 
    */
    void setUserName(String userName);

    /**
     * "The password of the connection."
     * @param password 
    */
    void setPassword(String password);

    /**
     * "The messages of the notifications."
    */
    void  setNotification(Set<String> notification);

    void setParentPath(String parentPath);


    void addToNotification(String addTo);


    void removeFromNotification(String key);


}

