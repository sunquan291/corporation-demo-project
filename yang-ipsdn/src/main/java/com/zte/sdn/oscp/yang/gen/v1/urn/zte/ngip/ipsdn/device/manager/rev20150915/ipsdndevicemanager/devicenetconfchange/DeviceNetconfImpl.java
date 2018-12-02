package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devicenetconfchange;

import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddress;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeId;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.OperationTypeImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddressImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.OperationType;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeIdImpl;

public class DeviceNetconfImpl implements DeviceNetconf {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = OperationTypeImpl.class)
    private OperationType changeType = new OperationTypeImpl();

    /**
     * "The nodeid of the device."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = NodeIdImpl.class)
    private NodeId nodeId = new NodeIdImpl();

    /**
     * "The description of the device."
    */
    @Column(displaySize = 10)
    private String deviceDescription;

    /**
     * "The ip of a connection between controller and device."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = IpAddressImpl.class)
    private IpAddress netconfIp = new IpAddressImpl();

    /**
     * "The port of a connection between controller and device."
    */
    @Column
    private Integer netconfPort;

    /**
     * "The name of a connection between controller and device."
    */
    @Column(displaySize = 10)
    private String userName;

    /**
     * "The password of a connection between controller and device."
    */
    @Column(displaySize = 10)
    private String password;

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public OperationType getChangeType() {
        return this.changeType;
    }


    @Override
    public NodeId getNodeId() {
        return this.nodeId;
    }


    @Override
    public String getDeviceDescription() {
        return this.deviceDescription;
    }


    @Override
    public IpAddress getNetconfIp() {
        return this.netconfIp;
    }


    @Override
    public Integer getNetconfPort() {
        return this.netconfPort;
    }


    @Override
    public String getUserName() {
        return this.userName;
    }


    @Override
    public String getPassword() {
        return this.password;
    }


    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setChangeType(OperationType changeType) {
        this.changeType = changeType;
    }

    @Override
    public void setNodeId(NodeId nodeId) {
        this.nodeId = nodeId;
    }

    @Override
    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription = deviceDescription;
    }

    @Override
    public void setNetconfIp(IpAddress netconfIp) {
        this.netconfIp = netconfIp;
    }

    @Override
    public void setNetconfPort(Integer netconfPort) {
        this.netconfPort = netconfPort;
    }
    public void setNetconfPort(String netconfPort) {
        this.netconfPort = Integer.parseInt(netconfPort);
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
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
        DeviceNetconfImpl other = (DeviceNetconfImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

