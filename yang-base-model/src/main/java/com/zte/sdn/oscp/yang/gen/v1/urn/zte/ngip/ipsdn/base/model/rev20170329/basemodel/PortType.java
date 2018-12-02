package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel;

import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.porttype.PortTypeEnum;

/**
 * type of port.
 */
@Table
public interface PortType {

    /**
     * @return
     */
    String getParentPath();


    /**
     * @param parentPath
     */
    void setParentPath(String parentPath);


}

