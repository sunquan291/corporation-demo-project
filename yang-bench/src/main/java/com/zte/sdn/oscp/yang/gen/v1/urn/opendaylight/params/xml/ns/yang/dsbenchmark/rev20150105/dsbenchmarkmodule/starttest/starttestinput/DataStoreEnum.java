package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.starttest.starttestinput;

public enum DataStoreEnum {

    CONFIG(1,"config"),
    OPERATIONAL(2,"operational"),
    BOTH(3,"both");

    private int dataStoreEnum;
    private String schemaName;

    DataStoreEnum(int dataStoreEnum, String schemaName) {
        this.dataStoreEnum = dataStoreEnum;
        this.schemaName = schemaName;
    }


    public int getDataStoreEnum() {
        return this.dataStoreEnum;
    }

    public static DataStoreEnum of(int value) {
        switch (value) {
            case 1:
                return DataStoreEnum.CONFIG;
            case 2:
                return DataStoreEnum.OPERATIONAL;
            case 3:
                return DataStoreEnum.BOTH;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }

    public static DataStoreEnum of(String value) {
        switch (value) {
            case "CONFIG":
                return DataStoreEnum.CONFIG;
            case "OPERATIONAL":
                return DataStoreEnum.OPERATIONAL;
            case "BOTH":
                return DataStoreEnum.BOTH;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }


}

