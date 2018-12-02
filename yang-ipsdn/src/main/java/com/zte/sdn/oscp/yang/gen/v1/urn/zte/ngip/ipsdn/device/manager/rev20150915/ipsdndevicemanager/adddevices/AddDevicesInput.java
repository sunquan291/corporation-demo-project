package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.adddevices;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.adddevices.adddevicesinput.AddingDevice;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.adddevices.adddevicesinput.AddingDeviceImpl;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import java.util.Set;
import java.util.LinkedHashSet;

public class AddDevicesInput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =AddingDeviceImpl.class, associateLoad = false, associateSave = false)
    private Set<AddingDevice> addingDevice = new LinkedHashSet<AddingDevice>();


    public Set<AddingDevice> getAddingDevice() {
        return this.addingDevice;
    }

    public AddingDevice getFromAddingDevice(String key) {
        return this.addingDevice.stream().filter(value ->
                value.getNodeId().equals(key))
                .findFirst().get();
    }

    public void setAddingDevice(Set<AddingDevice> addingDevice) {
        this.addingDevice = addingDevice;
    }



}

