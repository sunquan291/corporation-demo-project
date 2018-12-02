package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.controllers;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeId;
import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.controllers.controller.ControllerDetail;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.controllers.controller.ControllerDevices;

@Table
public interface Controller {

    NodeId getNodeId();

    ControllerDetail getControllerDetail();

    ControllerDevices getControllerDevices();

    String getParentPath();


    /**
     *
     * @param nodeId 
    */
    void setNodeId(NodeId nodeId);

    void setControllerDetail(ControllerDetail controllerDetail);

    void setControllerDevices(ControllerDevices controllerDevices);

    void setParentPath(String parentPath);


}

