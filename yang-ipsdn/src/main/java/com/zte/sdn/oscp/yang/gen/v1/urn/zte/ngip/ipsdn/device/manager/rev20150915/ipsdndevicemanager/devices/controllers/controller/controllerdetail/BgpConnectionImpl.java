package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.controllers.controller.controllerdetail;

import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddress;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddressImpl;

public class BgpConnectionImpl implements BgpConnection {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "The local-as of the connection."
    */
    @Column(displaySize = 10)
    private String localAs;

    /**
     * "The local-ip of the connection."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = IpAddressImpl.class)
    private IpAddress localIp = new IpAddressImpl();

    /**
     * "The remote-ip of the connection."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = IpAddressImpl.class)
    private IpAddress remoteIp = new IpAddressImpl();

    /**
     * "The remote-as of the connection."
    */
    @Column(displaySize = 10)
    private String remoteAs;

    /**
     * "support bgp ls capacity."
    */
    @Column
    private Boolean bgpLsEnable;

    /**
     * "support bgp fs capacity."
    */
    @Column
    private Boolean bgpFsEnable;

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public String getLocalAs() {
        return this.localAs;
    }


    @Override
    public IpAddress getLocalIp() {
        return this.localIp;
    }


    @Override
    public IpAddress getRemoteIp() {
        return this.remoteIp;
    }


    @Override
    public String getRemoteAs() {
        return this.remoteAs;
    }


    @Override
    public Boolean getBgpLsEnable() {
        return this.bgpLsEnable;
    }


    @Override
    public Boolean getBgpFsEnable() {
        return this.bgpFsEnable;
    }


    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setLocalAs(String localAs) {
        this.localAs = localAs;
    }

    @Override
    public void setLocalIp(IpAddress localIp) {
        this.localIp = localIp;
    }

    @Override
    public void setRemoteIp(IpAddress remoteIp) {
        this.remoteIp = remoteIp;
    }

    @Override
    public void setRemoteAs(String remoteAs) {
        this.remoteAs = remoteAs;
    }

    @Override
    public void setBgpLsEnable(Boolean bgpLsEnable) {
        this.bgpLsEnable = bgpLsEnable;
    }
    public void setBgpLsEnable(String bgpLsEnable) {
        this.bgpLsEnable = Boolean.parseBoolean(bgpLsEnable);
    }

    @Override
    public void setBgpFsEnable(Boolean bgpFsEnable) {
        this.bgpFsEnable = bgpFsEnable;
    }
    public void setBgpFsEnable(String bgpFsEnable) {
        this.bgpFsEnable = Boolean.parseBoolean(bgpFsEnable);
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
        BgpConnectionImpl other = (BgpConnectionImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

