package com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes;

import com.zte.sdn.oscp.persistence.annotations.Table;

/**
 * The as-number type represents autonomous system numbers
   which identify an Autonomous System (AS).  An AS is a set
   of routers under a single technical administration, using
   an interior gateway protocol and common metrics to route
   packets within the AS, and using an exterior gateway
   protocol to route packets to other ASs'.  IANA maintains
   the AS number space and has delegated large parts to the
   regional registries.

   Autonomous system numbers were originally limited to 16
   bits.  BGP extensions have enlarged the autonomous system
   number space to 32 bits.  This type therefore uses an uint32
   base type without a range restriction in order to support
   a larger autonomous system number space.

   In the value set and its semantics, this type is equivalent
   to the InetAutonomousSystemNumber textual convention of
   the SMIv2.
 * RFC 1930: Guidelines for creation, selection, and registration
 of an Autonomous System (AS)
   RFC 4271: A Border Gateway Protocol 4 (BGP-4)
   RFC 4893: BGP Support for Four-octet AS Number Space
   RFC 4001: Textual Conventions for Internet Network Addresses
 */
@Table
public interface AsNumber {

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

