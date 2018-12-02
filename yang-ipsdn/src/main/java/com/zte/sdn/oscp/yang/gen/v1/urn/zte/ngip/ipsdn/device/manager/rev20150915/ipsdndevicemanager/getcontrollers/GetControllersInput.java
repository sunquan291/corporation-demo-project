package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getcontrollers;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getcontrollers.getcontrollersinput.Nodes;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getcontrollers.getcontrollersinput.NodesImpl;
import java.util.Set;
import java.util.LinkedHashSet;

public class GetControllersInput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =NodesImpl.class, associateLoad = false, associateSave = false)
    private Set<Nodes> nodes = new LinkedHashSet<Nodes>();


    public Set<Nodes> getNodes() {
        return this.nodes;
    }

    public Nodes getFromNodes(String key) {
        return this.nodes.stream().filter(value ->
                value.getNodeId().equals(key))
                .findFirst().get();
    }

    public void setNodes(Set<Nodes> nodes) {
        this.nodes = nodes;
    }



}

