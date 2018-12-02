package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result.success;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.PortType;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result.success.ports.accesstype.Port;
import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.Ipv4Address;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result.success.ports.VlanAttribute;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result.success.ports.AccessType;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result.success.ports.accesstype.Qinq;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result.success.ports.accesstype.Dot1q;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result.success.ports.accesstype.Vlanrange;

@Table
public interface Ports {

    /**
     * "The port name of the node, eg: fei-0/1/0/1.1, tunnel1, loopback1"
     * @return 
    */
    String getName();

    /**
     * "parent port name, eg: fei-0/1/0/1"
     * @return 
    */
    String getIfName();

    /**
     * "vlan or loopback"
     * @return 
    */
    PortType getPortType();

    /**
     * "The ipv4 address of the interface."
     * @return 
    */
    Ipv4Address getIpv4Address();

    /**
     * "The ipv4 mask of the interface."
     * @return 
    */
    Ipv4Address getIpv4Mask();

    /**
     * "The vrf name of the node."
     * @return 
    */
    String getVrfName();

    Boolean getOnlyConfigL2();

    Port getPort();

    Dot1q getDot1q();

    Qinq getQinq();

    Vlanrange getVlanrange();

    VlanAttribute getVlanAttribute();

    String getParentPath();


    /**
     * "The port name of the node, eg: fei-0/1/0/1.1, tunnel1, loopback1"
     * @param name 
    */
    void setName(String name);

    /**
     * "parent port name, eg: fei-0/1/0/1"
     * @param ifName 
    */
    void setIfName(String ifName);

    /**
     * "vlan or loopback"
     * @param portType 
    */
    void setPortType(PortType portType);

    /**
     * "The ipv4 address of the interface."
     * @param ipv4Address 
    */
    void setIpv4Address(Ipv4Address ipv4Address);

    /**
     * "The ipv4 mask of the interface."
     * @param ipv4Mask 
    */
    void setIpv4Mask(Ipv4Address ipv4Mask);

    /**
     * "The vrf name of the node."
     * @param vrfName 
    */
    void setVrfName(String vrfName);

    /**
     *
     * @param onlyConfigL2 
    */
    void setOnlyConfigL2(Boolean onlyConfigL2);

    void setPort(Port Port);

    void setDot1q(Dot1q Dot1q);

    void setQinq(Qinq Qinq);

    void setVlanrange(Vlanrange Vlanrange);

    void setVlanAttribute(VlanAttribute vlanAttribute);

    void setParentPath(String parentPath);


}

