package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.nodetype.NodeTypeEnum;
import com.zte.sdn.oscp.persistence.annotations.Table;

    /**
     * "The type of node."
    */
@Table
public interface NodeType {

    String getParentPath();


    void setParentPath(String parentPath);


}

