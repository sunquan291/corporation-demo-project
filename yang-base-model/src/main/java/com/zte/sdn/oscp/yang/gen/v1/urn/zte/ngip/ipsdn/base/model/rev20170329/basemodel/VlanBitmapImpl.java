package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel;

import com.zte.sdn.oscp.persistence.validator.annotation.ExpressionRangeRestriction;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;

public class VlanBitmapImpl implements VlanBitmap {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    public static final String Int32 = "Int32";
    @Column(displaySize = 10)
    @ExpressionRangeRestriction(rangeContent = "1..4094")
    private Integer int32;

    public static final String ParentPath = "ParentPath";
    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public Integer getInt32() {
        return this.int32;
        }


    @Override
    public String getParentPath() {
        return this.parentPath;
        }



    @Override
    public void setInt32(Integer int32) {
        this.int32 = int32;
    }
    public void setInt32(String int32) {
        this.int32 = Integer.parseInt(int32);
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
        VlanBitmapImpl other = (VlanBitmapImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

