//package com.zte.sdn.oscp.yang.adapter.cli;
package com.zte.sdn.oscp.yang.adapter;
//
//import com.zte.sdn.oscp.commons.serialize.binary.protostuff.ClassRegister;
//import org.osgi.framework.Bundle;
//import org.osgi.framework.BundleContext;
//import org.osgi.framework.FrameworkUtil;
//
//import java.util.Arrays;
//import java.util.Optional;
//
///**
// * Created by 10184538 on 2017/8/2.
// */
public class BundleUtils {
//    private static String clsName = "com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20170324.NetworkImpl";
//    public static void go(){
//                Class cls = Optional.ofNullable(FrameworkUtil.getBundle(ClassRegister.class))
//                        .map(Bundle::getBundleContext)
//                        .map(BundleContext::getBundles)
//                        .flatMap(bundles -> Arrays.stream(bundles).map(bundle ->
//                                loadClass(bundle, clsName))
//                                .filter(clazz -> clazz != null)
//                                .findFirst())
//                        .orElse(null);
//                System.out.println(cls);
//    }
//    private static Class<?> loadClass(Bundle bundle, String className) {
//        Class<?> clazz = null;
//        try {
//            clazz = bundle.loadClass(className);
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        return clazz;
//    }
}
