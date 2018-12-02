package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.SupportType;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.Nodes;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeId;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeConnectorId;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodesImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeConnectorRef;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeRef;

public class OpendaylightInventoryImpl implements OpendaylightInventory {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    public static final String YangVersion = "YangVersion";
    @Column(displaySize = 10)
    private String yangVersion = "1";

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = NodesImpl.class)
    private Nodes nodes = new NodesImpl();

    public static final String ParentPath = "ParentPath";
    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public Nodes getNodes() {
        return this.nodes;
        }


    @Override
    public String getParentPath() {
        return this.parentPath;
        }



    @Override
    public void setNodes(Nodes nodes) {
        this.nodes = nodes;
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
        OpendaylightInventoryImpl other = (OpendaylightInventoryImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

