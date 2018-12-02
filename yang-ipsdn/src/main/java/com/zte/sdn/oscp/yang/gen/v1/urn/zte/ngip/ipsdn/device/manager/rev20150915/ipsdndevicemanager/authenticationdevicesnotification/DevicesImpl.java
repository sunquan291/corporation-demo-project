package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.authenticationdevicesnotification;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;

public class DevicesImpl implements Devices {

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

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public String getSerialId() {
        return this.serialId;
    }


    @Override
    public String getNeType() {
        return this.neType;
    }


    @Override
    public String getIpAddress() {
        return this.ipAddress;
    }


    @Override
    public String getMac() {
        return this.mac;
    }


    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setSerialId(String serialId) {
        this.serialId = serialId;
    }

    @Override
    public void setNeType(String neType) {
        this.neType = neType;
    }

    @Override
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public void setMac(String mac) {
        this.mac = mac;
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
        DevicesImpl other = (DevicesImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

