package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.starttest.starttestinput;

public enum DataFormatEnum {

    BINDINGAWARE(1,"bindingAware"),
    BINDINGINDEPENDENT(2,"bindingIndependent");

    private int dataFormatEnum;
    private String schemaName;

    DataFormatEnum(int dataFormatEnum, String schemaName) {
        this.dataFormatEnum = dataFormatEnum;
        this.schemaName = schemaName;
    }


    public int getDataFormatEnum() {
        return this.dataFormatEnum;
    }

    public static DataFormatEnum of(int value) {
        switch (value) {
            case 1:
                return DataFormatEnum.BINDINGAWARE;
            case 2:
                return DataFormatEnum.BINDINGINDEPENDENT;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }

    public static DataFormatEnum of(String value) {
        switch (value) {
            case "BINDING_AWARE":
                return DataFormatEnum.BINDINGAWARE;
            case "BINDING_INDEPENDENT":
                return DataFormatEnum.BINDINGINDEPENDENT;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }


}

