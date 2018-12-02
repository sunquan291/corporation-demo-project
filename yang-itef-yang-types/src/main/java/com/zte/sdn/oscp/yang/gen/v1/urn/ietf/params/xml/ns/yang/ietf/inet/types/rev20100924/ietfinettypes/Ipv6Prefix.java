package com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes;

import com.zte.sdn.oscp.persistence.annotations.Table;

/**
 * The ipv6-prefix type represents an IPv6 address prefix.
   The prefix length is given by the number following the
   slash character and must be less than or equal 128.

   A prefix length value of n corresponds to an IP address
   mask that has n contiguous 1-bits from the most
   significant bit (MSB) and all other bits set to 0.

   The IPv6 address should have all bits that do not belong
   to the prefix set to zero.

   The canonical format of an IPv6 prefix has all bits of
   the IPv6 address set to zero that are not part of the
   IPv6 prefix.  Furthermore, IPv6 address is represented
   in the compressed format described in RFC 4291, Section
   2.2, item 2 with the following additional rules: the ::
   substitution must be applied to the longest sequence of
   all-zero 16-bit chunks in an IPv6 address.  If there is
   a tie, the first sequence of all-zero 16-bit chunks is
   replaced by ::.  Single all-zero 16-bit chunks are not
   compressed.  The canonical format uses lowercase
   characters and leading zeros are not allowed.
 * RFC 4291: IP Version 6 Addressing Architecture
 */
@Table
public interface Ipv6Prefix {

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

