package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.starttest.starttestoutput;

public enum StatusEnum {

    OK(1,"ok"),
    FAILED(2,"failed"),
    TESTINPROGRESS(3,"testInProgress");

    private int statusEnum;
    private String schemaName;

    StatusEnum(int statusEnum, String schemaName) {
        this.statusEnum = statusEnum;
        this.schemaName = schemaName;
    }


    public int getStatusEnum() {
        return this.statusEnum;
    }

    public static StatusEnum of(int value) {
        switch (value) {
            case 1:
                return StatusEnum.OK;
            case 2:
                return StatusEnum.FAILED;
            case 3:
                return StatusEnum.TESTINPROGRESS;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }

    public static StatusEnum of(String value) {
        switch (value) {
            case "OK":
                return StatusEnum.OK;
            case "FAILED":
                return StatusEnum.FAILED;
            case "TEST_IN_PROGRESS":
                return StatusEnum.TESTINPROGRESS;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }


}

