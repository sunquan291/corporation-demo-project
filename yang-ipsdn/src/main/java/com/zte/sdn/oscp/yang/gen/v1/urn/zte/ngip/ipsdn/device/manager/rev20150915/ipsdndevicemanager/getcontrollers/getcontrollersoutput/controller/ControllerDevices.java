package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getcontrollers.getcontrollersoutput.controller;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getcontrollers.getcontrollersoutput.controller.controllerdevices.DeviceGroup;
import com.zte.sdn.oscp.persistence.annotations.Table;
import java.util.Set;

@Table
public interface ControllerDevices {

    Set<DeviceGroup> getDeviceGroup();

    DeviceGroup getFromDeviceGroup(String key);
    String getParentPath();


    void  setDeviceGroup(Set<DeviceGroup> deviceGroup);

    void setParentPath(String parentPath);


    void addToDeviceGroup(DeviceGroup addTo);


    void removeFromDeviceGroup(String key);


}

