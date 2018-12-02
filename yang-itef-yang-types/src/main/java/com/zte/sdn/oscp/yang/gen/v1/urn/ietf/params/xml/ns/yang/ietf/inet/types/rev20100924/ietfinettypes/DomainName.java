package com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes;

import com.zte.sdn.oscp.persistence.annotations.Table;

/**
 * The domain-name type represents a DNS domain name.  The
   name SHOULD be fully qualified whenever possible.

   Internet domain names are only loosely specified.  Section
   3.5 of RFC 1034 recommends a syntax (modified in Section
   2.1 of RFC 1123).  The pattern above is intended to allow
   for current practice in domain name use, and some possible
   future expansion.  It is designed to hold various types of
   domain names, including names used for A or AAAA records
   (host names) and other records, such as SRV records.  Note
   that Internet host names have a stricter syntax (described
   in RFC 952) than the DNS recommendations in RFCs 1034 and
   1123, and that systems that want to store host names in
   schema nodes using the domain-name type are recommended to
   adhere to this stricter standard to ensure interoperability.

   The encoding of DNS names in the DNS protocol is limited
   to 255 characters.  Since the encoding consists of labels
   prefixed by a length bytes and there is a trailing NULL
   byte, only 253 characters can appear in the textual dotted
   notation.

   The description clause of schema nodes using the domain-name
   type MUST describe when and how these names are resolved to
   IP addresses.  Note that the resolution of a domain-name value
   may require to query multiple DNS records (e.g., A for IPv4
   and AAAA for IPv6).  The order of the resolution process and
   which DNS record takes precedence can either be defined
   explicitely or it may depend on the configuration of the
   resolver.

   Domain-name values use the US-ASCII encoding.  Their canonical
   format uses lowercase US-ASCII characters.  Internationalized
   domain names MUST be encoded in punycode as described in RFC
   3492
 * RFC  952: DoD Internet Host Table Specification
   RFC 1034: Domain Names - Concepts and Facilities
   RFC 1123: Requirements for Internet Hosts -- Application
 and Support
   RFC 2782: A DNS RR for specifying the location of services
 (DNS SRV)
   RFC 3492: Punycode: A Bootstring encoding of Unicode for
 Internationalized Domain Names in Applications
 (IDNA)
   RFC 5891: Internationalizing Domain Names in Applications
 (IDNA): Protocol
 */
@Table
public interface DomainName {

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

