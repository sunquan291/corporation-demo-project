package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portsconfignodes.nodeports.ports.accesstype.vlanrange;

import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.VlanBitmap;

@Table
public interface VlanRange {

    /**
     * "Vlan Bitmap."
     * @return 
    */
    VlanBitmap getVlanBegin();

    /**
     * "Vlan Bitmap."
     * @return 
    */
    VlanBitmap getVlanEnd();

    String getParentPath();


    /**
     * "Vlan Bitmap."
     * @param vlanBegin 
    */
    void setVlanBegin(VlanBitmap vlanBegin);

    /**
     * "Vlan Bitmap."
     * @param vlanEnd 
    */
    void setVlanEnd(VlanBitmap vlanEnd);

    void setParentPath(String parentPath);


}

