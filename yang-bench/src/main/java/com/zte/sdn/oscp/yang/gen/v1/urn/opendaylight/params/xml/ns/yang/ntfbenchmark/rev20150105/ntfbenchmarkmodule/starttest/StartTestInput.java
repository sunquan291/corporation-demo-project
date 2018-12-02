package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ntfbenchmark.rev20150105.ntfbenchmarkmodule.starttest;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ntfbenchmark.rev20150105.ntfbenchmarkmodule.starttest.starttestinput.ProducerTypeEnum;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;

public class StartTestInput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "RPC type and client type to use in the test"
    */
    private ProducerTypeEnum producerType;
    private int producerTypeValue;

    /**
     * "Number of notification producers (test client threads) to start"
    */
    @Column
    private Long producers = 1L;

    /**
     * "Number of notification listener instances"
    */
    @Column
    private Long listeners = 1L;

    /**
     * "Notification payload size: number of elements in the list of integers that is the notification payload"
    */
    @Column
    private Long payloadSize = 1L;

    /**
     * "Number of notifications to generate in each client thread"
    */
    @Column
    private Long iterations = 1L;


    public ProducerTypeEnum getProducerType() {
        this.producerType =  ProducerTypeEnum.of(producerTypeValue);
        return this.producerType;
    }


    public Long getProducers() {
        return this.producers;
    }


    public Long getListeners() {
        return this.listeners;
    }


    public Long getPayloadSize() {
        return this.payloadSize;
    }


    public Long getIterations() {
        return this.iterations;
    }



    public void setProducerType(ProducerTypeEnum producerType) {
        this.producerType = producerType;
        this.producerTypeValue =  producerType.getProducerTypeEnum();
    }

    public void setProducers(Long producers) {
        this.producers = producers;
    }
    public void setProducers(String producers) {
        this.producers = Long.parseLong(producers);
    }

    public void setListeners(Long listeners) {
        this.listeners = listeners;
    }
    public void setListeners(String listeners) {
        this.listeners = Long.parseLong(listeners);
    }

    public void setPayloadSize(Long payloadSize) {
        this.payloadSize = payloadSize;
    }
    public void setPayloadSize(String payloadSize) {
        this.payloadSize = Long.parseLong(payloadSize);
    }

    public void setIterations(Long iterations) {
        this.iterations = iterations;
    }
    public void setIterations(String iterations) {
        this.iterations = Long.parseLong(iterations);
    }



}

