package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.snmpencryprotocoltype;

public enum SnmpEncryProtocolTypeEnum {

    NOAUTH(0,"noAuth"),
    CBCDES(1,"cbcDes"),
    CFBAES128(2,"cfbAes128");

    private int snmpEncryProtocolTypeEnum;
    private String schemaName;

    SnmpEncryProtocolTypeEnum(int snmpEncryProtocolTypeEnum, String schemaName) {
        this.snmpEncryProtocolTypeEnum = snmpEncryProtocolTypeEnum;
        this.schemaName = schemaName;
    }


    public int getSnmpEncryProtocolTypeEnum() {
        return this.snmpEncryProtocolTypeEnum;
    }

    public static SnmpEncryProtocolTypeEnum of(int value) {
        switch (value) {
            case 0:
                return SnmpEncryProtocolTypeEnum.NOAUTH;
            case 1:
                return SnmpEncryProtocolTypeEnum.CBCDES;
            case 2:
                return SnmpEncryProtocolTypeEnum.CFBAES128;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }

    public static SnmpEncryProtocolTypeEnum of(String value) {
        switch (value) {
            case "NO_AUTH":
                return SnmpEncryProtocolTypeEnum.NOAUTH;
            case "CBC_DES":
                return SnmpEncryProtocolTypeEnum.CBCDES;
            case "CFB_AES_128":
                return SnmpEncryProtocolTypeEnum.CFBAES128;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }


}

