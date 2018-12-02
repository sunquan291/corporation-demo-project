package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.rpcbenchmark.rev20150702;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.rpcbenchmark.rev20150702.rpcbenchmarkmodule.starttest.StartTestOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.rpcbenchmark.rev20150702.rpcbenchmarkmodule.teststatus.TestStatusOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.rpcbenchmark.rev20150702.rpcbenchmarkmodule.starttest.StartTestInput;

public class RpcbenchmarkModuleImpl implements RpcbenchmarkModule {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Column
    private Integer yangVersion = 1;

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public TestStatusOutput testStatus() {
        //TODO::rpc implements
        return null;
    }

    @Override
    public StartTestOutput startTest(StartTestInput input) {
        //TODO::rpc implements
        return null;
    }

    @Override
    public String getParentPath() {
        return this.parentPath;
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
        RpcbenchmarkModuleImpl other = (RpcbenchmarkModuleImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

