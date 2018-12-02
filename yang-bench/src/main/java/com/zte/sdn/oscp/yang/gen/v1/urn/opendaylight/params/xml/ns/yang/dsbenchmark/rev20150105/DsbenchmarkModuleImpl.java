package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.TestStatusImpl;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.TestExecImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.TestStatus;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.TestExec;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.starttest.StartTestOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.starttest.StartTestInput;

public class DsbenchmarkModuleImpl implements DsbenchmarkModule {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Column
    private Integer yangVersion = 1;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = TestExecImpl.class)
    private TestExec testExec = new TestExecImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = TestStatusImpl.class)
    private TestStatus testStatus = new TestStatusImpl();

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public TestExec getTestExec() {
        return this.testExec;
    }


    @Override
    public TestStatus getTestStatus() {
        return this.testStatus;
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
    public void setTestExec(TestExec testExec) {
        this.testExec = testExec;
    }

    @Override
    public void setTestStatus(TestStatus testStatus) {
        this.testStatus = testStatus;
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
        DsbenchmarkModuleImpl other = (DsbenchmarkModuleImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

