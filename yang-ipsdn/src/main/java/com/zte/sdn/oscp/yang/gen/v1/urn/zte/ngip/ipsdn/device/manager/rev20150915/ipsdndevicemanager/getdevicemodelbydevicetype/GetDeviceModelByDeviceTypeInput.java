package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getdevicemodelbydevicetype;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;

public class GetDeviceModelByDeviceTypeInput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "The type of the device."
    */
    @Column(displaySize = 10)
    private String deviceType;


    public String getDeviceType() {
        return this.deviceType;
    }



    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }



}

