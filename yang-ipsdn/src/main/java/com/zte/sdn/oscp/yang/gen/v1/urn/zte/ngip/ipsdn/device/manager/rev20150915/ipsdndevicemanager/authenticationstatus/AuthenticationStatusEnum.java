package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.authenticationstatus;

public enum AuthenticationStatusEnum {

    OK(1,"ok"),
    FAIL(2,"fail"),
    UNKOWN(3,"unkown");

    private int authenticationStatusEnum;
    private String schemaName;

    AuthenticationStatusEnum(int authenticationStatusEnum, String schemaName) {
        this.authenticationStatusEnum = authenticationStatusEnum;
        this.schemaName = schemaName;
    }


    public int getAuthenticationStatusEnum() {
        return this.authenticationStatusEnum;
    }

    public static AuthenticationStatusEnum of(int value) {
        switch (value) {
            case 1:
                return AuthenticationStatusEnum.OK;
            case 2:
                return AuthenticationStatusEnum.FAIL;
            case 3:
                return AuthenticationStatusEnum.UNKOWN;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }

    public static AuthenticationStatusEnum of(String value) {
        switch (value) {
            case "OK":
                return AuthenticationStatusEnum.OK;
            case "FAIL":
                return AuthenticationStatusEnum.FAIL;
            case "UNKOWN":
                return AuthenticationStatusEnum.UNKOWN;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }


}

