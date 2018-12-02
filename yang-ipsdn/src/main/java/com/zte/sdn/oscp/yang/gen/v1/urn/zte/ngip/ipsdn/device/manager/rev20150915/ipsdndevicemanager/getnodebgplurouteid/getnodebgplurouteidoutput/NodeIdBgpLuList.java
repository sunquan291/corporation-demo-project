package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getnodebgplurouteid.getnodebgplurouteidoutput;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeId;
import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.Ipv4Address;

@Table
public interface NodeIdBgpLuList {

    NodeId getNodeIdBgpLu();

    Ipv4Address getBgpLuRouteId();

    String getParentPath();


    /**
     *
     * @param nodeIdBgpLu 
    */
    void setNodeIdBgpLu(NodeId nodeIdBgpLu);

    /**
     *
     * @param bgpLuRouteId 
    */
    void setBgpLuRouteId(Ipv4Address bgpLuRouteId);

    void setParentPath(String parentPath);


}

