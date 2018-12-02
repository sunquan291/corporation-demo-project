package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.testexec;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.testexec.outerlist.InnerList;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.testexec.outerlist.outerchoice.TwoThree;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.testexec.outerlist.outerchoice.OneImpl;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.testexec.outerlist.outerchoice.One;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.testexec.outerlist.InnerListImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.testexec.outerlist.OuterChoice;
import java.util.Set;
import java.util.LinkedHashSet;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.testexec.outerlist.outerchoice.TwoThreeImpl;

public class OuterListImpl implements OuterList {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Column
    private Integer id;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = OneImpl.class)
    private One One = new OneImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = TwoThreeImpl.class)
    private TwoThree TwoThree = new TwoThreeImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =InnerListImpl.class, associateLoad = false, associateSave = false)
    private Set<InnerList> innerList = new LinkedHashSet<InnerList>();

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public Integer getId() {
        return this.id;
    }


    @Override
    public One getOne() {
        return this.One;
    }


    @Override
    public TwoThree getTwoThree() {
        return this.TwoThree;
    }


    @Override
    public Set<InnerList> getInnerList() {
        return this.innerList;
    }

    @Override
    public InnerList getFromInnerList(Integer name) {
        return this.innerList.parallelStream().filter(value ->
                value.getName().equals(name))
                .findAny().orElse(null);
    }
    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setId(Integer id) {
        this.id = id;
    }
    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    @Override
    public void setOne(One One) {
        this.One = One;
    }

    @Override
    public void setTwoThree(TwoThree TwoThree) {
        this.TwoThree = TwoThree;
    }

    @Override
    public void setInnerList(Set<InnerList> innerList) {
        this.innerList = innerList;
    }

    @Override
    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }


    public void addToInnerList(InnerList addTo) {
        innerList.add(addTo);
    }


    @Override
    public void removeFromInnerList(Integer name) {
        this.innerList.remove(getFromInnerList(name));
    }

    @Override
    public int hashCode() {
        return Objects.hash(primaryId,parentPath);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OuterListImpl other = (OuterListImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

