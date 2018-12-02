package com.zte.sunquan.demo.hello.impl;

import com.zte.sunquan.demo.hello.ByeService;
import com.zte.sunquan.demo.hello.HelloService;
import org.apache.felix.scr.annotations.*;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * Created by 10184538 on 2017/1/12.
 */
@Component(immediate = true)
@Service
public class ByeImpl implements ByeService {

    @Reference(cardinality = ReferenceCardinality.OPTIONAL_UNARY)
    private HelloService helloService;

    @Activate
    protected void activate() {
        System.out.println("ByeImpl activate");
        System.out.println("when ByImpl start HelloService is:" + helloService);
    }

    @Deactivate
    protected void deActivate() {
        System.out.println("ByeImpl deActivate");
    }

    @Override
    public String sayGoodBye(String name) {
        return "goodbye " + name;
    }

    @Override
    public String sayBye(String name) {
        System.out.println("when ByImpl invoke HelloService is:" + helloService);
        if (helloService != null){
            helloService=getService(HelloService.class);
            return helloService.sayNice(name);
        }

        return "NULL";
    }
    public static <T> T getService(Class<T> serviceClass) {
        BundleContext bc = FrameworkUtil.getBundle(serviceClass).getBundleContext();
        if (bc != null) {
            ServiceReference<T> reference = bc.getServiceReference(serviceClass);
            if (reference != null) {
                T impl = bc.getService(reference);
                if (impl != null) {
                    return impl;
                }
            }
        }
        throw new RuntimeException("Service " + serviceClass.getName() + " not found");
    }
}
