package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getdevices;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getdevices.getdevicesoutput.DeviceInfo;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getdevices.getdevicesoutput.DeviceInfoImpl;
import java.util.Set;
import java.util.LinkedHashSet;

public class GetDevicesOutput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "H controller get all D controller device info."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =DeviceInfoImpl.class, associateLoad = false, associateSave = false)
    private Set<DeviceInfo> deviceInfo = new LinkedHashSet<DeviceInfo>();


    public Set<DeviceInfo> getDeviceInfo() {
        return this.deviceInfo;
    }


    public void setDeviceInfo(Set<DeviceInfo> deviceInfo) {
        this.deviceInfo = deviceInfo;
    }



}

