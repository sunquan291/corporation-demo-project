package com.zte.sunquan.demo.jms;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.management.AttributeChangeNotification;
import javax.management.MBeanInfo;
import javax.management.MBeanServer;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by sunquan on 2017/9/18.
 */
public class JSMBeanTest {
    String jmxServerName = "SQTestBean";
    private Person person;
    private ObjectName path;

    @Before
    public void init() throws MalformedObjectNameException {
        person = new Person("sunquan", 28, PersonMBean.Gender.boy,
                Lists.newArrayList("Java8", "Netty"),
                new long[]{1L, 2L},
                new Integer[]{3, 4},
                new byte[]{5, 6},
                Lists.newArrayList(new Hobby("running")));
        //eg.SQTestBean:type=Person,name=sunquan
        path = new ObjectName(jmxServerName + ":type=" + Person.class.getSimpleName()
                + ",name=" + person.getName());
    }

    @Test
    public void testMBean() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        //将mbean绑定到指定path上
        server.registerMBean(person, path);
        TimeUnit.SECONDS.sleep(2);
        //取数据
        MBeanInfo mBeanInfo = server.getMBeanInfo(path);
        Assert.assertEquals(mBeanInfo.getClassName(), Person.class.getName());

        Assert.assertEquals("sunquan", server.getAttribute(path, "Name"));
        Assert.assertEquals(28, server.getAttribute(path, "Age"));
        Assert.assertEquals(PersonMBean.Gender.boy, server.getAttribute(path, "Gender"));
        Assert.assertTrue(((List<String>) server.getAttribute(path, "Hobby")).size() == 1);
        latch.await();
    }

    @Test
    public void testRemoteMBean() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        //将mbean绑定到指定path上
        server.registerMBean(person, path);
        TimeUnit.SECONDS.sleep(2);
        //取数据

        MBeanServerConnection mBeanServerConnection =
                getMBeanServerConnection("service:jmx:rmi:///jndi/rmi://10.42.197.163:1099/jmxrmi", "a", "b");
        MBeanInfo mBeanInfo = mBeanServerConnection.getMBeanInfo(path);

        Assert.assertEquals(mBeanInfo.getClassName(), Person.class.getName());
        Assert.assertEquals("sunquan", server.getAttribute(path, "Name"));
        Assert.assertEquals(28, server.getAttribute(path, "Age"));
        Assert.assertEquals(PersonMBean.Gender.boy, server.getAttribute(path, "Gender"));
        Assert.assertTrue(((List<String>) server.getAttribute(path, "Hobby")).size() == 1);
//        latch.await();
    }

    public static MBeanServerConnection getMBeanServerConnection(final String rmiJmxUrl, final String user, final String password) {
        try {
            if (rmiJmxUrl == null) {
                MBeanServerConnection mbeanServer = ManagementFactory.getPlatformMBeanServer();
                return mbeanServer;
            } else {
                HashMap<String, String[]> environment = new HashMap<String, String[]>();
                if ((user == null) || (password == null)) {
                    String[] creds = {"karaf", "karaf"};
                    environment.put(JMXConnector.CREDENTIALS, creds);
                } else {
                    String[] creds = {user, password};
                    environment.put(JMXConnector.CREDENTIALS, creds);
                }

                if (rmiJmxUrl != null) {
                    JMXServiceURL url = new JMXServiceURL(rmiJmxUrl);
                    JMXConnector connector = JMXConnectorFactory.connect(url, environment);
                    MBeanServerConnection mbeanServer = connector.getMBeanServerConnection();
                    return mbeanServer;
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void dynamicMBean() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName helloName = new ObjectName("jmx:name=dynamicBeanHello");
        server.registerMBean(new BillInfo(), helloName);
        latch.await();
//        HtmlAdaptorServer adaptor  = new HtmlAdaptorServer();
//        ObjectName adaptorName = new ObjectName("jmxAdaptor:name=adaptor,port=5050");
//        server.registerMBean(adaptor, adaptorName);
//        adaptor.setPort(9999);
//        adaptor.start();
        System.out.println("....................jmx server start....................");
    }

    @Test
    public void dynamicMBean2() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName helloName = new ObjectName("jmx:name=dynamicBeanHello");
        Bill bill = new Bill();
        server.registerMBean(bill, helloName);
        Thread.sleep(10000);
        bill.addAttribute();
        latch.await();
    }

    @Test
    public void notifyMBean() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName helloName = new ObjectName("jmx:name=notifyBeanHello");
        Account account = new Account();
        server.registerMBean(account, helloName);
        server.addNotificationListener(helloName, (notification, b) -> {
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
        }, null, null);

        latch.await();
    }
}
