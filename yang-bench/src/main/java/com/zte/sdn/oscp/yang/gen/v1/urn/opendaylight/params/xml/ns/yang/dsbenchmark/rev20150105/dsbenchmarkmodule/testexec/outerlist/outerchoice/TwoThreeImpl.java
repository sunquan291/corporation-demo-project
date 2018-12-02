package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.testexec.outerlist.outerchoice;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;

public class TwoThreeImpl implements TwoThree {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Column(displaySize = 10)
    private String two;

    @Column(displaySize = 10)
    private String three;

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public String getTwo() {
        return this.two;
    }


    @Override
    public String getThree() {
        return this.three;
    }


    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setTwo(String two) {
        this.two = two;
    }

    @Override
    public void setThree(String three) {
        this.three = three;
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
        TwoThreeImpl other = (TwoThreeImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

