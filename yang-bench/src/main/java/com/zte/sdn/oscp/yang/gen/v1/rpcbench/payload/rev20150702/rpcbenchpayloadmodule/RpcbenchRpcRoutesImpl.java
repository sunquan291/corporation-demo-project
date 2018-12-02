package com.zte.sdn.oscp.yang.gen.v1.rpcbench.payload.rev20150702.rpcbenchpayloadmodule;

import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.rpcbench.payload.rev20150702.rpcbenchpayloadmodule.rpcbenchrpcroutes.RpcRoute;
import com.zte.sdn.oscp.yang.gen.v1.rpcbench.payload.rev20150702.rpcbenchpayloadmodule.rpcbenchrpcroutes.RpcRouteImpl;
import java.util.Set;
import java.util.LinkedHashSet;

public class RpcbenchRpcRoutesImpl implements RpcbenchRpcRoutes {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "Routed RPC server context instances (i.e. instances to which RPC calls are routed)"
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =RpcRouteImpl.class, associateLoad = false, associateSave = false)
    private Set<RpcRoute> rpcRoute = new LinkedHashSet<RpcRoute>();

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public Set<RpcRoute> getRpcRoute() {
        return this.rpcRoute;
    }

    @Override
    public RpcRoute getFromRpcRoute(String id) {
        return this.rpcRoute.parallelStream().filter(value ->
                value.getId().equals(id))
                .findAny().orElse(null);
    }
    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setRpcRoute(Set<RpcRoute> rpcRoute) {
        this.rpcRoute = rpcRoute;
    }

    @Override
    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }


    public void addToRpcRoute(RpcRoute addTo) {
        rpcRoute.add(addTo);
    }


    @Override
    public void removeFromRpcRoute(String id) {
        this.rpcRoute.remove(getFromRpcRoute(id));
    }

    @Override
    public int hashCode() {
        return Objects.hash(primaryId,parentPath);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RpcbenchRpcRoutesImpl other = (RpcbenchRpcRoutesImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

