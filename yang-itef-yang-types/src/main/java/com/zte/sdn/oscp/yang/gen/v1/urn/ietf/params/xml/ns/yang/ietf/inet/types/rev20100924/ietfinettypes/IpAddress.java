package com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes;

import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.ipaddress.IpAddressUnion;

/**
 * The ip-address type represents an IP address and is IP
   version neutral.  The format of the textual representations
   implies the IP version.
 */
@Table
public interface IpAddress {

    /**
     * @return
     */
    IpAddressUnion getUnion();

    /**
     * @return
     */
    String getParentPath();


    /**
     * @param union
     */
    void setUnion(IpAddressUnion union);

    /**
     * @param parentPath
     */
    void setParentPath(String parentPath);


}

