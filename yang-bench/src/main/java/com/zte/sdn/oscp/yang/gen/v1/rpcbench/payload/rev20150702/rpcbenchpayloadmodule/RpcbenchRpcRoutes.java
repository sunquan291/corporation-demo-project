package com.zte.sdn.oscp.yang.gen.v1.rpcbench.payload.rev20150702.rpcbenchpayloadmodule;

import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.rpcbench.payload.rev20150702.rpcbenchpayloadmodule.rpcbenchrpcroutes.RpcRoute;
import java.util.Set;

@Table
public interface RpcbenchRpcRoutes {

    Set<RpcRoute> getRpcRoute();

    //RpcRoute getFromRpcRoute(String key);
    RpcRoute getFromRpcRoute(String id);
    String getParentPath();


    void  setRpcRoute(Set<RpcRoute> rpcRoute);

    void setParentPath(String parentPath);


    void addToRpcRoute(RpcRoute addTo);



    void removeFromRpcRoute(String id);

}

