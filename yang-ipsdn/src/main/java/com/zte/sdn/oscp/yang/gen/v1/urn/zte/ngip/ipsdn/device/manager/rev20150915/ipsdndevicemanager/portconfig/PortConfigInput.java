package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeId;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfiginput.Ports;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.OperationTypeImpl;
import com.zte.sdn.oscp.persistence.validator.annotation.ExpressionLengthRestriction;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.OperationType;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfiginput.PortsImpl;
import java.util.Set;
import java.util.LinkedHashSet;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeIdImpl;

public class PortConfigInput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "txid for the port"
    */
    @Column(displaySize = 10)
    @ExpressionLengthRestriction(rangeContent = "1..255")
    private String txid;

    /**
     * "add or delete"
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = OperationTypeImpl.class)
    private OperationType operate = new OperationTypeImpl();

    /**
     * "English:The nodeid of the device (mac)."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = NodeIdImpl.class)
    private NodeId nodeId = new NodeIdImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =PortsImpl.class, associateLoad = false, associateSave = false)
    private Set<Ports> ports = new LinkedHashSet<Ports>();


    public String getTxid() {
        return this.txid;
    }


    public OperationType getOperate() {
        return this.operate;
    }


    public NodeId getNodeId() {
        return this.nodeId;
    }


    public Set<Ports> getPorts() {
        return this.ports;
    }


    public void setTxid(String txid) {
        this.txid = txid;
    }

    public void setOperate(OperationType operate) {
        this.operate = operate;
    }

    public void setNodeId(NodeId nodeId) {
        this.nodeId = nodeId;
    }

    public void setPorts(Set<Ports> ports) {
        this.ports = ports;
    }



}

