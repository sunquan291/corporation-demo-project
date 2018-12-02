package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result.success.PortsImpl;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result.success.Ports;
import java.util.Set;
import java.util.LinkedHashSet;

public class SuccessImpl implements Success {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =PortsImpl.class, associateLoad = false, associateSave = false)
    private Set<Ports> ports = new LinkedHashSet<Ports>();

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public Set<Ports> getPorts() {
        return this.ports;
    }

    @Override
    public String getParentPath() {
        return this.parentPath;
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
        ports.remove(key);
        setPorts(this.ports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primaryId,parentPath);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuccessImpl other = (SuccessImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

