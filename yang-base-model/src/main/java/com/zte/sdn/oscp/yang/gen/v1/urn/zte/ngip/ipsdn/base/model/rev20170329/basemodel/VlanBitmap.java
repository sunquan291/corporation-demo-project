package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel;

import com.zte.sdn.oscp.persistence.annotations.Table;

@Table
public interface VlanBitmap {

    /**
     * @return
     */
    Integer getInt32();

    /**
     * @return
     */
    String getParentPath();


    /**
     * @param int32
     */
    void setInt32(Integer int32);

    /**
     * @param parentPath
     */
    void setParentPath(String parentPath);


}

