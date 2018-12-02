package com.zte.sdn.oscp.yang.gen.v1.rpcbench.payload.rev20150702.rpcbenchpayloadmodule.routedrpcbench;

import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.rpcbench.payload.rev20150702.rpcbenchpayloadmodule.routedrpcbench.routedrpcbenchinput.PayloadImpl;
import java.util.Set;
import java.util.LinkedHashSet;
import com.zte.sdn.oscp.yang.gen.v1.rpcbench.payload.rev20150702.rpcbenchpayloadmodule.routedrpcbench.routedrpcbenchinput.Payload;

public class RoutedRpcBenchInput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Column(displaySize = 10)
    private String node;

    /**
     * "The input and output payload for the RPC Benchmark's Global RPC Server (a list of integers)"
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =PayloadImpl.class, associateLoad = false, associateSave = false)
    private Set<Payload> payload = new LinkedHashSet<Payload>();


    public String getNode() {
        return this.node;
    }


    public Set<Payload> getPayload() {
        return this.payload;
    }

    public Payload getFromPayload(Integer id) {
        return this.payload.parallelStream().filter(value ->
                value.getId().equals(id))
                .findAny().orElse(null);
    }

    public void setNode(String node) {
        this.node = node;
    }

    public void setPayload(Set<Payload> payload) {
        this.payload = payload;
    }



}

