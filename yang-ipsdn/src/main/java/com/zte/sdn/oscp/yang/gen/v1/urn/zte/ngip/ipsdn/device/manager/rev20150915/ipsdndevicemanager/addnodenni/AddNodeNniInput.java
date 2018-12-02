package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.addnodenni;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.addnodenni.addnodenniinput.nodenni.Interface;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.addnodenni.addnodenniinput.nodenni.Ip;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeId;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.addnodenni.addnodenniinput.nodenni.IpImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.addnodenni.addnodenniinput.nodenni.InterfaceImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.addnodenni.addnodenniinput.NodeNni;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeIdImpl;

public class AddNodeNniInput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "The nodeid of the device."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = NodeIdImpl.class)
    private NodeId nodeId = new NodeIdImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = IpImpl.class)
    private Ip Ip = new IpImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = InterfaceImpl.class)
    private Interface oscpYangPrefixInterface = new InterfaceImpl();


    public NodeId getNodeId() {
        return this.nodeId;
    }


    public Ip getIp() {
        return this.Ip;
    }


    public Interface getOscpYangPrefixInterface() {
        return this.oscpYangPrefixInterface;
    }



    public void setNodeId(NodeId nodeId) {
        this.nodeId = nodeId;
    }

    public void setIp(Ip Ip) {
        this.Ip = Ip;
    }

    public void setOscpYangPrefixInterface(Interface oscpYangPrefixInterface) {
        this.oscpYangPrefixInterface = oscpYangPrefixInterface;
    }



}

