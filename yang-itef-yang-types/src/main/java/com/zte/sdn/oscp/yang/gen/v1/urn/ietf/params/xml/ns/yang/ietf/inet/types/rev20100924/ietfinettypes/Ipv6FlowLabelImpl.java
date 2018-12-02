package com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes;

import com.zte.sdn.oscp.persistence.validator.annotation.ExpressionRangeRestriction;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;

public class Ipv6FlowLabelImpl implements Ipv6FlowLabel {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer id;

    @Column
    private Integer parentId;

    public static final String Uint32 = "Uint32";
    @Column(displaySize = 10)
    @ExpressionRangeRestriction(rangeContent = "0..1048575")
    private Long uint32;

    public static final String ParentPath = "ParentPath";
    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public Long getUint32() {
        return this.uint32;
        }


    @Override
    public String getParentPath() {
        return this.parentPath;
        }



    @Override
    public void setUint32(Long uint32) {
        this.uint32 = uint32;
    }
    public void setUint32(String uint32) {
        this.uint32 = Long.parseLong(uint32);
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
        Ipv6FlowLabelImpl other = (Ipv6FlowLabelImpl) o;
        return
            Objects.equals(id,other.id)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

