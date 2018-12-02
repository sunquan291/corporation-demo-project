package com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes;

import com.zte.sdn.oscp.persistence.annotations.Table;

/**
 * The ipv4-prefix type represents an IPv4 address prefix.
   The prefix length is given by the number following the
   slash character and must be less than or equal to 32.

   A prefix length value of n corresponds to an IP address
   mask that has n contiguous 1-bits from the most
   significant bit (MSB) and all other bits set to 0.

   The canonical format of an IPv4 prefix has all bits of
   the IPv4 address set to zero that are not part of the
   IPv4 prefix.
 */
@Table
public interface Ipv4Prefix {

    /**
     * @return
     */
    String getString();

    /**
     * @return
     */
    String getParentPath();


    /**
     * @param string
     */
    void setString(String string);

    /**
     * @param parentPath
     */
    void setParentPath(String parentPath);


}

