package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getcontrollers.getcontrollersoutput.controller.controllerdetail.cliconnection;

public enum ConnectTypeEnum {

    TYPETELNET(0,"typeTelnet"),
    TYPESSH(1,"typeSsh");

    private int connectTypeEnum;
    private String schemaName;

    ConnectTypeEnum(int connectTypeEnum, String schemaName) {
        this.connectTypeEnum = connectTypeEnum;
        this.schemaName = schemaName;
    }


    public int getConnectTypeEnum() {
        return this.connectTypeEnum;
    }

    public static ConnectTypeEnum of(int value) {
        switch (value) {
            case 0:
                return ConnectTypeEnum.TYPETELNET;
            case 1:
                return ConnectTypeEnum.TYPESSH;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }

    public static ConnectTypeEnum of(String value) {
        switch (value) {
            case "TYPE_TELNET":
                return ConnectTypeEnum.TYPETELNET;
            case "TYPE_SSH":
                return ConnectTypeEnum.TYPESSH;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }


}

