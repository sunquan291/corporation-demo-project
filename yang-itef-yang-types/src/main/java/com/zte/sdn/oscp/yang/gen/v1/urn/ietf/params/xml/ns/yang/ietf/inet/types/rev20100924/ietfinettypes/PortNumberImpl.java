package com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes;

import com.zte.sdn.oscp.persistence.validator.annotation.ExpressionRangeRestriction;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;

public class PortNumberImpl implements PortNumber {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer id;

    @Column
    private Integer parentId;

    public static final String Uint16 = "Uint16";
    @Column(displaySize = 10)
    @ExpressionRangeRestriction(rangeContent = "0..65535")
    private Integer uint16;

    public static final String ParentPath = "ParentPath";
    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public Integer getUint16() {
        return this.uint16;
        }


    @Override
    public String getParentPath() {
        return this.parentPath;
        }



    @Override
    public void setUint16(Integer uint16) {
        this.uint16 = uint16;
    }
    public void setUint16(String uint16) {
        this.uint16 = Integer.parseInt(uint16);
    }

    @Override
    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id,parentPath);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PortNumberImpl other = (PortNumberImpl) o;
        return
            Objects.equals(id,other.id)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

