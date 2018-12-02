package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.authenticationdevicesnotification.Devices;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.authenticationdevicesnotification.DevicesImpl;
import java.util.Set;
import java.util.LinkedHashSet;

public class AuthenticationDevicesNotificationEvent {

    @Column(displaySize = 10)
    private String eventId;

    public static final String DESTINATION="com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915-authenticationDevicesNotification";

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =DevicesImpl.class, associateLoad = false, associateSave = false)
    private Set<Devices> devices = new LinkedHashSet<Devices>();


    public String getEventId() {
        return this.eventId;
    }


    public Set<Devices> getDevices() {
        return this.devices;
    }

    public Devices getFromDevices(String key) {
        return this.devices.stream().filter(value ->
                value.getSerialId().equals(key))
                .findFirst().get();
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public void setDevices(Set<Devices> devices) {
        this.devices = devices;
    }


    public void addToDevices(Devices addTo) {
        devices.add(addTo);
    }


    public void removeFromDevices(String key) {
        Iterator<Devices> iterator = this.devices.iterator();
        while (iterator.hasNext()) {
            Devices next = iterator.next();
            if (next.getSerialId().equals(key))
                iterator.remove();
        }
    }


}

