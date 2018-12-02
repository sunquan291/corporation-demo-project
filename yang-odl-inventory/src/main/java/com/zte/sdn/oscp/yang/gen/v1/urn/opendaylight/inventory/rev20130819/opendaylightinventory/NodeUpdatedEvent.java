package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeRefImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.nodeupdated.NodeConnectorImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeId;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.nodeupdated.NodeConnector;
import java.util.Set;
import java.util.LinkedHashSet;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeRef;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeIdImpl;

public class NodeUpdatedEvent {

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = NodeRefImpl.class)
    private NodeRef nodeRef = new NodeRefImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = NodeIdImpl.class)
    private NodeId id = new NodeIdImpl();

    public static final String DESTINATION="com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819-nodeUpdated";

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =NodeConnectorImpl.class, associateLoad = false, associateSave = false)
    private Set<NodeConnector> nodeConnector = new LinkedHashSet<NodeConnector>();


    public NodeRef getNodeRef() {
        return this.nodeRef;
        }


    public NodeId getId() {
        return this.id;
        }


    public Set<NodeConnector> getNodeConnector() {
        return this.nodeConnector;
    }

    public NodeConnector getFromNodeConnector(String key) {
        return this.nodeConnector.stream().filter(value ->
                value.getId().equals(key))
                .findFirst().get();
    }

    public void setNodeRef(NodeRef nodeRef) {
        this.nodeRef = nodeRef;
    }

    public void setId(NodeId id) {
        this.id = id;
    }

    public void setNodeConnector(Set<NodeConnector> nodeConnector) {
        this.nodeConnector = nodeConnector;
    }


    public void addToNodeConnector(NodeConnector addTo) {
        nodeConnector.add(addTo);
    }


    public void removeFromNodeConnector(String key) {
        Iterator<NodeConnector> iterator = this.nodeConnector.iterator();
        while (iterator.hasNext()) {
            NodeConnector next = iterator.next();
            if (next.getId().equals(key))
                iterator.remove();
        }
    }


}

