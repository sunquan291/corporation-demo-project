package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager;

import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portsconfignodes.NodePorts;
import java.util.Set;

@Table
public interface PortsConfigNodes {

    Set<NodePorts> getNodePorts();

    NodePorts getFromNodePorts(String key);
    String getParentPath();


    void  setNodePorts(Set<NodePorts> nodePorts);

    void setParentPath(String parentPath);


    void addToNodePorts(NodePorts addTo);


    void removeFromNodePorts(String key);


}

