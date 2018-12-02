package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result.success.ports.accesstype.vlanrange;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.VlanBitmapImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.VlanBitmap;

public class VlanRangeImpl implements VlanRange {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "Vlan Bitmap."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = VlanBitmapImpl.class)
    private VlanBitmap vlanBegin = new VlanBitmapImpl();

    /**
     * "Vlan Bitmap."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = VlanBitmapImpl.class)
    private VlanBitmap vlanEnd = new VlanBitmapImpl();

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public VlanBitmap getVlanBegin() {
        return this.vlanBegin;
    }


    @Override
    public VlanBitmap getVlanEnd() {
        return this.vlanEnd;
    }


    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setVlanBegin(VlanBitmap vlanBegin) {
        this.vlanBegin = vlanBegin;
    }

    @Override
    public void setVlanEnd(VlanBitmap vlanEnd) {
        this.vlanEnd = vlanEnd;
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
        VlanRangeImpl other = (VlanRangeImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

