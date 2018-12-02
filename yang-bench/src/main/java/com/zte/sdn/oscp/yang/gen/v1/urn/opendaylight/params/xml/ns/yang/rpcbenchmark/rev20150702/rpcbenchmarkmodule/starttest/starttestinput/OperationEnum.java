package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.rpcbenchmark.rev20150702.rpcbenchmarkmodule.starttest.starttestinput;

public enum OperationEnum {

    GLOBALRTC(1,"globalRtc"),
    ROUTEDRTC(2,"routedRtc");

    private int operationEnum;
    private String schemaName;

    OperationEnum(int operationEnum, String schemaName) {
        this.operationEnum = operationEnum;
        this.schemaName = schemaName;
    }


    public int getOperationEnum() {
        return this.operationEnum;
    }

    public static OperationEnum of(int value) {
        switch (value) {
            case 1:
                return OperationEnum.GLOBALRTC;
            case 2:
                return OperationEnum.ROUTEDRTC;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }

    public static OperationEnum of(String value) {
        switch (value) {
            case "GLOBAL_RTC":
                return OperationEnum.GLOBALRTC;
            case "ROUTED_RTC":
                return OperationEnum.ROUTEDRTC;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }


}

