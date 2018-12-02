package com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes;

import com.zte.sdn.oscp.persistence.annotations.Table;

/**
 * The uri type represents a Uniform Resource Identifier
   (URI) as defined by STD 66.

   Objects using the uri type MUST be in US-ASCII encoding,
   and MUST be normalized as described by RFC 3986 Sections
   6.2.1, 6.2.2.1, and 6.2.2.2.  All unnecessary
   percent-encoding is removed, and all case-insensitive
   characters are set to lowercase except for hexadecimal
   digits, which are normalized to uppercase as described in
   Section 6.2.2.1.

   The purpose of this normalization is to help provide
   unique URIs.  Note that this normalization is not
   sufficient to provide uniqueness.  Two URIs that are
   textually distinct after this normalization may still be
   equivalent.

   Objects using the uri type may restrict the schemes that
   they permit.  For example, 'data:' and 'urn:' schemes
   might not be appropriate.

   A zero-length URI is not a valid URI.  This can be used to
   express 'URI absent' where required.

   In the value set and its semantics, this type is equivalent
   to the Uri SMIv2 textual convention defined in RFC 5017.
 * RFC 3986: Uniform Resource Identifier (URI): Generic Syntax
   RFC 3305: Report from the Joint W3C/IETF URI Planning Interest
 Group: Uniform Resource Identifiers (URIs), URLs,
 and Uniform Resource Names (URNs): Clarifications
 and Recommendations
   RFC 5017: MIB Textual Conventions for Uniform Resource
 Identifiers (URIs)
 */
@Table
public interface Uri {

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

