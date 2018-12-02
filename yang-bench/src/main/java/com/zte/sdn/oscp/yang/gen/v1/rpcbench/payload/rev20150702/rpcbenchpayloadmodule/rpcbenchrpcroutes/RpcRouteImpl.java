package com.zte.sdn.oscp.yang.gen.v1.rpcbench.payload.rev20150702.rpcbenchpayloadmodule.rpcbenchrpcroutes;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;

public class RpcRouteImpl implements RpcRoute {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Column(displaySize = 10)
    private String id;

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public String getId() {
        return this.id;
    }


    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setId(String id) {
        this.id = id;
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
        RpcRouteImpl other = (RpcRouteImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

