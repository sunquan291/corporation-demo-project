package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.DeviceImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.Plugin;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.PluginImpl;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.Controllers;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.ControllersImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.Device;
import java.util.Set;
import java.util.LinkedHashSet;

public class DevicesImpl implements Devices {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = PluginImpl.class)
    private Plugin plugin = new PluginImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = ControllersImpl.class)
    private Controllers controllers = new ControllersImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =DeviceImpl.class, associateLoad = false, associateSave = false)
    private Set<Device> device = new LinkedHashSet<Device>();

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public Plugin getPlugin() {
        return this.plugin;
    }


    @Override
    public Controllers getControllers() {
        return this.controllers;
    }


    @Override
    public Set<Device> getDevice() {
        return this.device;
    }

    @Override
    public Device getFromDevice(String key) {
        return this.device.stream().filter(value ->
                value.getNodeId().equals(key))
                .findFirst().get();
    }
    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setPlugin(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void setControllers(Controllers controllers) {
        this.controllers = controllers;
    }

    @Override
    public void setDevice(Set<Device> device) {
        this.device = device;
    }

    @Override
    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }


    public void addToDevice(Device addTo) {
        device.add(addTo);
    }


    @Override
    public void removeFromDevice(String key) {
        Iterator<Device> iterator = this.device.iterator();
        while (iterator.hasNext()) {
            Device next = iterator.next();
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
        DevicesImpl other = (DevicesImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

