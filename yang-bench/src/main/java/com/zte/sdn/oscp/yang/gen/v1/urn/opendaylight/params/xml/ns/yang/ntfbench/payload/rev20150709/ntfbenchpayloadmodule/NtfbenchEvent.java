package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ntfbench.payload.rev20150709.ntfbenchpayloadmodule;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ntfbench.payload.rev20150709.ntfbenchpayloadmodule.ntfbench.Payload;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ntfbench.payload.rev20150709.ntfbenchpayloadmodule.ntfbench.PayloadImpl;
import java.util.Set;
import java.util.LinkedHashSet;

public class NtfbenchEvent {

    public static final String DESTINATION="com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ntfbench.payload.rev20150709-ntfbench";

    /**
     * "The payload for the notification"
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =PayloadImpl.class, associateLoad = false, associateSave = false)
    private Set<Payload> payload = new LinkedHashSet<Payload>();


    public Set<Payload> getPayload() {
        return this.payload;
    }

    public Payload getFromPayload(Integer id) {
        return this.payload.parallelStream().filter(value ->
                value.getId().equals(id))
                .findAny().orElse(null);
    }

    public void setPayload(Set<Payload> payload) {
        this.payload = payload;
    }


    public void addToPayload(Payload addTo) {
        payload.add(addTo);
    }


    public void removeFromPayload(Integer id) {
        this.payload.remove(getFromPayload(id));
    }


}

