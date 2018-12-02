package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getconnect.getconnectoutput;

import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddress;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.NodeType;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeId;
import com.zte.sdn.oscp.persistence.annotations.Table;

@Table
public interface Connects {

    /**
     * "The nodeid of the device."
     * @return 
    */
    NodeId getNodeId();

    /**
     * "Type of the device."
     * @return 
    */
    NodeType getNodeType();

    /**
     * "The ip of a connection between controller and device."
     * @return 
    */
    IpAddress getNetconfIp();

    /**
     * "The ip of the connection."
     * @return 
    */
    IpAddress getRestconfIp();

    String getParentPath();


    /**
     * "The nodeid of the device."
     * @param nodeId 
    */
    void setNodeId(NodeId nodeId);

    /**
     * "Type of the device."
     * @param nodeType 
    */
    void setNodeType(NodeType nodeType);

    /**
     * "The ip of a connection between controller and device."
     * @param netconfIp 
    */
    void setNetconfIp(IpAddress netconfIp);

    /**
     * "The ip of the connection."
     * @param restconfIp 
    */
    void setRestconfIp(IpAddress restconfIp);

    void setParentPath(String parentPath);


}

