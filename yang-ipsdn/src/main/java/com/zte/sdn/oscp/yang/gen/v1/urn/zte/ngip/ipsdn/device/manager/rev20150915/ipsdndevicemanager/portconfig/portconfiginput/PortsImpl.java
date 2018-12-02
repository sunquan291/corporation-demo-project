package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfiginput;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfiginput.ports.VlanAttributeImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfiginput.ports.AccessType;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfiginput.ports.VlanAttribute;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.PortTypeImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfiginput.ports.accesstype.Vlanrange;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfiginput.ports.accesstype.Port;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfiginput.ports.accesstype.PortImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.Ipv4Address;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfiginput.ports.accesstype.Qinq;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.PortType;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfiginput.ports.accesstype.VlanrangeImpl;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfiginput.ports.accesstype.Dot1qImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfiginput.ports.accesstype.QinqImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.Ipv4AddressImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfiginput.ports.accesstype.Dot1q;

public class PortsImpl implements Ports {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "The port name of the node, eg: fei-0/1/0/1.1, tunnel1, loopback1"
    */
    @Column(displaySize = 10,isPrimaryKey = true)
    private String name;

    /**
     * "parent port name, eg: fei-0/1/0/1"
    */
    @Column(displaySize = 10)
    private String ifName;

    /**
     * "vlan or loopback"
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = PortTypeImpl.class)
    private PortType portType = new PortTypeImpl();

    /**
     * "The ipv4 address of the interface."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = Ipv4AddressImpl.class)
    private Ipv4Address ipv4Address = new Ipv4AddressImpl();

    /**
     * "The ipv4 mask of the interface."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = Ipv4AddressImpl.class)
    private Ipv4Address ipv4Mask = new Ipv4AddressImpl();

    /**
     * "The vrf name of the node."
    */
    @Column(displaySize = 10)
    private String vrfName;

    @Column
    private Boolean onlyConfigL2 = true;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = PortImpl.class)
    private Port Port = new PortImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = Dot1qImpl.class)
    private Dot1q Dot1q = new Dot1qImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = QinqImpl.class)
    private Qinq Qinq = new QinqImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = VlanrangeImpl.class)
    private Vlanrange Vlanrange = new VlanrangeImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = VlanAttributeImpl.class)
    private VlanAttribute vlanAttribute = new VlanAttributeImpl();

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public String getName() {
        return this.name;
    }


    @Override
    public String getIfName() {
        return this.ifName;
    }


    @Override
    public PortType getPortType() {
        return this.portType;
    }


    @Override
    public Ipv4Address getIpv4Address() {
        return this.ipv4Address;
    }


    @Override
    public Ipv4Address getIpv4Mask() {
        return this.ipv4Mask;
    }


    @Override
    public String getVrfName() {
        return this.vrfName;
    }


    @Override
    public Boolean getOnlyConfigL2() {
        return this.onlyConfigL2;
    }


    @Override
    public Port getPort() {
        return this.Port;
    }


    @Override
    public Dot1q getDot1q() {
        return this.Dot1q;
    }


    @Override
    public Qinq getQinq() {
        return this.Qinq;
    }


    @Override
    public Vlanrange getVlanrange() {
        return this.Vlanrange;
    }


    @Override
    public VlanAttribute getVlanAttribute() {
        return this.vlanAttribute;
    }


    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setIfName(String ifName) {
        this.ifName = ifName;
    }

    @Override
    public void setPortType(PortType portType) {
        this.portType = portType;
    }

    @Override
    public void setIpv4Address(Ipv4Address ipv4Address) {
        this.ipv4Address = ipv4Address;
    }

    @Override
    public void setIpv4Mask(Ipv4Address ipv4Mask) {
        this.ipv4Mask = ipv4Mask;
    }

    @Override
    public void setVrfName(String vrfName) {
        this.vrfName = vrfName;
    }

    @Override
    public void setOnlyConfigL2(Boolean onlyConfigL2) {
        this.onlyConfigL2 = onlyConfigL2;
    }
    public void setOnlyConfigL2(String onlyConfigL2) {
        this.onlyConfigL2 = Boolean.parseBoolean(onlyConfigL2);
    }

    @Override
    public void setPort(Port Port) {
        this.Port = Port;
    }

    @Override
    public void setDot1q(Dot1q Dot1q) {
        this.Dot1q = Dot1q;
    }

    @Override
    public void setQinq(Qinq Qinq) {
        this.Qinq = Qinq;
    }

    @Override
    public void setVlanrange(Vlanrange Vlanrange) {
        this.Vlanrange = Vlanrange;
    }

    @Override
    public void setVlanAttribute(VlanAttribute vlanAttribute) {
        this.vlanAttribute = vlanAttribute;
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
        PortsImpl other = (PortsImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

