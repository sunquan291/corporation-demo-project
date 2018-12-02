package com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.ipprefix;

import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.Ipv6Prefix;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.Ipv4Prefix;

@Table
public interface IpPrefixUnion {

    /**
     * @return
     */
    Ipv4Prefix getIpv4Prefix();

    /**
     * @return
     */
    Ipv6Prefix getIpv6Prefix();

    /**
     * @return
     */
    String getParentPath();


    /**
     * @param ipv4Prefix
     */
    void setIpv4Prefix(Ipv4Prefix ipv4Prefix);

    /**
     * @param ipv6Prefix
     */
    void setIpv6Prefix(Ipv6Prefix ipv6Prefix);

    /**
     * @param parentPath
     */
    void setParentPath(String parentPath);


}

