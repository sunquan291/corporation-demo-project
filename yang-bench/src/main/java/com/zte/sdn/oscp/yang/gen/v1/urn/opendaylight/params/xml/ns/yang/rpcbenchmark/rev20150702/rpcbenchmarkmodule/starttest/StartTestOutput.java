package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.rpcbenchmark.rev20150702.rpcbenchmarkmodule.starttest;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;

public class StartTestOutput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "Number of successful calls to the Global RPC Server for all test threads"
    */
    @Column
    private Long globalRtcClientOk = 0L;

    /**
     * "Number of failed calls to the Global RPC server from all test threads"
    */
    @Column
    private Long globalRtcClientError = 0L;

    /**
     * "Test execution time, in milliseconds"
    */
    @Column
    private Long execTime = 0L;

    /**
     * "RPC rate (Number of RPCs/sec)"
    */
    @Column
    private Long rate = 0L;


    public Long getGlobalRtcClientOk() {
        return this.globalRtcClientOk;
    }


    public Long getGlobalRtcClientError() {
        return this.globalRtcClientError;
    }


    public Long getExecTime() {
        return this.execTime;
    }


    public Long getRate() {
        return this.rate;
    }



    public void setGlobalRtcClientOk(Long globalRtcClientOk) {
        this.globalRtcClientOk = globalRtcClientOk;
    }
    public void setGlobalRtcClientOk(String globalRtcClientOk) {
        this.globalRtcClientOk = Long.parseLong(globalRtcClientOk);
    }

    public void setGlobalRtcClientError(Long globalRtcClientError) {
        this.globalRtcClientError = globalRtcClientError;
    }
    public void setGlobalRtcClientError(String globalRtcClientError) {
        this.globalRtcClientError = Long.parseLong(globalRtcClientError);
    }

    public void setExecTime(Long execTime) {
        this.execTime = execTime;
    }
    public void setExecTime(String execTime) {
        this.execTime = Long.parseLong(execTime);
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }
    public void setRate(String rate) {
        this.rate = Long.parseLong(rate);
    }



}

