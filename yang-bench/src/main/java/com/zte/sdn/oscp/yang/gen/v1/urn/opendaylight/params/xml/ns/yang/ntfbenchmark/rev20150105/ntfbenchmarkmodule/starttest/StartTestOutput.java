package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ntfbenchmark.rev20150105.ntfbenchmarkmodule.starttest;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;

public class StartTestOutput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "Number of successfully creceived notifications by all listeners"
    */
    @Column
    private Long listenerOk = 0L;

    /**
     * "Number of successfully generated notifications in all producer clients"
    */
    @Column
    private Long producerOk = 0L;

    /**
     * "Number of errors encoutered during notification generation at all producers"
    */
    @Column
    private Long producerError = 0L;

    /**
     * "The time it took for all producers to finish (i.e. to send their notifications), in milliseconds"
    */
    @Column
    private Long producerElapsedTime = 0L;

    /**
     * "The time it took for all listeners to finish (i.e. to receive their notifications), in milliseconds"
    */
    @Column
    private Long listenerElapsedTime = 0L;

    /**
     * "RPC rate (Number of RPCs/sec)"
    */
    @Column
    private Long producerRate = 0L;

    /**
     * "RPC rate (Number of RPCs/sec)"
    */
    @Column
    private Long listenerRate = 0L;


    public Long getListenerOk() {
        return this.listenerOk;
    }


    public Long getProducerOk() {
        return this.producerOk;
    }


    public Long getProducerError() {
        return this.producerError;
    }


    public Long getProducerElapsedTime() {
        return this.producerElapsedTime;
    }


    public Long getListenerElapsedTime() {
        return this.listenerElapsedTime;
    }


    public Long getProducerRate() {
        return this.producerRate;
    }


    public Long getListenerRate() {
        return this.listenerRate;
    }



    public void setListenerOk(Long listenerOk) {
        this.listenerOk = listenerOk;
    }
    public void setListenerOk(String listenerOk) {
        this.listenerOk = Long.parseLong(listenerOk);
    }

    public void setProducerOk(Long producerOk) {
        this.producerOk = producerOk;
    }
    public void setProducerOk(String producerOk) {
        this.producerOk = Long.parseLong(producerOk);
    }

    public void setProducerError(Long producerError) {
        this.producerError = producerError;
    }
    public void setProducerError(String producerError) {
        this.producerError = Long.parseLong(producerError);
    }

    public void setProducerElapsedTime(Long producerElapsedTime) {
        this.producerElapsedTime = producerElapsedTime;
    }
    public void setProducerElapsedTime(String producerElapsedTime) {
        this.producerElapsedTime = Long.parseLong(producerElapsedTime);
    }

    public void setListenerElapsedTime(Long listenerElapsedTime) {
        this.listenerElapsedTime = listenerElapsedTime;
    }
    public void setListenerElapsedTime(String listenerElapsedTime) {
        this.listenerElapsedTime = Long.parseLong(listenerElapsedTime);
    }

    public void setProducerRate(Long producerRate) {
        this.producerRate = producerRate;
    }
    public void setProducerRate(String producerRate) {
        this.producerRate = Long.parseLong(producerRate);
    }

    public void setListenerRate(Long listenerRate) {
        this.listenerRate = listenerRate;
    }
    public void setListenerRate(String listenerRate) {
        this.listenerRate = Long.parseLong(listenerRate);
    }



}

