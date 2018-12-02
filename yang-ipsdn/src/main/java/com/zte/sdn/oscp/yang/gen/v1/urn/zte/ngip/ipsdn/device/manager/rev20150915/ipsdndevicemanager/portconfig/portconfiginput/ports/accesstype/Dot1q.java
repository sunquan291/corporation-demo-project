package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfiginput.ports.accesstype;

import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.VlanBitmap;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfiginput.ports.AccessType;

    //interface-declare.txt
@Table
public interface Dot1q extends AccessType {

    /**
     * "Dot1Q Vlan Bitmap. CRD"
     * @return 
    */
    VlanBitmap getDot1QvlanBitmap();

    String getParentPath();


    /**
     * "Dot1Q Vlan Bitmap. CRD"
     * @param dot1QvlanBitmap 
    */
    void setDot1QvlanBitmap(VlanBitmap dot1QvlanBitmap);

    void setParentPath(String parentPath);


}

