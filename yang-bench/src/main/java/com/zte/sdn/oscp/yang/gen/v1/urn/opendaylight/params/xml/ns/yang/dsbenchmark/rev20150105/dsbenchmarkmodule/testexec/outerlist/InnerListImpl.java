package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.testexec.outerlist;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;

public class InnerListImpl implements InnerList {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Column
    private Integer name;

    @Column(displaySize = 10)
    private String value;

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public Integer getName() {
        return this.name;
    }


    @Override
    public String getValue() {
        return this.value;
    }


    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setName(Integer name) {
        this.name = name;
    }
    public void setName(String name) {
        this.name = Integer.parseInt(name);
    }

    @Override
    public void setValue(String value) {
        this.value = value;
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
        InnerListImpl other = (InnerListImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

