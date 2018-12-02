package com.zte.sdn.oscp.yang.gen.v1.rpcbench.payload.rev20150702.rpcbenchpayloadmodule.rpcbenchrpcroutes;

import com.zte.sdn.oscp.persistence.annotations.Table;

    /**
     * "Routed RPC server context instances (i.e. instances to which RPC calls are routed)"
    */
@Table
public interface RpcRoute {

    String getId();

    String getParentPath();


    /**
     *
     * @param id 
    */
    void setId(String id);

    void setParentPath(String parentPath);


}

