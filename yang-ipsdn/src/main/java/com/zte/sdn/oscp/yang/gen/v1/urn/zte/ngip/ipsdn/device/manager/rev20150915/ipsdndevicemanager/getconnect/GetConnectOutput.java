package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getconnect;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getconnect.getconnectoutput.ConnectsImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getconnect.getconnectoutput.Connects;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import java.util.Set;
import java.util.LinkedHashSet;

public class GetConnectOutput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =ConnectsImpl.class, associateLoad = false, associateSave = false)
    private Set<Connects> connects = new LinkedHashSet<Connects>();


    public Set<Connects> getConnects() {
        return this.connects;
    }

    public Connects getFromConnects(String key) {
        return this.connects.stream().filter(value ->
                value.getNodeId().equals(key))
                .findFirst().get();
    }

    public void setConnects(Set<Connects> connects) {
        this.connects = connects;
    }



}

