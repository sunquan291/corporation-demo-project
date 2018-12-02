package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.operationtype;

public enum OperationTypeEnum {

    CREATE(1,"create"),
    REMOVE(2,"remove"),
    UPDATE(3,"update");

    private int operationTypeEnum;
    private String schemaName;

    OperationTypeEnum(int operationTypeEnum, String schemaName) {
        this.operationTypeEnum = operationTypeEnum;
        this.schemaName = schemaName;
    }


    public int getOperationTypeEnum() {
        return this.operationTypeEnum;
    }

    public static OperationTypeEnum of(int value) {
        switch (value) {
            case 1:
                return OperationTypeEnum.CREATE;
            case 2:
                return OperationTypeEnum.REMOVE;
            case 3:
                return OperationTypeEnum.UPDATE;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }

    public static OperationTypeEnum of(String value) {
        switch (value) {
            case "create":
                return OperationTypeEnum.CREATE;
            case "remove":
                return OperationTypeEnum.REMOVE;
            case "update":
                return OperationTypeEnum.UPDATE;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }


}

