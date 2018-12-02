package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getdevices;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getdevices.getdevicesinput.Nodes;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.NodeType;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.NodeTypeImpl;
import java.util.Set;
import java.util.LinkedHashSet;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getdevices.getdevicesinput.NodesImpl;

public class GetDevicesInput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = NodeTypeImpl.class)
    private NodeType nodeType = new NodeTypeImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =NodesImpl.class, associateLoad = false, associateSave = false)
    private Set<Nodes> nodes = new LinkedHashSet<Nodes>();


    public NodeType getNodeType() {
        return this.nodeType;
    }


    public Set<Nodes> getNodes() {
        return this.nodes;
    }

    public Nodes getFromNodes(String key) {
        return this.nodes.stream().filter(value ->
                value.getNodeId().equals(key))
                .findFirst().get();
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }

    public void setNodes(Set<Nodes> nodes) {
        this.nodes = nodes;
    }



}

