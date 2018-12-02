package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.teststatus;

public enum ExecStatusEnum {

    IDLE(1,"idle"),
    EXECUTING(2,"executing");

    private int execStatusEnum;
    private String schemaName;

    ExecStatusEnum(int execStatusEnum, String schemaName) {
        this.execStatusEnum = execStatusEnum;
        this.schemaName = schemaName;
    }


    public int getExecStatusEnum() {
        return this.execStatusEnum;
    }

    public static ExecStatusEnum of(int value) {
        switch (value) {
            case 1:
                return ExecStatusEnum.IDLE;
            case 2:
                return ExecStatusEnum.EXECUTING;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }

    public static ExecStatusEnum of(String value) {
        switch (value) {
            case "idle":
                return ExecStatusEnum.IDLE;
            case "executing":
                return ExecStatusEnum.EXECUTING;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }


}

