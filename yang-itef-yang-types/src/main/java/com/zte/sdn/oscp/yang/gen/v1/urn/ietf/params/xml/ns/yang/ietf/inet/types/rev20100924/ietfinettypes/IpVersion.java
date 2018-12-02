package com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes;

import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.ipversion.IpVersionEnum;

/**
 * This value represents the version of the IP protocol.

   In the value set and its semantics, this type is equivalent
   to the InetVersion textual convention of the SMIv2.
 * RFC  791: Internet Protocol
   RFC 2460: Internet Protocol, Version 6 (IPv6) Specification
   RFC 4001: Textual Conventions for Internet Network Addresses
 */
@Table
public interface IpVersion {

    /**
     * @return
     */
    String getParentPath();


    /**
     * @param parentPath
     */
    void setParentPath(String parentPath);


}

