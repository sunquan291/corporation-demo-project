package com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.ipversion;

public enum IpVersionEnum {

    UNKNOWN(0,"unknown"),
    IPV4(1,"ipv4"),
    IPV6(2,"ipv6");

    private int ipVersionEnum;
    private String schemaName;

    IpVersionEnum(int ipVersionEnum, String schemaName) {
        this.ipVersionEnum = ipVersionEnum;
        this.schemaName = schemaName;
    }


    public int getIpVersionEnum() {
        return this.ipVersionEnum;
    }

    public static IpVersionEnum of(int value) {
        switch (value) {
            case 0:
                return IpVersionEnum.UNKNOWN;
            case 1:
                return IpVersionEnum.IPV4;
            case 2:
                return IpVersionEnum.IPV6;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }

    public static IpVersionEnum of(String value) {
        switch (value) {
            case "unknown":
                return IpVersionEnum.UNKNOWN;
            case "ipv4":
                return IpVersionEnum.IPV4;
            case "ipv6":
                return IpVersionEnum.IPV6;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }


}

