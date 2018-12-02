package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.ishcontroller;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;

public class IsHcontrollerOutput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "true : h controller, false : d controller."
    */
    @Column
    private Boolean result;


    public Boolean getResult() {
        return this.result;
    }



    public void setResult(Boolean result) {
        this.result = result;
    }
    public void setResult(String result) {
        this.result = Boolean.parseBoolean(result);
    }



}

