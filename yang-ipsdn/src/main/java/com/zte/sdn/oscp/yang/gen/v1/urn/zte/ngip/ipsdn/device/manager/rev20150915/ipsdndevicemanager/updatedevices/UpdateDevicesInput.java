package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.updatedevices;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.updatedevices.updatedevicesinput.UpdatingDeviceImpl;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.updatedevices.updatedevicesinput.UpdatingDevice;
import java.util.Set;
import java.util.LinkedHashSet;

public class UpdateDevicesInput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =UpdatingDeviceImpl.class, associateLoad = false, associateSave = false)
    private Set<UpdatingDevice> updatingDevice = new LinkedHashSet<UpdatingDevice>();


    public Set<UpdatingDevice> getUpdatingDevice() {
        return this.updatingDevice;
    }

    public UpdatingDevice getFromUpdatingDevice(String key) {
        return this.updatingDevice.stream().filter(value ->
                value.getNodeId().equals(key))
                .findFirst().get();
    }

    public void setUpdatingDevice(Set<UpdatingDevice> updatingDevice) {
        this.updatingDevice = updatingDevice;
    }



}

