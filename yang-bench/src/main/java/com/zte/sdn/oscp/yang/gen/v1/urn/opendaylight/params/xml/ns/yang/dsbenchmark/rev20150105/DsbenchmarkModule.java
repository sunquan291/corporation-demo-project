package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105;

import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.TestStatus;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.TestExec;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.starttest.StartTestOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.starttest.StartTestInput;

@Table
public interface DsbenchmarkModule {

    TestExec getTestExec();

    TestStatus getTestStatus();

    StartTestOutput startTest(StartTestInput input);

    String getParentPath();


    void setTestExec(TestExec testExec);

    void setTestStatus(TestStatus testStatus);

    void setParentPath(String parentPath);


}

