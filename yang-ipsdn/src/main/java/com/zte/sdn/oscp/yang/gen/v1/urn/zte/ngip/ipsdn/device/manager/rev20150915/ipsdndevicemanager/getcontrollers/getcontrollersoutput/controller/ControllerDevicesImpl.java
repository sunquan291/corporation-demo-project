package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getcontrollers.getcontrollersoutput.controller;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getcontrollers.getcontrollersoutput.controller.controllerdevices.DeviceGroupImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getcontrollers.getcontrollersoutput.controller.controllerdevices.DeviceGroup;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import java.util.Set;
import java.util.LinkedHashSet;

public class ControllerDevicesImpl implements ControllerDevices {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =DeviceGroupImpl.class, associateLoad = false, associateSave = false)
    private Set<DeviceGroup> deviceGroup = new LinkedHashSet<DeviceGroup>();

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public Set<DeviceGroup> getDeviceGroup() {
        return this.deviceGroup;
    }

    @Override
    public DeviceGroup getFromDeviceGroup(String key) {
        return this.deviceGroup.stream().filter(value ->
                value.getNodeId().equals(key))
                .findFirst().get();
    }
    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setDeviceGroup(Set<DeviceGroup> deviceGroup) {
        this.deviceGroup = deviceGroup;
    }

    @Override
    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }


    public void addToDeviceGroup(DeviceGroup addTo) {
        deviceGroup.add(addTo);
    }


    @Override
    public void removeFromDeviceGroup(String key) {
        Iterator<DeviceGroup> iterator = this.deviceGroup.iterator();
        while (iterator.hasNext()) {
            DeviceGroup next = iterator.next();
            if (next.getNodeId().equals(key))
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
        ControllerDevicesImpl other = (ControllerDevicesImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

