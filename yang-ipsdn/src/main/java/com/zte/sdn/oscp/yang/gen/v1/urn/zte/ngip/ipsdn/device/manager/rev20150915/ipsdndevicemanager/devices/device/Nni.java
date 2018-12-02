package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.device;

import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddress;
import com.zte.sdn.oscp.persistence.annotations.Table;

    /**
     * "The nni-cfg of the device."
    */
@Table
public interface Nni {

    /**
     * "The nni-ip of the node."
     * @return 
    */
    IpAddress getNniIp();

    /**
     * "The nni-port name of the node."
     * @return 
    */
    String getIfName();

    String getParentPath();


    /**
     * "The nni-ip of the node."
     * @param nniIp 
    */
    void setNniIp(IpAddress nniIp);

    /**
     * "The nni-port name of the node."
     * @param ifName 
    */
    void setIfName(String ifName);

    void setParentPath(String parentPath);


}

