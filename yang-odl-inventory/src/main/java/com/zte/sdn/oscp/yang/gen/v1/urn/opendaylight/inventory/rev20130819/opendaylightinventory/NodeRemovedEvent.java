package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeRefImpl;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeRef;

public class NodeRemovedEvent {

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = NodeRefImpl.class)
    private NodeRef nodeRef = new NodeRefImpl();

    public static final String DESTINATION="com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819-nodeRemoved";


    public NodeRef getNodeRef() {
        return this.nodeRef;
        }



    public void setNodeRef(NodeRef nodeRef) {
        this.nodeRef = nodeRef;
    }



}

