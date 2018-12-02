package com.zte.sdn.oscp.yang.gen.v1.rpcbench.payload.rev20150702;

import com.zte.sdn.oscp.yang.gen.v1.rpcbench.payload.rev20150702.rpcbenchpayloadmodule.routedrpcbench.RoutedRpcBenchInput;
import com.zte.sdn.oscp.yang.gen.v1.rpcbench.payload.rev20150702.rpcbenchpayloadmodule.RpcbenchRpcRoutes;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.rpcbench.payload.rev20150702.rpcbenchpayloadmodule.routedrpcbench.RoutedRpcBenchOutput;
import com.zte.sdn.oscp.yang.gen.v1.rpcbench.payload.rev20150702.rpcbenchpayloadmodule.globalrpcbench.GlobalRpcBenchOutput;
import com.zte.sdn.oscp.yang.gen.v1.rpcbench.payload.rev20150702.rpcbenchpayloadmodule.globalrpcbench.GlobalRpcBenchInput;
import com.zte.sdn.oscp.yang.gen.v1.rpcbench.payload.rev20150702.rpcbenchpayloadmodule.RpcbenchRpcRoutesImpl;

public class RpcbenchPayloadModuleImpl implements RpcbenchPayloadModule {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Column
    private Integer yangVersion = 1;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = RpcbenchRpcRoutesImpl.class)
    private RpcbenchRpcRoutes rpcbenchRpcRoutes = new RpcbenchRpcRoutesImpl();

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public GlobalRpcBenchOutput globalRpcBench(GlobalRpcBenchInput input) {
        //TODO::rpc implements
        return null;
    }

    @Override
    public RoutedRpcBenchOutput routedRpcBench(RoutedRpcBenchInput input) {
        //TODO::rpc implements
        return null;
    }

    @Override
    public RpcbenchRpcRoutes getRpcbenchRpcRoutes() {
        return this.rpcbenchRpcRoutes;
    }


    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setRpcbenchRpcRoutes(RpcbenchRpcRoutes rpcbenchRpcRoutes) {
        this.rpcbenchRpcRoutes = rpcbenchRpcRoutes;
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
        RpcbenchPayloadModuleImpl other = (RpcbenchPayloadModuleImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

