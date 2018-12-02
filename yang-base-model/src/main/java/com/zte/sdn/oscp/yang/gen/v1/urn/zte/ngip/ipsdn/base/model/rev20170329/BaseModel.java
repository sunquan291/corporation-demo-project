package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.PortType;
import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.SwitchPortMode;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.OperationType;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.VlanBitmap;

/**
 * YANG version of the base-model.
 */
@Table
public interface BaseModel {

    /**
     * @return
     */
    String getParentPath();


    /**
     * @param parentPath
     */
    void setParentPath(String parentPath);


}

