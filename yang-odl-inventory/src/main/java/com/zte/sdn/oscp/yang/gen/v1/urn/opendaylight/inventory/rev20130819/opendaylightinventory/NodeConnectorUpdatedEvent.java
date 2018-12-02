package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeConnectorRefImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeConnectorIdImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeConnectorId;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeConnectorRef;

public class NodeConnectorUpdatedEvent {

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = NodeConnectorRefImpl.class)
    private NodeConnectorRef nodeConnectorRef = new NodeConnectorRefImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = NodeConnectorIdImpl.class)
    private NodeConnectorId id = new NodeConnectorIdImpl();

    public static final String DESTINATION="com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819-nodeConnectorUpdated";


    public NodeConnectorRef getNodeConnectorRef() {
        return this.nodeConnectorRef;
        }


    public NodeConnectorId getId() {
        return this.id;
        }



    public void setNodeConnectorRef(NodeConnectorRef nodeConnectorRef) {
        this.nodeConnectorRef = nodeConnectorRef;
    }

    public void setId(NodeConnectorId id) {
        this.id = id;
    }



}

