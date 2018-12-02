package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.base.model.rev20170329.basemodel.switchportmode;

public enum SwitchPortModeEnum {

    ACCESS(1,"access"),
    TRUNK(2,"trunk"),
    HYBRID(3,"hybrid");

    private int switchPortModeEnum;
    private String schemaName;

    SwitchPortModeEnum(int switchPortModeEnum, String schemaName) {
        this.switchPortModeEnum = switchPortModeEnum;
        this.schemaName = schemaName;
    }


    public int getSwitchPortModeEnum() {
        return this.switchPortModeEnum;
    }

    public static SwitchPortModeEnum of(int value) {
        switch (value) {
            case 1:
                return SwitchPortModeEnum.ACCESS;
            case 2:
                return SwitchPortModeEnum.TRUNK;
            case 3:
                return SwitchPortModeEnum.HYBRID;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }

    public static SwitchPortModeEnum of(String value) {
        switch (value) {
            case "access":
                return SwitchPortModeEnum.ACCESS;
            case "trunk":
                return SwitchPortModeEnum.TRUNK;
            case "hybrid":
                return SwitchPortModeEnum.HYBRID;
            default:
                throw new IllegalArgumentException("not a valid input element");
        }
    }


}

