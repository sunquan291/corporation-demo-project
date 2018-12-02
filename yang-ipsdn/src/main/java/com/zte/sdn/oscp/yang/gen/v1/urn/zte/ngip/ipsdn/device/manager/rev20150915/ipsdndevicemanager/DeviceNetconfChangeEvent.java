package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devicenetconfchange.DeviceNetconfImpl;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import java.util.Set;
import java.util.LinkedHashSet;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devicenetconfchange.DeviceNetconf;

public class DeviceNetconfChangeEvent {

    public static final String DESTINATION="com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915-deviceNetconfChange";

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =DeviceNetconfImpl.class, associateLoad = false, associateSave = false)
    private Set<DeviceNetconf> deviceNetconf = new LinkedHashSet<DeviceNetconf>();


    public Set<DeviceNetconf> getDeviceNetconf() {
        return this.deviceNetconf;
    }


    public void setDeviceNetconf(Set<DeviceNetconf> deviceNetconf) {
        this.deviceNetconf = deviceNetconf;
    }



}

