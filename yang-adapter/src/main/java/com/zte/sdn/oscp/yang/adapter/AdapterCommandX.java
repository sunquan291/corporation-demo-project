package com.zte.sdn.oscp.yang.adapter;

import com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20170324.NetconfState;
import org.apache.felix.scr.annotations.Component;
import org.apache.karaf.shell.commands.Argument;
import org.apache.karaf.shell.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;

import javax.xml.bind.JAXBContext;

/**
 * Created by 10184538 on 2017/1/13.
 */
@Component(immediate = true)
@Command(scope = "oscp", name = "adapter", description = "oscp adapter command")
public class AdapterCommandX extends OsgiCommandSupport {
    private static final String PRETTY = "-pretty";
    private static final String SHORT_PRETTY = "-p";

    private static final String SIZE = "-size";
    private static final String SHORT_SIZE = "-s";

    @Argument(index = 0, name = "command",
            description = "[help]",
            required = true, multiValued = false)
    private String command = "help";

    @Argument(index = 1, name = "argument1",
            description = "argument 1",
            required = false, multiValued = false)
    private String arg1 = "";
    @Argument(index = 2, name = "argument2",
            description = "argument 2",
            required = false, multiValued = false)
    private String arg2 = "";
    @Argument(index = 3, name = "argument3",
            description = "argument 3",
            required = false, multiValued = false)
    private String arg3 = "";

    private String clsName = "com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20170324.NetworkImpl";

    @Override
    protected Object doExecute() throws Exception {

        switch (command) {
            case "class":
                System.out.println("aaaaaaaaaaaaaaaaa");
//                BundleUtils.go();
                JAXBContext jaxbContext = JAXBContext.newInstance(NetconfState.class);
                System.out.println(jaxbContext);
//                Optional.ofNullable(FrameworkUtil.getBundle(ClassRegister.class))
//                        .map(Bundle::getBundleContext);
//                        .map(BundleContext::getBundles);
//                Class cls = Optional.ofNullable(FrameworkUtil.getBundle(ClassRegister.class))
//                        .map(Bundle::getBundleContext)
//                        .map(BundleContext::getBundles)
//                        .flatMap(bundles -> Arrays.stream(bundles).map(bundle ->
//                                loadClass(bundle, clsName))
//                                .filter(clazz -> clazz != null)
//                                .findFirst())
//                        .orElse(null);
//                System.out.println(cls);
                break;
            case "class2":
                JAXBContext jaxbContext2 = JAXBContext.newInstance(BundleUtils.class);
                System.out.println(jaxbContext2);
                break;
            case "class3":
                ClassLoader contextClassLoader = getContextClassLoader();
                System.out.println(contextClassLoader);
                Class cls = contextClassLoader.loadClass("com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20170324.NetconfState");
                System.out.println(cls);
                break;
//                Class<?> aClass = ClassLoader.getSystemClassLoader().loadClass("com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20170324.NetconfState");
//                System.out.println("cls1:" + aClass);
//                Class<?> a2 = Class.forName("com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20170324.NetconfState");
//                System.out.println("cls2:" + a2);
            case "class4":
                JAXBContext jaxbContext3 = JAXBContext.newInstance("org.opendaylight.netconf.monitoring.xml.model.NetconfState");
                System.out.println(jaxbContext3);
                break;
            case "class5":
                JAXBContext jaxbContext5 = JAXBContext.newInstance("com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20170324.NetconfState");
                System.out.println(jaxbContext5);
                break;
            case "class6":
                ClassLoader contextClassLoader2 = getContextClassLoader();
                System.out.println("1" + contextClassLoader2);
                Class cls2 = contextClassLoader2.loadClass("org.opendaylight.netconf.monitoring.xml.model.NetconfState");
                System.out.println("2" + cls2);
                JAXBContext jaxbContext1 = JAXBContext.newInstance(cls2);
                System.out.println("3" + jaxbContext1);

                break;
            case "class7":
                new JaxBSerializer();
                break;

            default:
                System.out.printf("incorrect command: %s", command);
                break;
        }
        return null;
    }

    private static ClassLoader getContextClassLoader() {
        if (System.getSecurityManager() == null) {
            return Thread.currentThread().getContextClassLoader();
        } else {
            return (ClassLoader) java.security.AccessController.doPrivileged(
                    new java.security.PrivilegedAction() {
                        public java.lang.Object run() {
                            return Thread.currentThread().getContextClassLoader();
                        }
                    });
        }
    }
}
