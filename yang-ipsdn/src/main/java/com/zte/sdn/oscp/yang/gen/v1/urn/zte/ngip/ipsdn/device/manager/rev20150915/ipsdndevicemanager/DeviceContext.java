package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager;

public abstract class DeviceContext {
    public static String deviceContext2String() {
        return "deviceContext";
    }
    public static Class string2Class(String val) {
        if (val.equals("deviceContext")) {
            return DeviceContext.class;
        }
        throw new IllegalArgumentException("not a valid input element");
    }
}
