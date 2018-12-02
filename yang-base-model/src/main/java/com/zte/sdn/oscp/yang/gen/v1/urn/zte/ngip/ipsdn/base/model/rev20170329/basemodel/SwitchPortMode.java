package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.switchportmode.SwitchPortModeEnum;
import com.zte.sdn.oscp.persistence.annotations.Table;

@Table
public interface SwitchPortMode {

    /**
     * @return
     */
    String getParentPath();


    /**
     * @param parentPath
     */
    void setParentPath(String parentPath);


}

