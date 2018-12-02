package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.updatedevices.updatedevicesinput;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.updatedevices.updatedevicesinput.updatingdevice.Nni;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.DeviceModelImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeId;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.updatedevices.updatedevicesinput.updatingdevice.NetconfConnectionImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.NodeTypeImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.updatedevices.updatedevicesinput.updatingdevice.BgpConnection;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.updatedevices.updatedevicesinput.updatingdevice.RestconfConnectionImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.updatedevices.updatedevicesinput.updatingdevice.PcepConnection;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.updatedevices.updatedevicesinput.updatingdevice.CliConnection;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.updatedevices.updatedevicesinput.updatingdevice.SnmpConnection;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.DeviceRoleImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.updatedevices.updatedevicesinput.updatingdevice.NniImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.updatedevices.updatedevicesinput.updatingdevice.PcepConnectionImpl;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.updatedevices.updatedevicesinput.updatingdevice.BgpConnectionImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeIdImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.DeviceRole;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.updatedevices.updatedevicesinput.updatingdevice.CliConnectionImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.updatedevices.updatedevicesinput.updatingdevice.SnmpConnectionImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.updatedevices.updatedevicesinput.updatingdevice.RestconfConnection;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.updatedevices.updatedevicesinput.updatingdevice.VendorEnum;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddress;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.NodeType;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.DeviceModel;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.updatedevices.updatedevicesinput.updatingdevice.NetconfConnection;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddressImpl;

public class UpdatingDeviceImpl implements UpdatingDevice {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "English:The nodeid of the device (mac).
                         ä¸­æ–‡ï¼šè®¾å¤‡èŠ‚ç‚¹æè¿°ä¿¡æ¯ã€‚"
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = NodeIdImpl.class)
    private NodeId nodeId = new NodeIdImpl();

    /**
     * "The node type of the device in network."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = NodeTypeImpl.class)
    private NodeType nodeType = new NodeTypeImpl();

    /**
     * "The protocol nodeid of the device."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = NodeIdImpl.class)
    private NodeId protocolNodeId = new NodeIdImpl();

    /**
     * "The ip of the device(most ip of loopback1)."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = IpAddressImpl.class)
    private IpAddress routerId = new IpAddressImpl();

    /**
     * "The ip for bgplu."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = IpAddressImpl.class)
    private IpAddress bgpluRouterId = new IpAddressImpl();

    /**
     * "The vendor of the device."
    */
    private VendorEnum vendor;
    private int vendorValue;

    /**
     * "The vendor of the device."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = DeviceRoleImpl.class)
    private DeviceRole deviceRole = new DeviceRoleImpl();

    /**
     * "The type of the device."
    */
    @Column(displaySize = 10)
    private String deviceType;

    /**
     * "The type of the device."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = DeviceModelImpl.class)
    private DeviceModel deviceModel = new DeviceModelImpl();

    /**
     * "The description of the device."
    */
    @Column(displaySize = 10)
    private String deviceDescription;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = PcepConnectionImpl.class)
    private PcepConnection pcepConnection = new PcepConnectionImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = BgpConnectionImpl.class)
    private BgpConnection bgpConnection = new BgpConnectionImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = RestconfConnectionImpl.class)
    private RestconfConnection restconfConnection = new RestconfConnectionImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = NetconfConnectionImpl.class)
    private NetconfConnection netconfConnection = new NetconfConnectionImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = SnmpConnectionImpl.class)
    private SnmpConnection snmpConnection = new SnmpConnectionImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = CliConnectionImpl.class)
    private CliConnection cliConnection = new CliConnectionImpl();

    /**
     * "The nni-cfg of the device."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = NniImpl.class)
    private Nni nni = new NniImpl();

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public NodeId getNodeId() {
        return this.nodeId;
    }


    @Override
    public NodeType getNodeType() {
        return this.nodeType;
    }


    @Override
    public NodeId getProtocolNodeId() {
        return this.protocolNodeId;
    }


    @Override
    public IpAddress getRouterId() {
        return this.routerId;
    }


    @Override
    public IpAddress getBgpluRouterId() {
        return this.bgpluRouterId;
    }


    @Override
    public VendorEnum getVendor() {
        this.vendor =  VendorEnum.of(vendorValue);
        return this.vendor;
    }


    @Override
    public DeviceRole getDeviceRole() {
        return this.deviceRole;
    }


    @Override
    public String getDeviceType() {
        return this.deviceType;
    }


    @Override
    public DeviceModel getDeviceModel() {
        return this.deviceModel;
    }


    @Override
    public String getDeviceDescription() {
        return this.deviceDescription;
    }


    @Override
    public PcepConnection getPcepConnection() {
        return this.pcepConnection;
    }


    @Override
    public BgpConnection getBgpConnection() {
        return this.bgpConnection;
    }


    @Override
    public RestconfConnection getRestconfConnection() {
        return this.restconfConnection;
    }


    @Override
    public NetconfConnection getNetconfConnection() {
        return this.netconfConnection;
    }


    @Override
    public SnmpConnection getSnmpConnection() {
        return this.snmpConnection;
    }


    @Override
    public CliConnection getCliConnection() {
        return this.cliConnection;
    }


    @Override
    public Nni getNni() {
        return this.nni;
    }


    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setNodeId(NodeId nodeId) {
        this.nodeId = nodeId;
    }

    @Override
    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }

    @Override
    public void setProtocolNodeId(NodeId protocolNodeId) {
        this.protocolNodeId = protocolNodeId;
    }

    @Override
    public void setRouterId(IpAddress routerId) {
        this.routerId = routerId;
    }

    @Override
    public void setBgpluRouterId(IpAddress bgpluRouterId) {
        this.bgpluRouterId = bgpluRouterId;
    }

    @Override
    public void setVendor(VendorEnum vendor) {
        this.vendor = vendor;
        this.vendorValue =  vendor.getVendorEnum();
    }

    @Override
    public void setDeviceRole(DeviceRole deviceRole) {
        this.deviceRole = deviceRole;
    }

    @Override
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    @Override
    public void setDeviceModel(DeviceModel deviceModel) {
        this.deviceModel = deviceModel;
    }

    @Override
    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription = deviceDescription;
    }

    @Override
    public void setPcepConnection(PcepConnection pcepConnection) {
        this.pcepConnection = pcepConnection;
    }

    @Override
    public void setBgpConnection(BgpConnection bgpConnection) {
        this.bgpConnection = bgpConnection;
    }

    @Override
    public void setRestconfConnection(RestconfConnection restconfConnection) {
        this.restconfConnection = restconfConnection;
    }

    @Override
    public void setNetconfConnection(NetconfConnection netconfConnection) {
        this.netconfConnection = netconfConnection;
    }

    @Override
    public void setSnmpConnection(SnmpConnection snmpConnection) {
        this.snmpConnection = snmpConnection;
    }

    @Override
    public void setCliConnection(CliConnection cliConnection) {
        this.cliConnection = cliConnection;
    }

    @Override
    public void setNni(Nni nni) {
        this.nni = nni;
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
        UpdatingDeviceImpl other = (UpdatingDeviceImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

