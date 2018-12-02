package com.zte.sdn.oscp.yang.gen.v1.rpcbench.payload.rev20150702;

import com.zte.sdn.oscp.yang.gen.v1.rpcbench.payload.rev20150702.rpcbenchpayloadmodule.routedrpcbench.RoutedRpcBenchInput;
import com.zte.sdn.oscp.yang.gen.v1.rpcbench.payload.rev20150702.rpcbenchpayloadmodule.RpcbenchRpcRoutes;
import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.rpcbench.payload.rev20150702.rpcbenchpayloadmodule.routedrpcbench.RoutedRpcBenchOutput;
import com.zte.sdn.oscp.yang.gen.v1.rpcbench.payload.rev20150702.rpcbenchpayloadmodule.globalrpcbench.GlobalRpcBenchOutput;
import com.zte.sdn.oscp.yang.gen.v1.rpcbench.payload.rev20150702.rpcbenchpayloadmodule.globalrpcbench.GlobalRpcBenchInput;

@Table
public interface RpcbenchPayloadModule {

    GlobalRpcBenchOutput globalRpcBench(GlobalRpcBenchInput input);

    RoutedRpcBenchOutput routedRpcBench(RoutedRpcBenchInput input);

    RpcbenchRpcRoutes getRpcbenchRpcRoutes();

    String getParentPath();


    void setRpcbenchRpcRoutes(RpcbenchRpcRoutes rpcbenchRpcRoutes);

    void setParentPath(String parentPath);


}

