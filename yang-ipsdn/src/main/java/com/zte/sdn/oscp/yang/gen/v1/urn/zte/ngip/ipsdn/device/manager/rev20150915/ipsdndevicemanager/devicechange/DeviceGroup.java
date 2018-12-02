package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devicechange;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devicechange.devicegroup.CliConnection;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.DeviceRole;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeId;
import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devicechange.devicegroup.NetconfConnection;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devicechange.devicegroup.BgpConnection;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devicechange.devicegroup.SnmpConnection;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddress;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.NodeType;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.DeviceModel;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devicechange.devicegroup.RestconfConnection;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devicechange.devicegroup.VendorEnum;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devicechange.devicegroup.PcepConnection;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devicechange.devicegroup.Nni;

@Table
public interface DeviceGroup {

    /**
     * "English:The nodeid of the device (mac).
                         ä¸­æ–‡ï¼šè®¾å¤‡èŠ‚ç‚¹æè¿°ä¿¡æ¯ã€‚"
     * @return 
    */
    NodeId getNodeId();

    /**
     * "The node type of the device in network."
     * @return 
    */
    NodeType getNodeType();

    /**
     * "The protocol nodeid of the device."
     * @return 
    */
    NodeId getProtocolNodeId();

    /**
     * "The ip of the device(most ip of loopback1)."
     * @return 
    */
    IpAddress getRouterId();

    /**
     * "The ip for bgplu."
     * @return 
    */
    IpAddress getBgpluRouterId();

    /**
     * "The vendor of the device."
     * @return 
    */
    VendorEnum getVendor();

    /**
     * "The vendor of the device."
     * @return 
    */
    DeviceRole getDeviceRole();

    /**
     * "The type of the device."
     * @return 
    */
    String getDeviceType();

    /**
     * "The type of the device."
     * @return 
    */
    DeviceModel getDeviceModel();

    /**
     * "The description of the device."
     * @return 
    */
    String getDeviceDescription();

    PcepConnection getPcepConnection();

    BgpConnection getBgpConnection();

    RestconfConnection getRestconfConnection();

    NetconfConnection getNetconfConnection();

    SnmpConnection getSnmpConnection();

    CliConnection getCliConnection();

    Nni getNni();

    String getParentPath();


    /**
     * "English:The nodeid of the device (mac).
                         ä¸­æ–‡ï¼šè®¾å¤‡èŠ‚ç‚¹æè¿°ä¿¡æ¯ã€‚"
     * @param nodeId 
    */
    void setNodeId(NodeId nodeId);

    /**
     * "The node type of the device in network."
     * @param nodeType 
    */
    void setNodeType(NodeType nodeType);

    /**
     * "The protocol nodeid of the device."
     * @param protocolNodeId 
    */
    void setProtocolNodeId(NodeId protocolNodeId);

    /**
     * "The ip of the device(most ip of loopback1)."
     * @param routerId 
    */
    void setRouterId(IpAddress routerId);

    /**
     * "The ip for bgplu."
     * @param bgpluRouterId 
    */
    void setBgpluRouterId(IpAddress bgpluRouterId);

    /**
     * "The vendor of the device."
     * @param vendor 
    */
    void setVendor(VendorEnum vendor);

    /**
     * "The vendor of the device."
     * @param deviceRole 
    */
    void setDeviceRole(DeviceRole deviceRole);

    /**
     * "The type of the device."
     * @param deviceType 
    */
    void setDeviceType(String deviceType);

    /**
     * "The type of the device."
     * @param deviceModel 
    */
    void setDeviceModel(DeviceModel deviceModel);

    /**
     * "The description of the device."
     * @param deviceDescription 
    */
    void setDeviceDescription(String deviceDescription);

    void setPcepConnection(PcepConnection pcepConnection);

    void setBgpConnection(BgpConnection bgpConnection);

    void setRestconfConnection(RestconfConnection restconfConnection);

    void setNetconfConnection(NetconfConnection netconfConnection);

    void setSnmpConnection(SnmpConnection snmpConnection);

    void setCliConnection(CliConnection cliConnection);

    void setNni(Nni nni);

    void setParentPath(String parentPath);


}

