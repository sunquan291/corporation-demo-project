package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.nodes;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.nodes.node.NodeConnectorImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeId;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.nodes.node.NodeConnector;
import java.util.Set;
import java.util.LinkedHashSet;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeIdImpl;

public class NodeImpl implements Node {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = NodeIdImpl.class)
    private NodeId id = new NodeIdImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =NodeConnectorImpl.class, associateLoad = false, associateSave = false)
    private Set<NodeConnector> nodeConnector = new LinkedHashSet<NodeConnector>();

    public static final String ParentPath = "ParentPath";
    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public NodeId getId() {
        return this.id;
        }


    @Override
    public Set<NodeConnector> getNodeConnector() {
        return this.nodeConnector;
    }

    @Override
    public NodeConnector getFromNodeConnector(String key) {
        return this.nodeConnector.stream().filter(value ->
                value.getId().equals(key))
                .findFirst().get();
    }
    @Override
    public String getParentPath() {
        return this.parentPath;
        }



    @Override
    public void setId(NodeId id) {
        this.id = id;
    }

    @Override
    public void setNodeConnector(Set<NodeConnector> nodeConnector) {
        this.nodeConnector = nodeConnector;
    }

    @Override
    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }


    public void addToNodeConnector(NodeConnector addTo) {
        nodeConnector.add(addTo);
    }


    @Override
    public void removeFromNodeConnector(String key) {
        Iterator<NodeConnector> iterator = this.nodeConnector.iterator();
        while (iterator.hasNext()) {
            NodeConnector next = iterator.next();
            if (next.getId().equals(key))
                iterator.remove();
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(primaryId,parentPath);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeImpl other = (NodeImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

