package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portsconfignodes;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeId;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portsconfignodes.nodeports.PortsImpl;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portsconfignodes.nodeports.Ports;
import java.util.Set;
import java.util.LinkedHashSet;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeIdImpl;

public class NodePortsImpl implements NodePorts {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "English:The nodeid of the device (mac)."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = NodeIdImpl.class)
    private NodeId nodeId = new NodeIdImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =PortsImpl.class, associateLoad = false, associateSave = false)
    private Set<Ports> ports = new LinkedHashSet<Ports>();

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public NodeId getNodeId() {
        return this.nodeId;
    }


    @Override
    public Set<Ports> getPorts() {
        return this.ports;
    }

    @Override
    public Ports getFromPorts(String key) {
        return this.ports.stream().filter(value ->
                value.getName().equals(key))
                .findFirst().get();
    }
    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setNodeId(NodeId nodeId) {
        this.nodeId = nodeId;
    }

    @Override
    public void setPorts(Set<Ports> ports) {
        this.ports = ports;
    }

    @Override
    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }


    public void addToPorts(Ports addTo) {
        ports.add(addTo);
    }


    @Override
    public void removeFromPorts(String key) {
        Iterator<Ports> iterator = this.ports.iterator();
        while (iterator.hasNext()) {
            Ports next = iterator.next();
            if (next.getName().equals(key))
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
        NodePortsImpl other = (NodePortsImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

