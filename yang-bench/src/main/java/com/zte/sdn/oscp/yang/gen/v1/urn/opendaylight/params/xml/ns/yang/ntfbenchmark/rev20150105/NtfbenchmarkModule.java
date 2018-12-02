package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ntfbenchmark.rev20150105;

import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ntfbenchmark.rev20150105.ntfbenchmarkmodule.starttest.StartTestInput;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ntfbenchmark.rev20150105.ntfbenchmarkmodule.teststatus.TestStatusOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ntfbenchmark.rev20150105.ntfbenchmarkmodule.starttest.StartTestOutput;

@Table
public interface NtfbenchmarkModule {

    TestStatusOutput testStatus();

    StartTestOutput startTest(StartTestInput input);

    String getParentPath();


    void setParentPath(String parentPath);


}

