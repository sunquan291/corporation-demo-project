package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result.success.ports.accesstype;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result.success.ports.accesstype.vlanrange.VlanRange;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result.success.ports.accesstype.vlanrange.VlanRangeImpl;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import java.util.Set;
import java.util.LinkedHashSet;

public class VlanrangeImpl implements Vlanrange {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =VlanRangeImpl.class, associateLoad = false, associateSave = false)
    private Set<VlanRange> vlanRange = new LinkedHashSet<VlanRange>();

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public Set<VlanRange> getVlanRange() {
        return this.vlanRange;
    }

    @Override
    public VlanRange getFromVlanRange(String key) {
        return this.vlanRange.stream().filter(value ->
                value.getVlanBegin().equals(key))
                .findFirst().get();
    }
    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setVlanRange(Set<VlanRange> vlanRange) {
        this.vlanRange = vlanRange;
    }

    @Override
    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }


    public void addToVlanRange(VlanRange addTo) {
        vlanRange.add(addTo);
    }


    @Override
    public void removeFromVlanRange(String key) {
        Iterator<VlanRange> iterator = this.vlanRange.iterator();
        while (iterator.hasNext()) {
            VlanRange next = iterator.next();
            if (next.getVlanBegin().equals(key))
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
        VlanrangeImpl other = (VlanrangeImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

