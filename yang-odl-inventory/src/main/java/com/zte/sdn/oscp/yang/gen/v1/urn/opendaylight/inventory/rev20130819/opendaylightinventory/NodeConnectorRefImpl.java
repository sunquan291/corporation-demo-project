package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;

public class NodeConnectorRefImpl implements NodeConnectorRef {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    public static final String InstanceIdentifier = "InstanceIdentifier";
    @Column(displaySize = 10)
    private String instanceIdentifier;

    public static final String ParentPath = "ParentPath";
    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public String getInstanceIdentifier() {
        return this.instanceIdentifier;
        }


    @Override
    public String getParentPath() {
        return this.parentPath;
        }



    @Override
    public void setInstanceIdentifier(String instanceIdentifier) {
        this.instanceIdentifier = instanceIdentifier;
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
        NodeConnectorRefImpl other = (NodeConnectorRefImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

