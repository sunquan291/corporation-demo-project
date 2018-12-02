package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portsconfignodes.nodeports.ports.accesstype;

import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.VlanBitmap;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portsconfignodes.nodeports.ports.AccessType;

    //interface-declare.txt
@Table
public interface Qinq extends AccessType {

    /**
     * "QinQ internal vlan bitmap."
     * @return 
    */
    VlanBitmap getQinqInternalVlanBitmap();

    /**
     * "QinQ external vlan bitmap."
     * @return 
    */
    VlanBitmap getQinqExternalVlanBitmap();

    String getParentPath();


    /**
     * "QinQ internal vlan bitmap."
     * @param qinqInternalVlanBitmap 
    */
    void setQinqInternalVlanBitmap(VlanBitmap qinqInternalVlanBitmap);

    /**
     * "QinQ external vlan bitmap."
     * @param qinqExternalVlanBitmap 
    */
    void setQinqExternalVlanBitmap(VlanBitmap qinqExternalVlanBitmap);

    void setParentPath(String parentPath);


}

