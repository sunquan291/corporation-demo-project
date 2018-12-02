package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory;

public abstract class NodeConnectorType {
    public static String nodeConnectorType2String() {
        return "nodeConnectorType";
    }
    public static Class string2Class(String val) {
        if (val.equals("nodeConnectorType")) {
            return NodeConnectorType.class;
        }
        throw new IllegalArgumentException("not a valid input element");
    }
}
