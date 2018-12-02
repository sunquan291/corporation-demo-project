package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devicerole;

public enum DeviceRoleEnum {

    UCPE(1,"ucpe"),
    VMSR(2,"vmsr"),
    VMSRUME(3,"vMsrUme");

    private int deviceRoleEnum;
    private String schemaName;

    DeviceRoleEnum(int deviceRoleEnum, String schemaName) {
        this.deviceRoleEnum = deviceRoleEnum;
        this.schemaName = schemaName;
    }


    public int getDeviceRoleEnum() {
        return this.deviceRoleEnum;
    }

    public static DeviceRoleEnum of(int value) {
        switch (value) {
            case 1:
                return DeviceRoleEnum.UCPE;
            case 2:
                return DeviceRoleEnum.VMSR;
            case 3:
                return DeviceRoleEnum.VMSRUME;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }

    public static DeviceRoleEnum of(String value) {
        switch (value) {
            case "UCPE":
                return DeviceRoleEnum.UCPE;
            case "VMSR":
                return DeviceRoleEnum.VMSR;
            case "vMSR_UME":
                return DeviceRoleEnum.VMSRUME;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }


}

