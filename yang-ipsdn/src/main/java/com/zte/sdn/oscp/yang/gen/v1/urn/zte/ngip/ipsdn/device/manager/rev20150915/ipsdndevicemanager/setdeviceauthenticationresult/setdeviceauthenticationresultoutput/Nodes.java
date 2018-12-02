package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.setdeviceauthenticationresult.setdeviceauthenticationresultoutput;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeId;
import com.zte.sdn.oscp.persistence.annotations.Table;

@Table
public interface Nodes {

    NodeId getNodeId();

    String getSerialId();

    Long getErrorCode();

    String getParentPath();


    /**
     *
     * @param nodeId 
    */
    void setNodeId(NodeId nodeId);

    /**
     *
     * @param serialId 
    */
    void setSerialId(String serialId);

    /**
     *
     * @param errorCode 
    */
    void setErrorCode(Long errorCode);

    void setParentPath(String parentPath);


}

