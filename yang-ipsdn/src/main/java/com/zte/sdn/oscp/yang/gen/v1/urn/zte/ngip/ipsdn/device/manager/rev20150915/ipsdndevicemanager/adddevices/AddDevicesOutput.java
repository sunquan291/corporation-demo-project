package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.adddevices;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.adddevices.adddevicesoutput.FailNodeImpl;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.adddevices.adddevicesoutput.FailNode;
import java.util.Set;
import java.util.LinkedHashSet;

public class AddDevicesOutput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =FailNodeImpl.class, associateLoad = false, associateSave = false)
    private Set<FailNode> failNode = new LinkedHashSet<FailNode>();


    public Set<FailNode> getFailNode() {
        return this.failNode;
    }

    public FailNode getFromFailNode(String key) {
        return this.failNode.stream().filter(value ->
                value.getNodeId().equals(key))
                .findFirst().get();
    }

    public void setFailNode(Set<FailNode> failNode) {
        this.failNode = failNode;
    }



}

