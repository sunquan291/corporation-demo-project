package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.nodes.Node;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import java.util.Set;
import java.util.LinkedHashSet;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.nodes.NodeImpl;

public class NodesImpl implements Nodes {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =NodeImpl.class, associateLoad = false, associateSave = false)
    private Set<Node> node = new LinkedHashSet<Node>();

    public static final String ParentPath = "ParentPath";
    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public Set<Node> getNode() {
        return this.node;
    }

    @Override
    public Node getFromNode(String key) {
        return this.node.stream().filter(value ->
                value.getId().equals(key))
                .findFirst().get();
    }
    @Override
    public String getParentPath() {
        return this.parentPath;
        }



    @Override
    public void setNode(Set<Node> node) {
        this.node = node;
    }

    @Override
    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }


    public void addToNode(Node addTo) {
        node.add(addTo);
    }


    @Override
    public void removeFromNode(String key) {
        Iterator<Node> iterator = this.node.iterator();
        while (iterator.hasNext()) {
            Node next = iterator.next();
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
        NodesImpl other = (NodesImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

