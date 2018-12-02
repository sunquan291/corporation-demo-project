package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory;

import com.zte.sdn.oscp.persistence.annotations.Table;

/**
 * A reference that points to an opendaylight-light:nodes/node in the data tree.
 * DEPRECATED
 */
@Table
public interface NodeRef {

    /**
     * @return
     */
    String getInstanceIdentifier();

    /**
     * @return
     */
    String getParentPath();


    /**
     * @param instanceIdentifier
     */
    void setInstanceIdentifier(String instanceIdentifier);

    /**
     * @param parentPath
     */
    void setParentPath(String parentPath);


}

