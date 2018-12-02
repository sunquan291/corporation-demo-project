package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portsconfignodes.nodeports.ports.vlanattribute;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.SwitchPortMode;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.SwitchPortModeImpl;

public class TagPortImpl implements TagPort {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Column(displaySize = 10)
    private String portName;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = SwitchPortModeImpl.class)
    private SwitchPortMode mode = new SwitchPortModeImpl();

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public String getPortName() {
        return this.portName;
    }


    @Override
    public SwitchPortMode getMode() {
        return this.mode;
    }


    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setPortName(String portName) {
        this.portName = portName;
    }

    @Override
    public void setMode(SwitchPortMode mode) {
        this.mode = mode;
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
        TagPortImpl other = (TagPortImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

