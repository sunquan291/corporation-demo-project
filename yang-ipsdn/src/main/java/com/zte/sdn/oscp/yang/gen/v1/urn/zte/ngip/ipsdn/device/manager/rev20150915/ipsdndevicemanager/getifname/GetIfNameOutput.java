package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getifname;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;

public class GetIfNameOutput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "The nni-port name of the node."
    */
    @Column(displaySize = 10)
    private String ifName;


    public String getIfName() {
        return this.ifName;
    }



    public void setIfName(String ifName) {
        this.ifName = ifName;
    }



}

