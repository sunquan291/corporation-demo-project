package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule;

import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.teststatus.ExecStatusEnum;

@Table
public interface TestStatus {

    /**
     * "Indicates whether a test run is in progress; only one test can run at a time"
     * @return 
    */
    ExecStatusEnum getExecStatus();

    /**
     * "Number of completed test runs"
     * @return 
    */
    Long getTestsCompleted();

    String getParentPath();


    /**
     * "Indicates whether a test run is in progress; only one test can run at a time"
     * @param execStatus 
    */
    void setExecStatus(ExecStatusEnum execStatus);

    /**
     * "Number of completed test runs"
     * @param testsCompleted 
    */
    void setTestsCompleted(Long testsCompleted);

    void setParentPath(String parentPath);


}

