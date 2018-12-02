package com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes;

import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.host.HostUnion;
import com.zte.sdn.oscp.persistence.annotations.Table;

/**
 * The host type represents either an IP address or a DNS
   domain name.
 */
@Table
public interface Host {

    /**
     * @return
     */
    HostUnion getUnion();

    /**
     * @return
     */
    String getParentPath();


    /**
     * @param union
     */
    void setUnion(HostUnion union);

    /**
     * @param parentPath
     */
    void setParentPath(String parentPath);


}

