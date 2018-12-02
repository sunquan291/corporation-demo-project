package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getdevicenetconf;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getdevicenetconf.getdevicenetconfoutput.DeviceNetconf;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getdevicenetconf.getdevicenetconfoutput.DeviceNetconfImpl;
import java.util.Set;
import java.util.LinkedHashSet;

public class GetDeviceNetconfOutput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "H controller get all device netconf info."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =DeviceNetconfImpl.class, associateLoad = false, associateSave = false)
    private Set<DeviceNetconf> deviceNetconf = new LinkedHashSet<DeviceNetconf>();


    public Set<DeviceNetconf> getDeviceNetconf() {
        return this.deviceNetconf;
    }


    public void setDeviceNetconf(Set<DeviceNetconf> deviceNetconf) {
        this.deviceNetconf = deviceNetconf;
    }



}

