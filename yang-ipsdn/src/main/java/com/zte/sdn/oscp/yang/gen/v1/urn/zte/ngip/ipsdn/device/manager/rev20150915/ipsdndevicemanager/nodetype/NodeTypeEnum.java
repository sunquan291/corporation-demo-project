package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.nodetype;

public enum NodeTypeEnum {

    DCONTROLLER(0,"dController"),
    ACC(1,"acc"),
    AGG(2,"agg"),
    ASBR(3,"asbr"),
    RANPE(4,"ranPe"),
    OCONTROLLER(5,"oController"),
    DNA(6,"dna");

    private int nodeTypeEnum;
    private String schemaName;

    NodeTypeEnum(int nodeTypeEnum, String schemaName) {
        this.nodeTypeEnum = nodeTypeEnum;
        this.schemaName = schemaName;
    }


    public int getNodeTypeEnum() {
        return this.nodeTypeEnum;
    }

    public static NodeTypeEnum of(int value) {
        switch (value) {
            case 0:
                return NodeTypeEnum.DCONTROLLER;
            case 1:
                return NodeTypeEnum.ACC;
            case 2:
                return NodeTypeEnum.AGG;
            case 3:
                return NodeTypeEnum.ASBR;
            case 4:
                return NodeTypeEnum.RANPE;
            case 5:
                return NodeTypeEnum.OCONTROLLER;
            case 6:
                return NodeTypeEnum.DNA;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }

    public static NodeTypeEnum of(String value) {
        switch (value) {
            case "D_CONTROLLER":
                return NodeTypeEnum.DCONTROLLER;
            case "ACC":
                return NodeTypeEnum.ACC;
            case "AGG":
                return NodeTypeEnum.AGG;
            case "ASBR":
                return NodeTypeEnum.ASBR;
            case "RAN_PE":
                return NodeTypeEnum.RANPE;
            case "O_CONTROLLER":
                return NodeTypeEnum.OCONTROLLER;
            case "DNA":
                return NodeTypeEnum.DNA;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }


}

