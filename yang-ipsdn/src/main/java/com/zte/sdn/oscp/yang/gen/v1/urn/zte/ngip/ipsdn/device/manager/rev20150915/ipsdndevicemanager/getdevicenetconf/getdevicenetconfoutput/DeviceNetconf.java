package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getdevicenetconf.getdevicenetconfoutput;

import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddress;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeId;
import com.zte.sdn.oscp.persistence.annotations.Table;

    /**
     * "H controller get all device netconf info."
    */
@Table
public interface DeviceNetconf {

    /**
     * "The nodeid of the device."
     * @return 
    */
    NodeId getNodeId();

    /**
     * "The description of the device."
     * @return 
    */
    String getDeviceDescription();

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
     * "The nodeid of the device."
     * @param nodeId 
    */
    void setNodeId(NodeId nodeId);

    /**
     * "The description of the device."
     * @param deviceDescription 
    */
    void setDeviceDescription(String deviceDescription);

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

