package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.starttest;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.starttest.starttestoutput.StatusEnum;

public class StartTestOutput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "Indicates whether the test finished successfuly"
    */
    private StatusEnum status;
    private int statusValue;

    public static final String LISTBUILDTIME_UNITS = "microseconds";

    /**
     * "The time it took to build the list of lists"
    */
    @Column
    private Long listBuildTime;

    public static final String EXECTIME_UNITS = "microseconds";

    /**
     * "The time it took to execute all transactions"
    */
    @Column
    private Long execTime;

    /**
     * "The number of successful transactions"
    */
    @Column
    private Long txOk;

    /**
     * "The number of failed transactions"
    */
    @Column
    private Long txError;

    /**
     * "The number of successfully received data tree change
                   notifications"
    */
    @Column
    private Long ntfOk;

    /**
     * "The number of data change events received in data tree
                   change notifications"
    */
    @Column
    private Long dataChangeEventsOk;


    public StatusEnum getStatus() {
        this.status =  StatusEnum.of(statusValue);
        return this.status;
    }


    public Long getListBuildTime() {
        return this.listBuildTime;
    }


    public Long getExecTime() {
        return this.execTime;
    }


    public Long getTxOk() {
        return this.txOk;
    }


    public Long getTxError() {
        return this.txError;
    }


    public Long getNtfOk() {
        return this.ntfOk;
    }


    public Long getDataChangeEventsOk() {
        return this.dataChangeEventsOk;
    }



    public void setStatus(StatusEnum status) {
        this.status = status;
        this.statusValue =  status.getStatusEnum();
    }

    public void setListBuildTime(Long listBuildTime) {
        this.listBuildTime = listBuildTime;
    }
    public void setListBuildTime(String listBuildTime) {
        this.listBuildTime = Long.parseLong(listBuildTime);
    }

    public void setExecTime(Long execTime) {
        this.execTime = execTime;
    }
    public void setExecTime(String execTime) {
        this.execTime = Long.parseLong(execTime);
    }

    public void setTxOk(Long txOk) {
        this.txOk = txOk;
    }
    public void setTxOk(String txOk) {
        this.txOk = Long.parseLong(txOk);
    }

    public void setTxError(Long txError) {
        this.txError = txError;
    }
    public void setTxError(String txError) {
        this.txError = Long.parseLong(txError);
    }

    public void setNtfOk(Long ntfOk) {
        this.ntfOk = ntfOk;
    }
    public void setNtfOk(String ntfOk) {
        this.ntfOk = Long.parseLong(ntfOk);
    }

    public void setDataChangeEventsOk(Long dataChangeEventsOk) {
        this.dataChangeEventsOk = dataChangeEventsOk;
    }
    public void setDataChangeEventsOk(String dataChangeEventsOk) {
        this.dataChangeEventsOk = Long.parseLong(dataChangeEventsOk);
    }



}

