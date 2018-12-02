package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.starttest.starttestinput;

public enum TransactionTypeEnum {

    SIMPLETX(1,"simpleTx"),
    TXCHAINING(2,"txChaining");

    private int transactionTypeEnum;
    private String schemaName;

    TransactionTypeEnum(int transactionTypeEnum, String schemaName) {
        this.transactionTypeEnum = transactionTypeEnum;
        this.schemaName = schemaName;
    }


    public int getTransactionTypeEnum() {
        return this.transactionTypeEnum;
    }

    public static TransactionTypeEnum of(int value) {
        switch (value) {
            case 1:
                return TransactionTypeEnum.SIMPLETX;
            case 2:
                return TransactionTypeEnum.TXCHAINING;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }

    public static TransactionTypeEnum of(String value) {
        switch (value) {
            case "SIMPLE_TX":
                return TransactionTypeEnum.SIMPLETX;
            case "TX_CHAINING":
                return TransactionTypeEnum.TXCHAINING;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }


}

