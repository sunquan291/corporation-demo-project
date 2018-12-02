package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getauthenticationdevices;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;

public class GetAuthenticationDevicesOutput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Column(displaySize = 10)
    private String serialId;

    @Column(displaySize = 10)
    private String neType;

    @Column(displaySize = 10)
    private String ipAddress;

    @Column(displaySize = 10)
    private String mac;


    public String getSerialId() {
        return this.serialId;
    }


    public String getNeType() {
        return this.neType;
    }


    public String getIpAddress() {
        return this.ipAddress;
    }


    public String getMac() {
        return this.mac;
    }



    public void setSerialId(String serialId) {
        this.serialId = serialId;
    }

    public void setNeType(String neType) {
        this.neType = neType;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }



}

