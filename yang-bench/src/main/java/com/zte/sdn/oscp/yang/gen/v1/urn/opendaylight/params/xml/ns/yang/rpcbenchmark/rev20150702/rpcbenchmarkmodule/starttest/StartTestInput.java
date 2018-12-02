package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.rpcbenchmark.rev20150702.rpcbenchmarkmodule.starttest;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.rpcbenchmark.rev20150702.rpcbenchmarkmodule.starttest.starttestinput.OperationEnum;

public class StartTestInput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "RPC type and client type to use in the test"
    */
    private OperationEnum operation;
    private int operationValue;

    /**
     * "Number of clients (test client threads) to start"
    */
    @Column
    private Long numClients = 1L;

    /**
     * "Number of RPC server instances. Only valid for routed RPCs."
    */
    @Column
    private Long numServers = 1L;

    /**
     * "Input/Output payload size: number of elements in the list of integers that is the input and output RPC payload"
    */
    @Column
    private Long payloadSize = 1L;

    /**
     * "Number of calls to the specified RPC server that is to be made by each client"
    */
    @Column
    private Long iterations = 1L;


    public OperationEnum getOperation() {
        this.operation =  OperationEnum.of(operationValue);
        return this.operation;
    }


    public Long getNumClients() {
        return this.numClients;
    }


    public Long getNumServers() {
        return this.numServers;
    }


    public Long getPayloadSize() {
        return this.payloadSize;
    }


    public Long getIterations() {
        return this.iterations;
    }



    public void setOperation(OperationEnum operation) {
        this.operation = operation;
        this.operationValue =  operation.getOperationEnum();
    }

    public void setNumClients(Long numClients) {
        this.numClients = numClients;
    }
    public void setNumClients(String numClients) {
        this.numClients = Long.parseLong(numClients);
    }

    public void setNumServers(Long numServers) {
        this.numServers = numServers;
    }
    public void setNumServers(String numServers) {
        this.numServers = Long.parseLong(numServers);
    }

    public void setPayloadSize(Long payloadSize) {
        this.payloadSize = payloadSize;
    }
    public void setPayloadSize(String payloadSize) {
        this.payloadSize = Long.parseLong(payloadSize);
    }

    public void setIterations(Long iterations) {
        this.iterations = iterations;
    }
    public void setIterations(String iterations) {
        this.iterations = Long.parseLong(iterations);
    }



}

