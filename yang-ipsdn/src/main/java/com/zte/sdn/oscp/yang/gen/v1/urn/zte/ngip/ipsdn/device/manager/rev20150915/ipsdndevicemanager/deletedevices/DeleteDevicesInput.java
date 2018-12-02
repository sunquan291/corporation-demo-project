package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.deletedevices;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.deletedevices.deletedevicesinput.DeletingDevice;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.deletedevices.deletedevicesinput.DeletingDeviceImpl;
import java.util.Set;
import java.util.LinkedHashSet;

public class DeleteDevicesInput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =DeletingDeviceImpl.class, associateLoad = false, associateSave = false)
    private Set<DeletingDevice> deletingDevice = new LinkedHashSet<DeletingDevice>();


    public Set<DeletingDevice> getDeletingDevice() {
        return this.deletingDevice;
    }


    public void setDeletingDevice(Set<DeletingDevice> deletingDevice) {
        this.deletingDevice = deletingDevice;
    }



}

