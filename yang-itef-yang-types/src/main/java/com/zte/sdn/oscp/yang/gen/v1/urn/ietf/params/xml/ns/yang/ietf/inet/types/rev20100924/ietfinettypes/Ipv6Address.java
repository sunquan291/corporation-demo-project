package com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes;

import com.zte.sdn.oscp.persistence.annotations.Table;

/**
 * The ipv6-address type represents an IPv6 address in full,
   mixed, shortened, and shortened-mixed notation.  The IPv6
   address may include a zone index, separated by a % sign.

   The zone index is used to disambiguate identical address
   values.  For link-local addresses, the zone index will
   typically be the interface index number or the name of an
   interface.  If the zone index is not present, the default
   zone of the device will be used.

   The canonical format of IPv6 addresses uses the compressed
   format described in RFC 4291, Section 2.2, item 2 with the
   following additional rules: the :: substitution must be
   applied to the longest sequence of all-zero 16-bit chunks
   in an IPv6 address.  If there is a tie, the first sequence
   of all-zero 16-bit chunks is replaced by ::.  Single
   all-zero 16-bit chunks are not compressed.  The canonical
   format uses lowercase characters and leading zeros are
   not allowed.  The canonical format for the zone index is
   the numerical format as described in RFC 4007, Section
   11.2.
 * RFC 4291: IP Version 6 Addressing Architecture
   RFC 4007: IPv6 Scoped Address Architecture
   RFC 5952: A Recommendation for IPv6 Address Text Representation
 */
@Table
public interface Ipv6Address {

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

