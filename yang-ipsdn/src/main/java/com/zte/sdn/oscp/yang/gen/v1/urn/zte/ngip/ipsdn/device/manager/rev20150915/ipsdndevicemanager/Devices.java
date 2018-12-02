package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.Plugin;
import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.Controllers;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.Device;
import java.util.Set;

@Table
public interface Devices {

    Plugin getPlugin();

    Controllers getControllers();

    Set<Device> getDevice();

    Device getFromDevice(String key);
    String getParentPath();


    void setPlugin(Plugin plugin);

    void setControllers(Controllers controllers);

    void  setDevice(Set<Device> device);

    void setParentPath(String parentPath);


    void addToDevice(Device addTo);


    void removeFromDevice(String key);


}

