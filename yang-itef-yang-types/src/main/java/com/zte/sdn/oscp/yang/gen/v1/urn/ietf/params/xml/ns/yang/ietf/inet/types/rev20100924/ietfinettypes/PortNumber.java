package com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes;

import com.zte.sdn.oscp.persistence.annotations.Table;

/**
 * The port-number type represents a 16-bit port number of an
   Internet transport layer protocol such as UDP, TCP, DCCP, or
   SCTP.  Port numbers are assigned by IANA.  A current list of
   all assignments is available from <http://www.iana.org/>.

   Note that the port number value zero is reserved by IANA.  In
   situations where the value zero does not make sense, it can
   be excluded by subtyping the port-number type.

   In the value set and its semantics, this type is equivalent
   to the InetPortNumber textual convention of the SMIv2.
 * RFC  768: User Datagram Protocol
   RFC  793: Transmission Control Protocol
   RFC 4960: Stream Control Transmission Protocol
   RFC 4340: Datagram Congestion Control Protocol (DCCP)
   RFC 4001: Textual Conventions for Internet Network Addresses
 */
@Table
public interface PortNumber {

    /**
     * @return
     */
    Integer getUint16();

    /**
     * @return
     */
    String getParentPath();


    /**
     * @param uint16
     */
    void setUint16(Integer uint16);

    /**
     * @param parentPath
     */
    void setParentPath(String parentPath);


}

