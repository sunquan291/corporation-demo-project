package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager;

import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddress;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.OperationTypeImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devicechange.DeviceGroupImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devicechange.DeviceGroup;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddressImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.OperationType;
import java.util.Set;
import java.util.LinkedHashSet;

public class DeviceChangeEvent {

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = OperationTypeImpl.class)
    private OperationType changeType = new OperationTypeImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = IpAddressImpl.class)
    private IpAddress controller = new IpAddressImpl();

    public static final String DESTINATION="com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915-deviceChange";

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =DeviceGroupImpl.class, associateLoad = false, associateSave = false)
    private Set<DeviceGroup> deviceGroup = new LinkedHashSet<DeviceGroup>();


    public OperationType getChangeType() {
        return this.changeType;
    }


    public IpAddress getController() {
        return this.controller;
    }


    public Set<DeviceGroup> getDeviceGroup() {
        return this.deviceGroup;
    }

    public DeviceGroup getFromDeviceGroup(String key) {
        return this.deviceGroup.stream().filter(value ->
                value.getNodeId().equals(key))
                .findFirst().get();
    }

    public void setChangeType(OperationType changeType) {
        this.changeType = changeType;
    }

    public void setController(IpAddress controller) {
        this.controller = controller;
    }

    public void setDeviceGroup(Set<DeviceGroup> deviceGroup) {
        this.deviceGroup = deviceGroup;
    }


    public void addToDeviceGroup(DeviceGroup addTo) {
        deviceGroup.add(addTo);
    }


    public void removeFromDeviceGroup(String key) {
        Iterator<DeviceGroup> iterator = this.deviceGroup.iterator();
        while (iterator.hasNext()) {
            DeviceGroup next = iterator.next();
            if (next.getNodeId().equals(key))
                iterator.remove();
        }
    }


}

