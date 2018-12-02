package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getifaddress.GetIfAddressOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.PortsConfigNodes;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.PortConfigOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getalldevice.GetAllDeviceOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.SnmpAuthProtocolType;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getnodenni.GetNodeNniInput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getcontrollers.GetControllersOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getrouterid.GetRouterIdOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getdevicemodelbynodeid.GetDeviceModelByNodeIdInput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.setdeviceauthenticationresult.SetDeviceAuthenticationResultOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getauthenticationdevices.GetAuthenticationDevicesOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.deletenodenni.DeleteNodeNniInput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getnodebgplurouteid.GetNodeBgpLuRouteIdInput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.setdeviceauthenticationresult.SetDeviceAuthenticationResultInput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.Snmpv3SecurityLevel;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getdevicenetconf.GetDeviceNetconfOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getconnect.GetConnectOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getifname.GetIfNameOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.updatedevices.UpdateDevicesOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getifaddress.GetIfAddressInput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getdevicemodelbydevicetype.GetDeviceModelByDeviceTypeInput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getnodenni.GetNodeNniOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getauthenticationdevices.GetAuthenticationDevicesInput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.addnodenni.AddNodeNniInput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.PortsConfigNodesImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.deletedevices.DeleteDevicesOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.deletedevices.DeleteDevicesInput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getdevicemodelbydevicetype.GetDeviceModelByDeviceTypeOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getdevicenetconf.GetDeviceNetconfInput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.AuthenticationStatus;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.DevicesImpl;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.Devices;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.updatedevices.UpdateDevicesInput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.DeviceRole;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getdevicemodelbynodeid.GetDeviceModelByNodeIdOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.ishcontroller.IsHcontrollerOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.adddevices.AddDevicesOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getifname.GetIfNameInput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.SnmpVersionType;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.adddevices.AddDevicesInput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getdevices.GetDevicesOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getcontrollers.GetControllersInput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.PortConfigInput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.NodeType;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.DeviceModel;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.synchronizedevice.SynchronizeDeviceInput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getrouterid.GetRouterIdInput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getdevices.GetDevicesInput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getnodebgplurouteid.GetNodeBgpLuRouteIdOutput;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.SnmpEncryProtocolType;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getconnect.GetConnectInput;

public class IpsdnDeviceManagerImpl implements IpsdnDeviceManager {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Column
    private Integer yangVersion = 1;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = PortsConfigNodesImpl.class)
    private PortsConfigNodes portsConfigNodes = new PortsConfigNodesImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = DevicesImpl.class)
    private Devices devices = new DevicesImpl();

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public GetDeviceNetconfOutput getDeviceNetconf(GetDeviceNetconfInput input) {
        //TODO::rpc implements
        return null;
    }

    @Override
    public void synchronizeDevice(SynchronizeDeviceInput input) {
        //TODO::rpc implements
    }

    @Override
    public PortsConfigNodes getPortsConfigNodes() {
        return this.portsConfigNodes;
    }


    @Override
    public Devices getDevices() {
        return this.devices;
    }


    @Override
    public AddDevicesOutput addDevices(AddDevicesInput input) {
        //TODO::rpc implements
        return null;
    }

    @Override
    public GetIfAddressOutput getIfAddress(GetIfAddressInput input) {
        //TODO::rpc implements
        return null;
    }

    @Override
    public UpdateDevicesOutput updateDevices(UpdateDevicesInput input) {
        //TODO::rpc implements
        return null;
    }

    @Override
    public DeleteDevicesOutput deleteDevices(DeleteDevicesInput input) {
        //TODO::rpc implements
        return null;
    }

    @Override
    public SetDeviceAuthenticationResultOutput setDeviceAuthenticationResult(SetDeviceAuthenticationResultInput input) {
        //TODO::rpc implements
        return null;
    }

    @Override
    public GetAuthenticationDevicesOutput getAuthenticationDevices(GetAuthenticationDevicesInput input) {
        //TODO::rpc implements
        return null;
    }

    @Override
    public GetConnectOutput getConnect(GetConnectInput input) {
        //TODO::rpc implements
        return null;
    }

    @Override
    public GetRouterIdOutput getRouterId(GetRouterIdInput input) {
        //TODO::rpc implements
        return null;
    }

    @Override
    public GetDeviceModelByNodeIdOutput getDeviceModelByNodeId(GetDeviceModelByNodeIdInput input) {
        //TODO::rpc implements
        return null;
    }

    @Override
    public GetDeviceModelByDeviceTypeOutput getDeviceModelByDeviceType(GetDeviceModelByDeviceTypeInput input) {
        //TODO::rpc implements
        return null;
    }

    @Override
    public void addNodeNni(AddNodeNniInput input) {
        //TODO::rpc implements
    }

    @Override
    public void deleteNodeNni(DeleteNodeNniInput input) {
        //TODO::rpc implements
    }

    @Override
    public GetNodeNniOutput getNodeNni(GetNodeNniInput input) {
        //TODO::rpc implements
        return null;
    }

    @Override
    public IsHcontrollerOutput isHcontroller() {
        //TODO::rpc implements
        return null;
    }

    @Override
    public GetDevicesOutput getDevices(GetDevicesInput input) {
        //TODO::rpc implements
        return null;
    }

    @Override
    public GetControllersOutput getControllers(GetControllersInput input) {
        //TODO::rpc implements
        return null;
    }

    @Override
    public GetAllDeviceOutput getAllDevice() {
        //TODO::rpc implements
        return null;
    }

    @Override
    public GetIfNameOutput getIfName(GetIfNameInput input) {
        //TODO::rpc implements
        return null;
    }

    @Override
    public PortConfigOutput portConfig(PortConfigInput input) {
        //TODO::rpc implements
        return null;
    }

    @Override
    public GetNodeBgpLuRouteIdOutput getNodeBgpLuRouteId(GetNodeBgpLuRouteIdInput input) {
        //TODO::rpc implements
        return null;
    }

    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setPortsConfigNodes(PortsConfigNodes portsConfigNodes) {
        this.portsConfigNodes = portsConfigNodes;
    }

    @Override
    public void setDevices(Devices devices) {
        this.devices = devices;
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
        IpsdnDeviceManagerImpl other = (IpsdnDeviceManagerImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

