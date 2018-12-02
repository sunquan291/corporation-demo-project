package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.supporttype;

public enum SupportTypeEnum {

    JAVAKEYPREFIXNATIVE(0,"javaKeyPrefixNative"),
    EMULATED(1,"emulated"),
    NOTSUPPORTED(2,"notSupported");

    private int supportTypeEnum;
    private String schemaName;

    SupportTypeEnum(int supportTypeEnum, String schemaName) {
        this.supportTypeEnum = supportTypeEnum;
        this.schemaName = schemaName;
    }


    public int getSupportTypeEnum() {
        return this.supportTypeEnum;
    }

    public static SupportTypeEnum of(int value) {
        switch (value) {
            case 0:
                return SupportTypeEnum.JAVAKEYPREFIXNATIVE;
            case 1:
                return SupportTypeEnum.EMULATED;
            case 2:
                return SupportTypeEnum.NOTSUPPORTED;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }

    public static SupportTypeEnum of(String value) {
        switch (value) {
            case "native":
                return SupportTypeEnum.JAVAKEYPREFIXNATIVE;
            case "emulated":
                return SupportTypeEnum.EMULATED;
            case "not_supported":
                return SupportTypeEnum.NOTSUPPORTED;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }


}

