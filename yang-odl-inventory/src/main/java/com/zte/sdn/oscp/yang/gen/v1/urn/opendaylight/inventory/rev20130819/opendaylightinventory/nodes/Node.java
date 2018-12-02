package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.nodes;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeId;
import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.nodes.node.NodeConnector;
import java.util.Set;

/**
 * A list of nodes (as defined by the 'grouping node').
 * CURRENT
 */
@Table
public interface Node {

    /**
     * The unique identifier for the node.
     * CURRENT
     * @return
     */
    NodeId getId();

    /**
     * @return
     */
    Set<NodeConnector> getNodeConnector();

    NodeConnector getFromNodeConnector(String key);
    /**
     * @return
     */
    String getParentPath();


    /**
     * The unique identifier for the node.
     * CURRENT
     * @param id
     */
    void setId(NodeId id);

    /**
     * @param nodeConnector
     */
    void  setNodeConnector(Set<NodeConnector> nodeConnector);

    /**
     * @param parentPath
     */
    void setParentPath(String parentPath);


    void addToNodeConnector(NodeConnector addTo);


    void removeFromNodeConnector(String key);


}

