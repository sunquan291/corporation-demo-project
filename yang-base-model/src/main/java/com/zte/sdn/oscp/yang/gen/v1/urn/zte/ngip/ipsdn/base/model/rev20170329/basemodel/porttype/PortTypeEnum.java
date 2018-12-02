package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.porttype;

public enum PortTypeEnum {

    VLAN(1,"vlan"),
    LOOPBACK(2,"loopback");

    private int portTypeEnum;
    private String schemaName;

    PortTypeEnum(int portTypeEnum, String schemaName) {
        this.portTypeEnum = portTypeEnum;
        this.schemaName = schemaName;
    }


    public int getPortTypeEnum() {
        return this.portTypeEnum;
    }

    public static PortTypeEnum of(int value) {
        switch (value) {
            case 1:
                return PortTypeEnum.VLAN;
            case 2:
                return PortTypeEnum.LOOPBACK;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }

    public static PortTypeEnum of(String value) {
        switch (value) {
            case "vlan":
                return PortTypeEnum.VLAN;
            case "loopback":
                return PortTypeEnum.LOOPBACK;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }


}

