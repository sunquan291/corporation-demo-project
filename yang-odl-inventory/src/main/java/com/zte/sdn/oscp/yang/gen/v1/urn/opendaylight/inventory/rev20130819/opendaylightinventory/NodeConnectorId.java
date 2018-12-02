package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory;

import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.Uri;
import com.zte.sdn.oscp.persistence.annotations.Table;

/**
 * Identifier for a particular node-connector. For example:

myprotocol:<unique_node_connector_id>
myprotocol:3

It is a good practice to always lead with a scoping identifier.
In the example above the scoping was 'myprotocol'. In your app you
could use 'myapp' etc.
 * DEPRECATED
 */
@Table
public interface NodeConnectorId {

    /**
     * @return
     */
    Uri getUri();

    /**
     * @return
     */
    String getParentPath();


    /**
     * @param uri
     */
    void setUri(Uri uri);

    /**
     * @param parentPath
     */
    void setParentPath(String parentPath);


}

