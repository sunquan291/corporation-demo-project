package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.snmpversiontype;

public enum SnmpVersionTypeEnum {

    V1(1,"v1"),
    V2C(2,"v2c"),
    V3(3,"v3");

    private int snmpVersionTypeEnum;
    private String schemaName;

    SnmpVersionTypeEnum(int snmpVersionTypeEnum, String schemaName) {
        this.snmpVersionTypeEnum = snmpVersionTypeEnum;
        this.schemaName = schemaName;
    }


    public int getSnmpVersionTypeEnum() {
        return this.snmpVersionTypeEnum;
    }

    public static SnmpVersionTypeEnum of(int value) {
        switch (value) {
            case 1:
                return SnmpVersionTypeEnum.V1;
            case 2:
                return SnmpVersionTypeEnum.V2C;
            case 3:
                return SnmpVersionTypeEnum.V3;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }

    public static SnmpVersionTypeEnum of(String value) {
        switch (value) {
            case "v1":
                return SnmpVersionTypeEnum.V1;
            case "v2c":
                return SnmpVersionTypeEnum.V2C;
            case "v3":
                return SnmpVersionTypeEnum.V3;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }


}

