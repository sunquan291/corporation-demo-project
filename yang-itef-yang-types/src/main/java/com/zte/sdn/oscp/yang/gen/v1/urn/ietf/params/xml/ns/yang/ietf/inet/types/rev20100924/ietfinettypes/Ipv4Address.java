package com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes;

import com.zte.sdn.oscp.persistence.annotations.Table;

/**
 * The ipv4-address type represents an IPv4 address in
dotted-quad notation.  The IPv4 address may include a zone
index, separated by a % sign.

The zone index is used to disambiguate identical address
values.  For link-local addresses, the zone index will
typically be the interface index number or the name of an
interface.  If the zone index is not present, the default
zone of the device will be used.

The canonical format for the zone index is the numerical
format
 */
@Table
public interface Ipv4Address {

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

