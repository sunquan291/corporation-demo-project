package com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.host;

import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddress;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.DomainName;
import com.zte.sdn.oscp.persistence.annotations.Table;

@Table
public interface HostUnion {

    /**
     * @return
     */
    IpAddress getIpAddress();

    /**
     * @return
     */
    DomainName getDomainName();

    /**
     * @return
     */
    String getParentPath();


    /**
     * @param ipAddress
     */
    void setIpAddress(IpAddress ipAddress);

    /**
     * @param domainName
     */
    void setDomainName(DomainName domainName);

    /**
     * @param parentPath
     */
    void setParentPath(String parentPath);


}

