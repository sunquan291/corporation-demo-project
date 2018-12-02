package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result.success.Ports;
import com.zte.sdn.oscp.persistence.annotations.Table;
import java.util.Set;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.Result;

    //interface-declare.txt
@Table
public interface Success extends Result {

    Set<Ports> getPorts();

    String getParentPath();


    void  setPorts(Set<Ports> ports);

    void setParentPath(String parentPath);


    void addToPorts(Ports addTo);


    void removeFromPorts(String key);


}

