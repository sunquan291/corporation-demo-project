package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getcontrollers.getcontrollersoutput.controller.controllerdevices.devicegroup;

public enum VendorEnum {

    UNKNOWN(1,"unknown"),
    ZTE(2,"zte");

    private int vendorEnum;
    private String schemaName;

    VendorEnum(int vendorEnum, String schemaName) {
        this.vendorEnum = vendorEnum;
        this.schemaName = schemaName;
    }


    public int getVendorEnum() {
        return this.vendorEnum;
    }

    public static VendorEnum of(int value) {
        switch (value) {
            case 1:
                return VendorEnum.UNKNOWN;
            case 2:
                return VendorEnum.ZTE;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }

    public static VendorEnum of(String value) {
        switch (value) {
            case "Unknown":
                return VendorEnum.UNKNOWN;
            case "ZTE":
                return VendorEnum.ZTE;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }


}

