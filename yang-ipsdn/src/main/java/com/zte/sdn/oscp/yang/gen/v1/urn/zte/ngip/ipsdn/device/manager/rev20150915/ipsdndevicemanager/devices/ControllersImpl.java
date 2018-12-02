package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.controllers.Controller;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.controllers.ControllerImpl;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import java.util.Set;
import java.util.LinkedHashSet;

public class ControllersImpl implements Controllers {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =ControllerImpl.class, associateLoad = false, associateSave = false)
    private Set<Controller> controller = new LinkedHashSet<Controller>();

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public Set<Controller> getController() {
        return this.controller;
    }

    @Override
    public Controller getFromController(String key) {
        return this.controller.stream().filter(value ->
                value.getNodeId().equals(key))
                .findFirst().get();
    }
    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setController(Set<Controller> controller) {
        this.controller = controller;
    }

    @Override
    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }


    public void addToController(Controller addTo) {
        controller.add(addTo);
    }


    @Override
    public void removeFromController(String key) {
        Iterator<Controller> iterator = this.controller.iterator();
        while (iterator.hasNext()) {
            Controller next = iterator.next();
            if (next.getNodeId().equals(key))
                iterator.remove();
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(primaryId,parentPath);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ControllersImpl other = (ControllersImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

