package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.ntfbenchmark.rev20150105.ntfbenchmarkmodule.starttest.starttestinput;

public enum ProducerTypeEnum {

    BLOCKING(1,"blocking"),
    DROPPING(2,"dropping");

    private int producerTypeEnum;
    private String schemaName;

    ProducerTypeEnum(int producerTypeEnum, String schemaName) {
        this.producerTypeEnum = producerTypeEnum;
        this.schemaName = schemaName;
    }


    public int getProducerTypeEnum() {
        return this.producerTypeEnum;
    }

    public static ProducerTypeEnum of(int value) {
        switch (value) {
            case 1:
                return ProducerTypeEnum.BLOCKING;
            case 2:
                return ProducerTypeEnum.DROPPING;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }

    public static ProducerTypeEnum of(String value) {
        switch (value) {
            case "BLOCKING":
                return ProducerTypeEnum.BLOCKING;
            case "DROPPING":
                return ProducerTypeEnum.DROPPING;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }


}

