package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getdevicemodelbynodeid;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.DeviceModelImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.DeviceModel;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;

public class GetDeviceModelByNodeIdOutput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "The type of the device."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = DeviceModelImpl.class)
    private DeviceModel deviceModel = new DeviceModelImpl();


    public DeviceModel getDeviceModel() {
        return this.deviceModel;
    }



    public void setDeviceModel(DeviceModel deviceModel) {
        this.deviceModel = deviceModel;
    }



}

