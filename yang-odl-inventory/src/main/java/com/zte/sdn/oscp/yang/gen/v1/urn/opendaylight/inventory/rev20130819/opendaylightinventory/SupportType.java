package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.supporttype.SupportTypeEnum;
import com.zte.sdn.oscp.persistence.annotations.Table;

/**
 * DEPRECATED
 */
@Table
public interface SupportType {

    /**
     * @return
     */
    String getParentPath();


    /**
     * @param parentPath
     */
    void setParentPath(String parentPath);


}

