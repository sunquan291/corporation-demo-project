package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory;

public abstract class NodeConnectorContext {
    public static String nodeConnectorContext2String() {
        return "nodeConnectorContext";
    }
    public static Class string2Class(String val) {
        if (val.equals("nodeConnectorContext")) {
            return NodeConnectorContext.class;
        }
        throw new IllegalArgumentException("not a valid input element");
    }
}
