package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.nodes.Node;
import com.zte.sdn.oscp.persistence.annotations.Table;
import java.util.Set;

/**
 * The root container of all nodes.
 * DEPRECATED
 */
@Table
public interface Nodes {

    /**
     * @return
     */
    Set<Node> getNode();

    Node getFromNode(String key);
    /**
     * @return
     */
    String getParentPath();


    /**
     * @param node
     */
    void  setNode(Set<Node> node);

    /**
     * @param parentPath
     */
    void setParentPath(String parentPath);


    void addToNode(Node addTo);


    void removeFromNode(String key);


}

