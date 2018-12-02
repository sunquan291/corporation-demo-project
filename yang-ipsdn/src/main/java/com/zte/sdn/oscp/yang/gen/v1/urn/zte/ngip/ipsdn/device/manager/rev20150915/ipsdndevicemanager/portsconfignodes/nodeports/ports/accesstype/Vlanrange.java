package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portsconfignodes.nodeports.ports.accesstype;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portsconfignodes.nodeports.ports.accesstype.vlanrange.VlanRange;
import com.zte.sdn.oscp.persistence.annotations.Table;
import java.util.Set;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portsconfignodes.nodeports.ports.AccessType;

    //interface-declare.txt
@Table
public interface Vlanrange extends AccessType {

    Set<VlanRange> getVlanRange();

    VlanRange getFromVlanRange(String key);
    String getParentPath();


    void  setVlanRange(Set<VlanRange> vlanRange);

    void setParentPath(String parentPath);


    void addToVlanRange(VlanRange addTo);


    void removeFromVlanRange(String key);


}

