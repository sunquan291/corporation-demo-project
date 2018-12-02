package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getconnect.getconnectoutput;

import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddress;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.NodeType;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeId;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.NodeTypeImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddressImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeIdImpl;

public class ConnectsImpl implements Connects {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "The nodeid of the device."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = NodeIdImpl.class)
    private NodeId nodeId = new NodeIdImpl();

    /**
     * "Type of the device."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = NodeTypeImpl.class)
    private NodeType nodeType = new NodeTypeImpl();

    /**
     * "The ip of a connection between controller and device."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = IpAddressImpl.class)
    private IpAddress netconfIp = new IpAddressImpl();

    /**
     * "The ip of the connection."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = IpAddressImpl.class)
    private IpAddress restconfIp = new IpAddressImpl();

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
    public IpAddress getNetconfIp() {
        return this.netconfIp;
    }


    @Override
    public IpAddress getRestconfIp() {
        return this.restconfIp;
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
    public void setNetconfIp(IpAddress netconfIp) {
        this.netconfIp = netconfIp;
    }

    @Override
    public void setRestconfIp(IpAddress restconfIp) {
        this.restconfIp = restconfIp;
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
        ConnectsImpl other = (ConnectsImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

