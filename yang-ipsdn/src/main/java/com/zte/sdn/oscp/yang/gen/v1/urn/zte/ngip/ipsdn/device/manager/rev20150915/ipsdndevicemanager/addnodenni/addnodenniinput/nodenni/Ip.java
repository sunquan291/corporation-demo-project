package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.addnodenni.addnodenniinput.nodenni;

import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddress;
import com.zte.sdn.oscp.persistence.annotations.Table;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.addnodenni.addnodenniinput.NodeNni;

    //interface-declare.txt
@Table
public interface Ip extends NodeNni {

    /**
     * "The nni-ip of the node."
     * @return 
    */
    IpAddress getNniIp();

    String getParentPath();


    /**
     * "The nni-ip of the node."
     * @param nniIp 
    */
    void setNniIp(IpAddress nniIp);

    void setParentPath(String parentPath);


}

