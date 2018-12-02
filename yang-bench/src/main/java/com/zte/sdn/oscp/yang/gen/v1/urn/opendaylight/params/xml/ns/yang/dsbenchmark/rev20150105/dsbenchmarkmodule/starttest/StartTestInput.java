package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.starttest;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.starttest.starttestinput.DataFormatEnum;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.starttest.starttestinput.TransactionTypeEnum;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.starttest.starttestinput.OperationEnum;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.starttest.starttestinput.DataStoreEnum;

public class StartTestInput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "Type of the transaction operation to benchmark"
    */
    private OperationEnum operation;
    private int operationValue;

    /**
     * "Data format:-binding-aware or binding-independent"
    */
    private DataFormatEnum dataFormat;
    private int dataFormatValue;

    /**
     * "Data format:-binding-aware or binding-independent"
    */
    private TransactionTypeEnum transactionType;
    private int transactionTypeValue;

    private DataStoreEnum dataStore;
    private int dataStoreValue;

    /**
     * "Number of elements in the OuterList"
    */
    @Column
    private Long outerElements = 100000L;

    /**
     * "Number of elements in the InnerList"
    */
    @Column
    private Long innerElements = 1L;

    /**
     * "Number of write operations (PUT, MERGE, or DELETE)
                   per transaction submit"
    */
    @Column
    private Long putsPerTx = 1L;

    /**
     * "Number of data tree change listeners listening for
                    changes on the test exec tree."
    */
    @Column
    private Long listeners = 0L;


    public OperationEnum getOperation() {
        this.operation =  OperationEnum.of(operationValue);
        return this.operation;
    }


    public DataFormatEnum getDataFormat() {
        this.dataFormat =  DataFormatEnum.of(dataFormatValue);
        return this.dataFormat;
    }


    public TransactionTypeEnum getTransactionType() {
        this.transactionType =  TransactionTypeEnum.of(transactionTypeValue);
        return this.transactionType;
    }


    public DataStoreEnum getDataStore() {
        this.dataStore =  DataStoreEnum.of(dataStoreValue);
        return this.dataStore;
    }


    public Long getOuterElements() {
        return this.outerElements;
    }


    public Long getInnerElements() {
        return this.innerElements;
    }


    public Long getPutsPerTx() {
        return this.putsPerTx;
    }


    public Long getListeners() {
        return this.listeners;
    }



    public void setOperation(OperationEnum operation) {
        this.operation = operation;
        this.operationValue =  operation.getOperationEnum();
    }

    public void setDataFormat(DataFormatEnum dataFormat) {
        this.dataFormat = dataFormat;
        this.dataFormatValue =  dataFormat.getDataFormatEnum();
    }

    public void setTransactionType(TransactionTypeEnum transactionType) {
        this.transactionType = transactionType;
        this.transactionTypeValue =  transactionType.getTransactionTypeEnum();
    }

    public void setDataStore(DataStoreEnum dataStore) {
        this.dataStore = dataStore;
        this.dataStoreValue =  dataStore.getDataStoreEnum();
    }

    public void setOuterElements(Long outerElements) {
        this.outerElements = outerElements;
    }
    public void setOuterElements(String outerElements) {
        this.outerElements = Long.parseLong(outerElements);
    }

    public void setInnerElements(Long innerElements) {
        this.innerElements = innerElements;
    }
    public void setInnerElements(String innerElements) {
        this.innerElements = Long.parseLong(innerElements);
    }

    public void setPutsPerTx(Long putsPerTx) {
        this.putsPerTx = putsPerTx;
    }
    public void setPutsPerTx(String putsPerTx) {
        this.putsPerTx = Long.parseLong(putsPerTx);
    }

    public void setListeners(Long listeners) {
        this.listeners = listeners;
    }
    public void setListeners(String listeners) {
        this.listeners = Long.parseLong(listeners);
    }



}

