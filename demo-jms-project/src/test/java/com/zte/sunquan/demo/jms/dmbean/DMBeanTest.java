package com.zte.sunquan.demo.jms.dmbean;

import java.lang.management.ManagementFactory;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.management.AttributeChangeNotification;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

import org.junit.Before;
import org.junit.Test;

import com.zte.sunquan.demo.jms.mbean.Hobby;
import com.zte.sunquan.demo.jms.utils.MBeanServerUtils;

/**
 * Created by 10184538 on 2018/5/29.
 */
public class DMBeanTest {

    String jmxServerName = "SQTestBean";
    private BillInfo billInfo;
    private ObjectName path;

    @Before
    public void init() throws MalformedObjectNameException {
        billInfo = new BillInfo("sunquan");
        //eg.SQTestBean:type=Person,name=sunquan
        path = new ObjectName(jmxServerName + ":type=" + BillInfo.class.getSimpleName()
                + ",name=" + billInfo.getAttribute("name"));
    }

    @Test
    public void dynamicMBean() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        server.registerMBean(billInfo, path);
        latch.await();
//        HtmlAdaptorServer adaptor  = new HtmlAdaptorServer();
//        ObjectName adaptorName = new ObjectName("jmxAdaptor:name=adaptor,port=5050");
//        server.registerMBean(adaptor, adaptorName);
//        adaptor.setPort(9999);
//        adaptor.start();
        latch.await();
    }

    @Test
    public void dynamicMBeanOperation() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        server.registerMBean(billInfo, path);
        MBeanOperationInfo info = new MBeanOperationInfo("print", "print(): print the name", null,
                "void", MBeanOperationInfo.INFO);
        billInfo.addOperation(info);
        latch.await();
    }

    @Test
    public void dynamicMBeanSenior() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        UserDomain domain = new UserDomain();
        ObjectName objectName = new ObjectName(jmxServerName + ":type=" + UserDomain.class.getSimpleName()
                + ",name=user");
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        server.registerMBean(domain, objectName);

        TimeUnit.SECONDS.sleep(15);

        domain.setName("sunquan");
        domain.setAge(28);

        latch.await();
    }

    @Test
    public void dynamicMBeanSenior2() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        UserDomain domain = new UserDomain("sunquan");
        domain.registerMBean();
        domain.registerNotificationListener((notification, b) -> {
            System.out.println("SequenceNumber:" + notification.getSequenceNumber());
            System.out.println("Type:" + notification.getType());
            System.out.println("Message:" + notification.getMessage());
            System.out.println("Source:" + notification.getSource());
            System.out.println("TimeStamp:" + notification.getTimeStamp());
            System.out.println("userData:" + notification.getUserData());
            System.out.println("bach:" + b);
            if (notification instanceof AttributeChangeNotification) {
                AttributeChangeNotification no = (AttributeChangeNotification) notification;
                System.out.println("OldValue:" + no.getOldValue());
                System.out.println("NewValue:" + no.getNewValue());
            }
        });

        TimeUnit.SECONDS.sleep(20);
        domain.setAge(100);
        domain.setHobby(new Hobby("running"));
        domain.setChild(new AtomicInteger(1));
        latch.await();
    }
    @Test
    public void dynamicMBeanSenior3() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        UserDomain domain = new UserDomain();
        ObjectName objectName = new ObjectName(jmxServerName + ":type=" + UserDomain.class.getSimpleName()
                + ",name=user");
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        server.registerMBean(domain, objectName);
        TimeUnit.SECONDS.sleep(5);
        domain.setName("sunquan");
        domain.setAge(28);
        //execute operation print   OSGI command
        server.invoke(objectName,"print",null,null);
        latch.await();
    }


}
