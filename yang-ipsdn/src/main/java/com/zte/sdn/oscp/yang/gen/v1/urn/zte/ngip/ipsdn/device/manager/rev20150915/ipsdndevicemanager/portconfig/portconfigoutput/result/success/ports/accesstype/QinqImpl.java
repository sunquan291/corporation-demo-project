package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result.success.ports.accesstype;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.VlanBitmapImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.VlanBitmap;

public class QinqImpl implements Qinq {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "QinQ internal vlan bitmap."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = VlanBitmapImpl.class)
    private VlanBitmap qinqInternalVlanBitmap = new VlanBitmapImpl();

    /**
     * "QinQ external vlan bitmap."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = VlanBitmapImpl.class)
    private VlanBitmap qinqExternalVlanBitmap = new VlanBitmapImpl();

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public VlanBitmap getQinqInternalVlanBitmap() {
        return this.qinqInternalVlanBitmap;
    }


    @Override
    public VlanBitmap getQinqExternalVlanBitmap() {
        return this.qinqExternalVlanBitmap;
    }


    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setQinqInternalVlanBitmap(VlanBitmap qinqInternalVlanBitmap) {
        this.qinqInternalVlanBitmap = qinqInternalVlanBitmap;
    }

    @Override
    public void setQinqExternalVlanBitmap(VlanBitmap qinqExternalVlanBitmap) {
        this.qinqExternalVlanBitmap = qinqExternalVlanBitmap;
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
        QinqImpl other = (QinqImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

