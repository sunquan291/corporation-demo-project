package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portsconfignodes;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeId;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portsconfignodes.nodeports.Ports;
import com.zte.sdn.oscp.persistence.annotations.Table;
import java.util.Set;

@Table
public interface NodePorts {

    /**
     * "English:The nodeid of the device (mac)."
     * @return 
    */
    NodeId getNodeId();

    Set<Ports> getPorts();

    Ports getFromPorts(String key);
    String getParentPath();


    /**
     * "English:The nodeid of the device (mac)."
     * @param nodeId 
    */
    void setNodeId(NodeId nodeId);

    void  setPorts(Set<Ports> ports);

    void setParentPath(String parentPath);


    void addToPorts(Ports addTo);


    void removeFromPorts(String key);


}

