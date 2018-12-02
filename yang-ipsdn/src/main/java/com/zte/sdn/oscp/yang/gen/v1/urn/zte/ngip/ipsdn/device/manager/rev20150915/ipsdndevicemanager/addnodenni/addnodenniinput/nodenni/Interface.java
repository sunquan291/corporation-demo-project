package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.addnodenni.addnodenniinput.nodenni;

import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddress;
import com.zte.sdn.oscp.persistence.annotations.Table;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.addnodenni.addnodenniinput.NodeNni;

    //interface-declare.txt
@Table
public interface Interface extends NodeNni {

    /**
     * "The nni-port name of the node."
     * @return 
    */
    String getIfName();

    /**
     * "The ip of the interface get from inv."
     * @return 
    */
    IpAddress getIfIp();

    String getParentPath();


    /**
     * "The nni-port name of the node."
     * @param ifName 
    */
    void setIfName(String ifName);

    /**
     * "The ip of the interface get from inv."
     * @param ifIp 
    */
    void setIfIp(IpAddress ifIp);

    void setParentPath(String parentPath);


}

