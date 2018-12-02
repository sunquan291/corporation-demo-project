package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.setdeviceauthenticationresult.setdeviceauthenticationresultoutput;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeId;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeIdImpl;

public class NodesImpl implements Nodes {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = NodeIdImpl.class)
    private NodeId nodeId = new NodeIdImpl();

    @Column(displaySize = 10)
    private String serialId;

    @Column
    private Long errorCode;

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public NodeId getNodeId() {
        return this.nodeId;
    }


    @Override
    public String getSerialId() {
        return this.serialId;
    }


    @Override
    public Long getErrorCode() {
        return this.errorCode;
    }


    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setNodeId(NodeId nodeId) {
        this.nodeId = nodeId;
    }

    @Override
    public void setSerialId(String serialId) {
        this.serialId = serialId;
    }

    @Override
    public void setErrorCode(Long errorCode) {
        this.errorCode = errorCode;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = Long.parseLong(errorCode);
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
        NodesImpl other = (NodesImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

