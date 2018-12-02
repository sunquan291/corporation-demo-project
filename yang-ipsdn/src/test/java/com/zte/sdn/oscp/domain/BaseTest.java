package com.zte.sdn.oscp.domain;

import com.zte.sdn.oscp.persistence.exceptions.TableException;
import com.zte.sdn.oscp.persistence.model.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.Uri;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.UriImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeId;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.inventory.rev20130819.opendaylightinventory.NodeIdImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.Devices;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.DevicesImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.Controllers;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.ControllersImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.Device;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.DeviceImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.controllers.Controller;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.controllers.ControllerImpl;
import org.junit.Test;

import java.util.List;

/**
 * Created by 10184538 on 2017/8/22.
 */
public class BaseTest extends BaseBeanORMTest {

    @Test
    public void testTableCreate() {
        testTableCreate(getTable(DevicesImpl.class));
    }

    @Test
    public void testA(){
        String a="a"+"\\";
        System.out.println(a.replace("\\","\\\\"));
    }

    @Test
    public void test() {
        Devices devices = new DevicesImpl();

        Device device = new DeviceImpl();
        device.setDeviceType("zte device type");
        devices.addToDevice(device);

        Controllers controllers = new ControllersImpl();

        Controller controller = new ControllerImpl();
        NodeId nodeId = new NodeIdImpl();
        Uri uri = new UriImpl();
        uri.setString("uri content");
        nodeId.setUri(uri);
        controller.setNodeId(nodeId);
        controllers.addToController(controller);

        devices.setControllers(controllers);
    }

    protected void testTableCreate(Table table) throws TableException {
        if (table.exists())
            table.drop();

        table.create();
    }
}
