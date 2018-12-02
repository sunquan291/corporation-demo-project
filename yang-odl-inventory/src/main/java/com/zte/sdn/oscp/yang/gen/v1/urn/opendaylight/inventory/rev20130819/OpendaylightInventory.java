package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.SupportType;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.Nodes;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeId;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeConnectorId;
import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeConnectorRef;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeRef;

@Table
public interface OpendaylightInventory {

    /**
     * @return
     */
    Nodes getNodes();

    /**
     * @return
     */
    String getParentPath();


    /**
     * @param nodes
     */
    void setNodes(Nodes nodes);

    /**
     * @param parentPath
     */
    void setParentPath(String parentPath);


}

