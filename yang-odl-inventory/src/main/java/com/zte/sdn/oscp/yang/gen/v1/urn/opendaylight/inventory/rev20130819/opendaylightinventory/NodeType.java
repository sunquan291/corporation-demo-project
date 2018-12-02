package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory;

public abstract class NodeType {
    public static String nodeType2String() {
        return "nodeType";
    }
    public static Class string2Class(String val) {
        if (val.equals("nodeType")) {
            return NodeType.class;
        }
        throw new IllegalArgumentException("not a valid input element");
    }
}
