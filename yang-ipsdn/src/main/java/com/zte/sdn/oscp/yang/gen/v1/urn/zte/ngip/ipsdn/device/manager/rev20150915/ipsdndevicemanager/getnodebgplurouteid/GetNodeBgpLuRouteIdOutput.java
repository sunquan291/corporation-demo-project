package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getnodebgplurouteid;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getnodebgplurouteid.getnodebgplurouteidoutput.NodeIdBgpLuList;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getnodebgplurouteid.getnodebgplurouteidoutput.NodeIdBgpLuListImpl;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import java.util.Set;
import java.util.LinkedHashSet;

public class GetNodeBgpLuRouteIdOutput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =NodeIdBgpLuListImpl.class, associateLoad = false, associateSave = false)
    private Set<NodeIdBgpLuList> nodeIdBgpLuList = new LinkedHashSet<NodeIdBgpLuList>();


    public Set<NodeIdBgpLuList> getNodeIdBgpLuList() {
        return this.nodeIdBgpLuList;
    }

    public NodeIdBgpLuList getFromNodeIdBgpLuList(String key) {
        return this.nodeIdBgpLuList.stream().filter(value ->
                value.getNodeIdBgpLu().equals(key))
                .findFirst().get();
    }

    public void setNodeIdBgpLuList(Set<NodeIdBgpLuList> nodeIdBgpLuList) {
        this.nodeIdBgpLuList = nodeIdBgpLuList;
    }



}

