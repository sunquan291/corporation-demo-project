package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.teststatus.ExecStatusEnum;

public class TestStatusImpl implements TestStatus {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "Indicates whether a test run is in progress; only one test can run at a time"
    */
    private ExecStatusEnum execStatus;
    private int execStatusValue;

    /**
     * "Number of completed test runs"
    */
    @Column
    private Long testsCompleted = 1L;

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public ExecStatusEnum getExecStatus() {
        this.execStatus =  ExecStatusEnum.of(execStatusValue);
        return this.execStatus;
    }


    @Override
    public Long getTestsCompleted() {
        return this.testsCompleted;
    }


    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setExecStatus(ExecStatusEnum execStatus) {
        this.execStatus = execStatus;
        this.execStatusValue =  execStatus.getExecStatusEnum();
    }

    @Override
    public void setTestsCompleted(Long testsCompleted) {
        this.testsCompleted = testsCompleted;
    }
    public void setTestsCompleted(String testsCompleted) {
        this.testsCompleted = Long.parseLong(testsCompleted);
    }

    @Override
    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }


    @Override
    public int hashCode() {
        return Objects.hash(primaryId,parentPath);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestStatusImpl other = (TestStatusImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

