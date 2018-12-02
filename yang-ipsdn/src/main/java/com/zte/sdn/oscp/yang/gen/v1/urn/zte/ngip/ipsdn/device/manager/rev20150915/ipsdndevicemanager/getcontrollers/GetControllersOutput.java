package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getcontrollers;

import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getcontrollers.getcontrollersoutput.ControllerImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getcontrollers.getcontrollersoutput.Controller;
import java.util.Set;
import java.util.LinkedHashSet;

public class GetControllersOutput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =ControllerImpl.class, associateLoad = false, associateSave = false)
    private Set<Controller> controller = new LinkedHashSet<Controller>();


    public Set<Controller> getController() {
        return this.controller;
    }

    public Controller getFromController(String key) {
        return this.controller.stream().filter(value ->
                value.getNodeId().equals(key))
                .findFirst().get();
    }

    public void setController(Set<Controller> controller) {
        this.controller = controller;
    }



}

