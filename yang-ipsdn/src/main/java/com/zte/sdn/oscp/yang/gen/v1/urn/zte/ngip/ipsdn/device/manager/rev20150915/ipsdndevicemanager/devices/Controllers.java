package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.controllers.Controller;
import com.zte.sdn.oscp.persistence.annotations.Table;
import java.util.Set;

@Table
public interface Controllers {

    Set<Controller> getController();

    Controller getFromController(String key);
    String getParentPath();


    void  setController(Set<Controller> controller);

    void setParentPath(String parentPath);


    void addToController(Controller addTo);


    void removeFromController(String key);


}

