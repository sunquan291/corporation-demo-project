package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ntfbenchmark.rev20150105.ntfbenchmarkmodule.teststatus;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ntfbenchmark.rev20150105.ntfbenchmarkmodule.teststatus.teststatusoutput.ExecStatusEnum;

public class TestStatusOutput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    private ExecStatusEnum execStatus;
    private int execStatusValue;

    /**
     * "The number of times the notification benchmark test was invoked"
    */
    @Column
    private Long ntfCnt = 0L;


    public ExecStatusEnum getExecStatus() {
        this.execStatus =  ExecStatusEnum.of(execStatusValue);
        return this.execStatus;
    }


    public Long getNtfCnt() {
        return this.ntfCnt;
    }



    public void setExecStatus(ExecStatusEnum execStatus) {
        this.execStatus = execStatus;
        this.execStatusValue =  execStatus.getExecStatusEnum();
    }

    public void setNtfCnt(Long ntfCnt) {
        this.ntfCnt = ntfCnt;
    }
    public void setNtfCnt(String ntfCnt) {
        this.ntfCnt = Long.parseLong(ntfCnt);
    }



}

