package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager;

import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portsconfignodes.NodePorts;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portsconfignodes.NodePortsImpl;
import java.util.Set;
import java.util.LinkedHashSet;

public class PortsConfigNodesImpl implements PortsConfigNodes {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =NodePortsImpl.class, associateLoad = false, associateSave = false)
    private Set<NodePorts> nodePorts = new LinkedHashSet<NodePorts>();

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public Set<NodePorts> getNodePorts() {
        return this.nodePorts;
    }

    @Override
    public NodePorts getFromNodePorts(String key) {
        return this.nodePorts.stream().filter(value ->
                value.getNodeId().equals(key))
                .findFirst().get();
    }
    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setNodePorts(Set<NodePorts> nodePorts) {
        this.nodePorts = nodePorts;
    }

    @Override
    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }


    public void addToNodePorts(NodePorts addTo) {
        nodePorts.add(addTo);
    }


    @Override
    public void removeFromNodePorts(String key) {
        Iterator<NodePorts> iterator = this.nodePorts.iterator();
        while (iterator.hasNext()) {
            NodePorts next = iterator.next();
            if (next.getNodeId().equals(key))
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
        PortsConfigNodesImpl other = (PortsConfigNodesImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

