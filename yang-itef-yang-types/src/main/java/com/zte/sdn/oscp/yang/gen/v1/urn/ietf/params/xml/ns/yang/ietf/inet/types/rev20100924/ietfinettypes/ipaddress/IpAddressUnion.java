package com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.ipaddress;

import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.Ipv6Address;
import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.Ipv4Address;

@Table
public interface IpAddressUnion {

    /**
     * @return
     */
    Ipv4Address getIpv4Address();

    /**
     * @return
     */
    Ipv6Address getIpv6Address();

    /**
     * @return
     */
    String getParentPath();


    /**
     * @param ipv4Address
     */
    void setIpv4Address(Ipv4Address ipv4Address);

    /**
     * @param ipv6Address
     */
    void setIpv6Address(Ipv6Address ipv6Address);

    /**
     * @param parentPath
     */
    void setParentPath(String parentPath);


}

