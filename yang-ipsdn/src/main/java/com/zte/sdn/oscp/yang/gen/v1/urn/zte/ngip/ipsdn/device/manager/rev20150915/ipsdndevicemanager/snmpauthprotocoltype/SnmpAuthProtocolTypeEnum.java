package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.snmpauthprotocoltype;

public enum SnmpAuthProtocolTypeEnum {

    NOAUTH(20,"noAuth"),
    MD5(21,"md5"),
    SHA(22,"sha");

    private int snmpAuthProtocolTypeEnum;
    private String schemaName;

    SnmpAuthProtocolTypeEnum(int snmpAuthProtocolTypeEnum, String schemaName) {
        this.snmpAuthProtocolTypeEnum = snmpAuthProtocolTypeEnum;
        this.schemaName = schemaName;
    }


    public int getSnmpAuthProtocolTypeEnum() {
        return this.snmpAuthProtocolTypeEnum;
    }

    public static SnmpAuthProtocolTypeEnum of(int value) {
        switch (value) {
            case 22:
                return SnmpAuthProtocolTypeEnum.SHA;
            case 20:
                return SnmpAuthProtocolTypeEnum.NOAUTH;
            case 21:
                return SnmpAuthProtocolTypeEnum.MD5;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }

    public static SnmpAuthProtocolTypeEnum of(String value) {
        switch (value) {
            case "SHA":
                return SnmpAuthProtocolTypeEnum.SHA;
            case "NO_AUTH":
                return SnmpAuthProtocolTypeEnum.NOAUTH;
            case "MD5":
                return SnmpAuthProtocolTypeEnum.MD5;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }


}

