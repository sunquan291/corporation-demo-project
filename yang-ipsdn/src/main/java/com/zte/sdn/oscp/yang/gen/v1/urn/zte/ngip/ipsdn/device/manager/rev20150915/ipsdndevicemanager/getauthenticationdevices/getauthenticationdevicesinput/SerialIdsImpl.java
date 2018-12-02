package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getauthenticationdevices.getauthenticationdevicesinput;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;

public class SerialIdsImpl implements SerialIds {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Column(displaySize = 10)
    private String serialId;

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public String getSerialId() {
        return this.serialId;
    }


    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setSerialId(String serialId) {
        this.serialId = serialId;
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
        SerialIdsImpl other = (SerialIdsImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

