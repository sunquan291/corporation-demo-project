package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ntfbenchmark.rev20150105;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ntfbenchmark.rev20150105.ntfbenchmarkmodule.starttest.StartTestInput;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ntfbenchmark.rev20150105.ntfbenchmarkmodule.teststatus.TestStatusOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ntfbenchmark.rev20150105.ntfbenchmarkmodule.starttest.StartTestOutput;

public class NtfbenchmarkModuleImpl implements NtfbenchmarkModule {

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
        NtfbenchmarkModuleImpl other = (NtfbenchmarkModuleImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

