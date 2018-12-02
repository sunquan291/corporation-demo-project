package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result.success.ports;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result.success.ports.vlanattribute.TagPort;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result.success.ports.vlanattribute.PvidPortImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result.success.ports.vlanattribute.UntagPortImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result.success.ports.vlanattribute.PvidPort;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result.success.ports.vlanattribute.UntagPort;
import java.util.Set;
import java.util.LinkedHashSet;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result.success.ports.vlanattribute.TagPortImpl;

public class VlanAttributeImpl implements VlanAttribute {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =PvidPortImpl.class, associateLoad = false, associateSave = false)
    private Set<PvidPort> pvidPort = new LinkedHashSet<PvidPort>();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =TagPortImpl.class, associateLoad = false, associateSave = false)
    private Set<TagPort> tagPort = new LinkedHashSet<TagPort>();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =UntagPortImpl.class, associateLoad = false, associateSave = false)
    private Set<UntagPort> untagPort = new LinkedHashSet<UntagPort>();

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public Set<PvidPort> getPvidPort() {
        return this.pvidPort;
    }

    @Override
    public PvidPort getFromPvidPort(String key) {
        return this.pvidPort.stream().filter(value ->
                value.getPortName().equals(key))
                .findFirst().get();
    }
    @Override
    public Set<TagPort> getTagPort() {
        return this.tagPort;
    }

    @Override
    public TagPort getFromTagPort(String key) {
        return this.tagPort.stream().filter(value ->
                value.getPortName().equals(key))
                .findFirst().get();
    }
    @Override
    public Set<UntagPort> getUntagPort() {
        return this.untagPort;
    }

    @Override
    public UntagPort getFromUntagPort(String key) {
        return this.untagPort.stream().filter(value ->
                value.getPortName().equals(key))
                .findFirst().get();
    }
    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setPvidPort(Set<PvidPort> pvidPort) {
        this.pvidPort = pvidPort;
    }

    @Override
    public void setTagPort(Set<TagPort> tagPort) {
        this.tagPort = tagPort;
    }

    @Override
    public void setUntagPort(Set<UntagPort> untagPort) {
        this.untagPort = untagPort;
    }

    @Override
    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }


    public void addToPvidPort(PvidPort addTo) {
        pvidPort.add(addTo);
    }

    public void addToTagPort(TagPort addTo) {
        tagPort.add(addTo);
    }

    public void addToUntagPort(UntagPort addTo) {
        untagPort.add(addTo);
    }


    @Override
    public void removeFromPvidPort(String key) {
        Iterator<PvidPort> iterator = this.pvidPort.iterator();
        while (iterator.hasNext()) {
            PvidPort next = iterator.next();
            if (next.getPortName().equals(key))
                iterator.remove();
        }
    }
    @Override
    public void removeFromTagPort(String key) {
        Iterator<TagPort> iterator = this.tagPort.iterator();
        while (iterator.hasNext()) {
            TagPort next = iterator.next();
            if (next.getPortName().equals(key))
                iterator.remove();
        }
    }
    @Override
    public void removeFromUntagPort(String key) {
        Iterator<UntagPort> iterator = this.untagPort.iterator();
        while (iterator.hasNext()) {
            UntagPort next = iterator.next();
            if (next.getPortName().equals(key))
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
        VlanAttributeImpl other = (VlanAttributeImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

