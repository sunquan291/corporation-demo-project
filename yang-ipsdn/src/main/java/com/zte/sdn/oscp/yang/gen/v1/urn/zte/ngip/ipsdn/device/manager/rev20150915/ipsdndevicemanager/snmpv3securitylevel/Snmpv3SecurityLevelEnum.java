package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.snmpv3securitylevel;

public enum Snmpv3SecurityLevelEnum {

    NOAUTHNOENCODE(0,"noAuthNoEncode"),
    AUTHNOENCODE(1,"authNoEncode"),
    AUTHENCODE(3,"authEncode");

    private int snmpv3SecurityLevelEnum;
    private String schemaName;

    Snmpv3SecurityLevelEnum(int snmpv3SecurityLevelEnum, String schemaName) {
        this.snmpv3SecurityLevelEnum = snmpv3SecurityLevelEnum;
        this.schemaName = schemaName;
    }


    public int getSnmpv3SecurityLevelEnum() {
        return this.snmpv3SecurityLevelEnum;
    }

    public static Snmpv3SecurityLevelEnum of(int value) {
        switch (value) {
            case 0:
                return Snmpv3SecurityLevelEnum.NOAUTHNOENCODE;
            case 1:
                return Snmpv3SecurityLevelEnum.AUTHNOENCODE;
            case 3:
                return Snmpv3SecurityLevelEnum.AUTHENCODE;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }

    public static Snmpv3SecurityLevelEnum of(String value) {
        switch (value) {
            case "NoAuthNoEncode":
                return Snmpv3SecurityLevelEnum.NOAUTHNOENCODE;
            case "AuthNoEncode":
                return Snmpv3SecurityLevelEnum.AUTHNOENCODE;
            case "AuthEncode":
                return Snmpv3SecurityLevelEnum.AUTHENCODE;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }


}

