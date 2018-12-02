package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.testexec.OuterList;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import java.util.Set;
import java.util.LinkedHashSet;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.testexec.OuterListImpl;

public class TestExecImpl implements TestExec {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =OuterListImpl.class, associateLoad = false, associateSave = false)
    private Set<OuterList> outerList = new LinkedHashSet<OuterList>();

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public Set<OuterList> getOuterList() {
        return this.outerList;
    }

    @Override
    public OuterList getFromOuterList(Integer id) {
        return this.outerList.parallelStream().filter(value ->
                value.getId().equals(id))
                .findAny().orElse(null);
    }
    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setOuterList(Set<OuterList> outerList) {
        this.outerList = outerList;
    }

    @Override
    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }


    public void addToOuterList(OuterList addTo) {
        outerList.add(addTo);
    }


    @Override
    public void removeFromOuterList(Integer id) {
        this.outerList.remove(getFromOuterList(id));
    }

    @Override
    public int hashCode() {
        return Objects.hash(primaryId,parentPath);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestExecImpl other = (TestExecImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

