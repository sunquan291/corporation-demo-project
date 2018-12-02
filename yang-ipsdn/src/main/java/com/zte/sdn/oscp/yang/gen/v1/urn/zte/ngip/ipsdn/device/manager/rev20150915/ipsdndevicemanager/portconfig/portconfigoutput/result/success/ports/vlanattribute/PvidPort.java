package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.portconfig.portconfigoutput.result.success.ports.vlanattribute;

import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.SwitchPortMode;

@Table
public interface PvidPort {

    String getPortName();

    SwitchPortMode getMode();

    String getParentPath();


    /**
     *
     * @param portName 
    */
    void setPortName(String portName);

    /**
     *
     * @param mode 
    */
    void setMode(SwitchPortMode mode);

    void setParentPath(String parentPath);


}

