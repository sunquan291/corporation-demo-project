package com.zte.sdn.oscp.yang.gen.v1.rpcbench.payload.rev20150702.rpcbenchpayloadmodule;

public abstract class NodeContext {
    public static String nodeContext2String() {
        return "nodeContext";
    }
    public static Class string2Class(String val) {
        if (val.equals("nodeContext")) {
            return NodeContext.class;
        }
        throw new IllegalArgumentException("not a valid input element");
    }
}
