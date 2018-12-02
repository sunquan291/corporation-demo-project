package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.adddevices.adddevicesoutput;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeId;
import com.zte.sdn.oscp.persistence.annotations.Table;

@Table
public interface FailNode {

    NodeId getNodeId();

    String getErrorMsg();

    String getParentPath();


    /**
     *
     * @param nodeId 
    */
    void setNodeId(NodeId nodeId);

    /**
     *
     * @param errorMsg 
    */
    void setErrorMsg(String errorMsg);

    void setParentPath(String parentPath);


}

