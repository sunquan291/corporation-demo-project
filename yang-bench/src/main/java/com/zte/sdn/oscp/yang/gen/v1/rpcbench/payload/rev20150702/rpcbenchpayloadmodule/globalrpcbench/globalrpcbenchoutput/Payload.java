package com.zte.sdn.oscp.yang.gen.v1.rpcbench.payload.rev20150702.rpcbenchpayloadmodule.globalrpcbench.globalrpcbenchoutput;

import com.zte.sdn.oscp.persistence.annotations.Table;

    /**
     * "The input and output payload for the RPC Benchmark's Global RPC Server (a list of integers)"
    */
@Table
public interface Payload {

    Integer getId();

    String getParentPath();


    /**
     *
     * @param id 
    */
    void setId(Integer id);

    void setParentPath(String parentPath);


}

