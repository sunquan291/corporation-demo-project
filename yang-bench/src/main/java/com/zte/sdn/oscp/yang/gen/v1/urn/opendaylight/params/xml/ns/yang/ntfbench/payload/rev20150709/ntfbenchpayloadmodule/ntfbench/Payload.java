package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ntfbench.payload.rev20150709.ntfbenchpayloadmodule.ntfbench;

import com.zte.sdn.oscp.persistence.annotations.Table;

    /**
     * "The payload for the notification"
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

