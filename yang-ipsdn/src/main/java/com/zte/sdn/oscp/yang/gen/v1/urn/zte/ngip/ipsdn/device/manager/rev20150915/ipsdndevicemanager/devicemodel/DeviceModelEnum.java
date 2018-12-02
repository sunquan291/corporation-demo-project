package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devicemodel;

public enum DeviceModelEnum {

    OSCPYANGPREFIX6150(1,"oscpYangPrefix6150"),
    OSCPYANGPREFIX9000E(2,"oscpYangPrefix9000e"),
    M6000(3,"m6000"),
    T8K(4,"t8k"),
    OSCPYANGPREFIX15K(5,"oscpYangPrefix15k"),
    SIMULATE(6,"simulate"),
    OSCPYANGPREFIXDEFAULT(7,"oscpYangPrefixDefault");

    private int deviceModelEnum;
    private String schemaName;

    DeviceModelEnum(int deviceModelEnum, String schemaName) {
        this.deviceModelEnum = deviceModelEnum;
        this.schemaName = schemaName;
    }


    public int getDeviceModelEnum() {
        return this.deviceModelEnum;
    }

    public static DeviceModelEnum of(int value) {
        switch (value) {
            case 1:
                return DeviceModelEnum.OSCPYANGPREFIX6150;
            case 2:
                return DeviceModelEnum.OSCPYANGPREFIX9000E;
            case 3:
                return DeviceModelEnum.M6000;
            case 4:
                return DeviceModelEnum.T8K;
            case 5:
                return DeviceModelEnum.OSCPYANGPREFIX15K;
            case 6:
                return DeviceModelEnum.SIMULATE;
            case 7:
                return DeviceModelEnum.OSCPYANGPREFIXDEFAULT;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }

    public static DeviceModelEnum of(String value) {
        switch (value) {
            case "6150":
                return DeviceModelEnum.OSCPYANGPREFIX6150;
            case "9000E":
                return DeviceModelEnum.OSCPYANGPREFIX9000E;
            case "M6000":
                return DeviceModelEnum.M6000;
            case "T8K":
                return DeviceModelEnum.T8K;
            case "15K":
                return DeviceModelEnum.OSCPYANGPREFIX15K;
            case "simulate":
                return DeviceModelEnum.SIMULATE;
            case "default":
                return DeviceModelEnum.OSCPYANGPREFIXDEFAULT;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }


}

