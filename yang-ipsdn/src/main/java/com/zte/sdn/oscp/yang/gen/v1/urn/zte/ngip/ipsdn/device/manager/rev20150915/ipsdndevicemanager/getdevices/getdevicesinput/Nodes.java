package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getdevices.getdevicesinput;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeId;
import com.zte.sdn.oscp.persistence.annotations.Table;

@Table
public interface Nodes {

    /**
     * "The nodeid of the device."
     * @return 
    */
    NodeId getNodeId();

    String getParentPath();


    /**
     * "The nodeid of the device."
     * @param nodeId 
    */
    void setNodeId(NodeId nodeId);

    void setParentPath(String parentPath);


}

