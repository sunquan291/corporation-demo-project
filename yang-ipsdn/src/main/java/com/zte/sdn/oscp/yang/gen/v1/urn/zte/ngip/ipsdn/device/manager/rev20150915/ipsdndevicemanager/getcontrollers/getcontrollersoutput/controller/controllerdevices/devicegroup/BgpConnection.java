package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getcontrollers.getcontrollersoutput.controller.controllerdevices.devicegroup;

import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddress;
import com.zte.sdn.oscp.persistence.annotations.Table;

@Table
public interface BgpConnection {

    /**
     * "The local-as of the connection."
     * @return 
    */
    String getLocalAs();

    /**
     * "The local-ip of the connection."
     * @return 
    */
    IpAddress getLocalIp();

    /**
     * "The remote-ip of the connection."
     * @return 
    */
    IpAddress getRemoteIp();

    /**
     * "The remote-as of the connection."
     * @return 
    */
    String getRemoteAs();

    /**
     * "support bgp ls capacity."
     * @return 
    */
    Boolean getBgpLsEnable();

    /**
     * "support bgp fs capacity."
     * @return 
    */
    Boolean getBgpFsEnable();

    String getParentPath();


    /**
     * "The local-as of the connection."
     * @param localAs 
    */
    void setLocalAs(String localAs);

    /**
     * "The local-ip of the connection."
     * @param localIp 
    */
    void setLocalIp(IpAddress localIp);

    /**
     * "The remote-ip of the connection."
     * @param remoteIp 
    */
    void setRemoteIp(IpAddress remoteIp);

    /**
     * "The remote-as of the connection."
     * @param remoteAs 
    */
    void setRemoteAs(String remoteAs);

    /**
     * "support bgp ls capacity."
     * @param bgpLsEnable 
    */
    void setBgpLsEnable(Boolean bgpLsEnable);

    /**
     * "support bgp fs capacity."
     * @param bgpFsEnable 
    */
    void setBgpFsEnable(Boolean bgpFsEnable);

    void setParentPath(String parentPath);


}

