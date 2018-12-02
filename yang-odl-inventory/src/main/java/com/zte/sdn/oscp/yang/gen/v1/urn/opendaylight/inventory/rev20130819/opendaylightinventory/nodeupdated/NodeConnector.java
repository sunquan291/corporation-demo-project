package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.nodeupdated;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeConnectorId;
import com.zte.sdn.oscp.persistence.annotations.Table;

/**
 * A list of node connectors that belong this node.
 * CURRENT
 */
@Table
public interface NodeConnector {

    /**
     * The unique identifier for the node-connector.
     * CURRENT
     * @return
     */
    NodeConnectorId getId();

    /**
     * @return
     */
    String getParentPath();


    /**
     * The unique identifier for the node-connector.
     * CURRENT
     * @param id
     */
    void setId(NodeConnectorId id);

    /**
     * @param parentPath
     */
    void setParentPath(String parentPath);


}

