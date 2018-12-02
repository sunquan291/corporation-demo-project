package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.starttest.starttestinput;

public enum OperationEnum {

    PUT(1,"put"),
    MERGE(2,"merge"),
    DELETE(3,"delete"),
    READ(4,"read");

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
                return OperationEnum.PUT;
            case 2:
                return OperationEnum.MERGE;
            case 3:
                return OperationEnum.DELETE;
            case 4:
                return OperationEnum.READ;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }

    public static OperationEnum of(String value) {
        switch (value) {
            case "PUT":
                return OperationEnum.PUT;
            case "MERGE":
                return OperationEnum.MERGE;
            case "DELETE":
                return OperationEnum.DELETE;
            case "READ":
                return OperationEnum.READ;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }


}

