package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfiginput.ports.accesstype;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.VlanBitmapImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.VlanBitmap;

public class Dot1qImpl implements Dot1q {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "Dot1Q Vlan Bitmap. CRD"
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = VlanBitmapImpl.class)
    private VlanBitmap dot1QvlanBitmap = new VlanBitmapImpl();

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public VlanBitmap getDot1QvlanBitmap() {
        return this.dot1QvlanBitmap;
    }


    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setDot1QvlanBitmap(VlanBitmap dot1QvlanBitmap) {
        this.dot1QvlanBitmap = dot1QvlanBitmap;
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
        Dot1qImpl other = (Dot1qImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

