package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfiginput.ports;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfiginput.ports.vlanattribute.TagPort;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfiginput.ports.vlanattribute.UntagPort;
import com.zte.sdn.oscp.persistence.annotations.Table;
import java.util.Set;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfiginput.ports.vlanattribute.PvidPort;

@Table
public interface VlanAttribute {

    Set<PvidPort> getPvidPort();

    PvidPort getFromPvidPort(String key);
    Set<TagPort> getTagPort();

    TagPort getFromTagPort(String key);
    Set<UntagPort> getUntagPort();

    UntagPort getFromUntagPort(String key);
    String getParentPath();


    void  setPvidPort(Set<PvidPort> pvidPort);

    void  setTagPort(Set<TagPort> tagPort);

    void  setUntagPort(Set<UntagPort> untagPort);

    void setParentPath(String parentPath);


    void addToPvidPort(PvidPort addTo);

    void addToTagPort(TagPort addTo);

    void addToUntagPort(UntagPort addTo);


    void removeFromPvidPort(String key);

    void removeFromTagPort(String key);

    void removeFromUntagPort(String key);


}

