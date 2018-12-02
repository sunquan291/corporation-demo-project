package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeConnectorRefImpl;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeConnectorRef;

public class NodeConnectorRemovedEvent {

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = NodeConnectorRefImpl.class)
    private NodeConnectorRef nodeConnectorRef = new NodeConnectorRefImpl();

    public static final String DESTINATION="com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819-nodeConnectorRemoved";


    public NodeConnectorRef getNodeConnectorRef() {
        return this.nodeConnectorRef;
        }



    public void setNodeConnectorRef(NodeConnectorRef nodeConnectorRef) {
        this.nodeConnectorRef = nodeConnectorRef;
    }



}

