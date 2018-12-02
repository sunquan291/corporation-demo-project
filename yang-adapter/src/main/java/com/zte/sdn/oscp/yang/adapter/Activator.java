package com.zte.sdn.oscp.yang.adapter;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Component;

/**
 * Created by 10184538 on 2017/11/24.
 */
@Component
public class Activator implements BundleActivator {
    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("start.....");
        context.addServiceListener(new ServiceListener() {
            @Override
            public void serviceChanged(ServiceEvent event) {
                ServiceReference<?> serviceReference = event.getServiceReference();
                if (serviceReference != null) {
                    Object service = context.getService(serviceReference);
                    System.out.println("Got Service:" + serviceReference + "----" + service);
                }
            }
        });
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("stop.....");
    }
}
