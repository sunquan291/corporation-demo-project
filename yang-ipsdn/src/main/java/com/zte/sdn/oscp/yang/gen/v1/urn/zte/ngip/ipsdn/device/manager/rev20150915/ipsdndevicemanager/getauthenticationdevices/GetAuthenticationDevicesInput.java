package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getauthenticationdevices;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.AuthenticationStatus;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.AuthenticationStatusImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getauthenticationdevices.getauthenticationdevicesinput.SerialIds;
import java.util.Set;
import java.util.LinkedHashSet;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getauthenticationdevices.getauthenticationdevicesinput.SerialIdsImpl;

public class GetAuthenticationDevicesInput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = AuthenticationStatusImpl.class)
    private AuthenticationStatus status = new AuthenticationStatusImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =SerialIdsImpl.class, associateLoad = false, associateSave = false)
    private Set<SerialIds> serialIds = new LinkedHashSet<SerialIds>();


    public AuthenticationStatus getStatus() {
        return this.status;
    }


    public Set<SerialIds> getSerialIds() {
        return this.serialIds;
    }


    public void setStatus(AuthenticationStatus status) {
        this.status = status;
    }

    public void setSerialIds(Set<SerialIds> serialIds) {
        this.serialIds = serialIds;
    }



}

