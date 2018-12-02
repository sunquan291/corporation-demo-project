package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getnodebgplurouteid;

import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getnodebgplurouteid.getnodebgplurouteidinput.NodeIdList;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getnodebgplurouteid.getnodebgplurouteidinput.NodeIdListImpl;
import java.util.Set;
import java.util.LinkedHashSet;

public class GetNodeBgpLuRouteIdInput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =NodeIdListImpl.class, associateLoad = false, associateSave = false)
    private Set<NodeIdList> nodeIdList = new LinkedHashSet<NodeIdList>();


    public Set<NodeIdList> getNodeIdList() {
        return this.nodeIdList;
    }

    public NodeIdList getFromNodeIdList(String key) {
        return this.nodeIdList.stream().filter(value ->
                value.getNodeId().equals(key))
                .findFirst().get();
    }

    public void setNodeIdList(Set<NodeIdList> nodeIdList) {
        this.nodeIdList = nodeIdList;
    }



}

