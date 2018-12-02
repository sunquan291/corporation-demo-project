package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getdevices.getdevicesoutput.deviceinfo;

import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddress;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddressImpl;

public class NniImpl implements Nni {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "The nni-ip of the node."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = IpAddressImpl.class)
    private IpAddress nniIp = new IpAddressImpl();

    /**
     * "The nni-port name of the node."
    */
    @Column(displaySize = 10)
    private String ifName;

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public IpAddress getNniIp() {
        return this.nniIp;
    }


    @Override
    public String getIfName() {
        return this.ifName;
    }


    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setNniIp(IpAddress nniIp) {
        this.nniIp = nniIp;
    }

    @Override
    public void setIfName(String ifName) {
        this.ifName = ifName;
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
        NniImpl other = (NniImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

