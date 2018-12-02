package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.rpcbenchmark.rev20150702;

import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.rpcbenchmark.rev20150702.rpcbenchmarkmodule.starttest.StartTestOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.rpcbenchmark.rev20150702.rpcbenchmarkmodule.teststatus.TestStatusOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.rpcbenchmark.rev20150702.rpcbenchmarkmodule.starttest.StartTestInput;

@Table
public interface RpcbenchmarkModule {

    TestStatusOutput testStatus();

    StartTestOutput startTest(StartTestInput input);

    String getParentPath();


    void setParentPath(String parentPath);


}

