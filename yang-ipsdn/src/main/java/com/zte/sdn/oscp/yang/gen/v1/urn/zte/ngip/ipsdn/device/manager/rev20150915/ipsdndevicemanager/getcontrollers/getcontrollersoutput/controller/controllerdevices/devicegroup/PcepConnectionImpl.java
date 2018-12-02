package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getcontrollers.getcontrollersoutput.controller.controllerdevices.devicegroup;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.Ipv4Address;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.Ipv4AddressImpl;

public class PcepConnectionImpl implements PcepConnection {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "=
                A ip address is specified for whitch D-controller
                is a PCE for added device .
            "
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = Ipv4AddressImpl.class)
    private Ipv4Address pcepPeerIp = new Ipv4AddressImpl();

    /**
     * "=
                A ip address on added device ,whitch is a PCC.
                this device use the ip address connection to PCE
            "
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = Ipv4AddressImpl.class)
    private Ipv4Address pcepRouterId = new Ipv4AddressImpl();

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public Ipv4Address getPcepPeerIp() {
        return this.pcepPeerIp;
    }


    @Override
    public Ipv4Address getPcepRouterId() {
        return this.pcepRouterId;
    }


    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setPcepPeerIp(Ipv4Address pcepPeerIp) {
        this.pcepPeerIp = pcepPeerIp;
    }

    @Override
    public void setPcepRouterId(Ipv4Address pcepRouterId) {
        this.pcepRouterId = pcepRouterId;
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
        PcepConnectionImpl other = (PcepConnectionImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

