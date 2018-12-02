package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.persistence.validator.annotation.ExpressionLengthRestriction;

public class FailImpl implements Fail {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "The failed reason info."
    */
    @Column(displaySize = 10)
    @ExpressionLengthRestriction(rangeContent = "0..5000")
    private String reason;

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public String getReason() {
        return this.reason;
    }


    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setReason(String reason) {
        this.reason = reason;
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
        FailImpl other = (FailImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

