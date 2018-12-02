package com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes;

import com.zte.sdn.oscp.persistence.annotations.Table;

/**
 * The flow-label type represents flow identifier or Flow Label
   in an IPv6 packet header that may be used to discriminate
   traffic flows.

   In the value set and its semantics, this type is equivalent
   to the IPv6FlowLabel textual convention of the SMIv2.
 * RFC 3595: Textual Conventions for IPv6 Flow Label
   RFC 2460: Internet Protocol, Version 6 (IPv6) Specification
 */
@Table
public interface Ipv6FlowLabel {

    /**
     * @return
     */
    Long getUint32();

    /**
     * @return
     */
    String getParentPath();


    /**
     * @param uint32
     */
    void setUint32(Long uint32);

    /**
     * @param parentPath
     */
    void setParentPath(String parentPath);


}

