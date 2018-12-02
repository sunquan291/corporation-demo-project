package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.rpcbenchmark.rev20150702.rpcbenchmarkmodule.teststatus;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.rpcbenchmark.rev20150702.rpcbenchmarkmodule.teststatus.teststatusoutput.ExecStatusEnum;

public class TestStatusOutput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    private ExecStatusEnum execStatus;
    private int execStatusValue;

    /**
     * "The number of times the Global RPC server was invoked"
    */
    @Column
    private Long globalServerCnt = 0L;


    public ExecStatusEnum getExecStatus() {
        this.execStatus =  ExecStatusEnum.of(execStatusValue);
        return this.execStatus;
    }


    public Long getGlobalServerCnt() {
        return this.globalServerCnt;
    }



    public void setExecStatus(ExecStatusEnum execStatus) {
        this.execStatus = execStatus;
        this.execStatusValue =  execStatus.getExecStatusEnum();
    }

    public void setGlobalServerCnt(Long globalServerCnt) {
        this.globalServerCnt = globalServerCnt;
    }
    public void setGlobalServerCnt(String globalServerCnt) {
        this.globalServerCnt = Long.parseLong(globalServerCnt);
    }



}

