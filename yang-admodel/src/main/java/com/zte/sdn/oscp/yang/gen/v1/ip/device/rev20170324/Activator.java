package com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20170324;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Component;

/**
 * Created by 10184538 on 2017/11/24.
 */
@Component
public class Activator implements BundleActivator {
    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("start.....");
        context.registerService(SQPrintService.class, new SQPrintServiceImpl(), null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("stop.....");
    }
}
