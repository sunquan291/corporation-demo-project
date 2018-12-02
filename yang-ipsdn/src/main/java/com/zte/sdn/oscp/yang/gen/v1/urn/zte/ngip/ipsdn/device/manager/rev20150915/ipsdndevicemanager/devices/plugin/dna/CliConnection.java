package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.plugin.dna;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.plugin.dna.cliconnection.ConnectTypeEnum;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddress;
import com.zte.sdn.oscp.persistence.annotations.Table;

@Table
public interface CliConnection {

    /**
     * "The name of the connection."
     * @return 
    */
    String getName();

    /**
     * "The ip of the connection."
     * @return 
    */
    IpAddress getIpAddress();

    /**
     * "The port of the connection."
     * @return 
    */
    Integer getPort();

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
     * "The connect-type of the connection."
     * @return 
    */
    ConnectTypeEnum getConnectType();

    String getParentPath();


    /**
     * "The name of the connection."
     * @param name 
    */
    void setName(String name);

    /**
     * "The ip of the connection."
     * @param ipAddress 
    */
    void setIpAddress(IpAddress ipAddress);

    /**
     * "The port of the connection."
     * @param port 
    */
    void setPort(Integer port);

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
     * "The connect-type of the connection."
     * @param connectType 
    */
    void setConnectType(ConnectTypeEnum connectType);

    void setParentPath(String parentPath);


}

