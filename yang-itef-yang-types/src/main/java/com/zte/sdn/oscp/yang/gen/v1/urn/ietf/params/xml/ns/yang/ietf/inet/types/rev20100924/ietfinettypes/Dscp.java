package com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes;

import com.zte.sdn.oscp.persistence.annotations.Table;

/**
 * The dscp type represents a Differentiated Services Code-Point
   that may be used for marking packets in a traffic stream.

   In the value set and its semantics, this type is equivalent
   to the Dscp textual convention of the SMIv2.
 * RFC 3289: Management Information Base for the Differentiated
 Services Architecture
   RFC 2474: Definition of the Differentiated Services Field
 (DS Field) in the IPv4 and IPv6 Headers
   RFC 2780: IANA Allocation Guidelines For Values In
 the Internet Protocol and Related Headers
 */
@Table
public interface Dscp {

    /**
     * @return
     */
    Short getUint8();

    /**
     * @return
     */
    String getParentPath();


    /**
     * @param uint8
     */
    void setUint8(Short uint8);

    /**
     * @param parentPath
     */
    void setParentPath(String parentPath);


}

