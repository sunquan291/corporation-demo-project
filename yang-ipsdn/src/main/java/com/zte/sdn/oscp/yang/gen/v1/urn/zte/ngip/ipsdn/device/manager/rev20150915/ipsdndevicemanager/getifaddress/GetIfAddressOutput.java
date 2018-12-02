package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getifaddress;

import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddress;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddressImpl;

public class GetIfAddressOutput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "The ip of the interface get from inv."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = IpAddressImpl.class)
    private IpAddress ifIp = new IpAddressImpl();


    public IpAddress getIfIp() {
        return this.ifIp;
    }



    public void setIfIp(IpAddress ifIp) {
        this.ifIp = ifIp;
    }



}

