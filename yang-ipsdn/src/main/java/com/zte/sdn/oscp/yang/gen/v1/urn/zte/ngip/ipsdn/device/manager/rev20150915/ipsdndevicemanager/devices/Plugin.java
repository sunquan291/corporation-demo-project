package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices;

import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.plugin.Dna;

@Table
public interface Plugin {

    Dna getDna();

    String getParentPath();


    void setDna(Dna dna);

    void setParentPath(String parentPath);


}

