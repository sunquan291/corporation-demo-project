package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getnodebgplurouteid.getnodebgplurouteidoutput;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeId;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.Ipv4Address;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.Ipv4AddressImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeIdImpl;

public class NodeIdBgpLuListImpl implements NodeIdBgpLuList {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = NodeIdImpl.class)
    private NodeId nodeIdBgpLu = new NodeIdImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = Ipv4AddressImpl.class)
    private Ipv4Address bgpLuRouteId = new Ipv4AddressImpl();

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public NodeId getNodeIdBgpLu() {
        return this.nodeIdBgpLu;
    }


    @Override
    public Ipv4Address getBgpLuRouteId() {
        return this.bgpLuRouteId;
    }


    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setNodeIdBgpLu(NodeId nodeIdBgpLu) {
        this.nodeIdBgpLu = nodeIdBgpLu;
    }

    @Override
    public void setBgpLuRouteId(Ipv4Address bgpLuRouteId) {
        this.bgpLuRouteId = bgpLuRouteId;
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
        NodeIdBgpLuListImpl other = (NodeIdBgpLuListImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

