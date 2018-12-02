package com.zte.sunquan.demo.jms.mbean;

import static com.zte.sunquan.demo.jms.utils.MBeanServerUtils.getMBeanServerConnection;

import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.management.MBeanInfo;
import javax.management.MBeanServer;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * Created by 10184538 on 2018/5/29.
 */
@SuppressWarnings("unchecked")
public class MBeanTest {
    private String jmxServerName = "SQTestBean";
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
        System.out.println(server.getAttribute(path, "Gender"));
        Assert.assertTrue(((List<Hobby>) server.getAttribute(path, "Hobby")).size() == 1);
        Assert.assertTrue(((List<Hobby>) server.getAttribute(path, "Hobby")).get(0).getName().equals("running"));
        Assert.assertTrue(((List<String>) server.getAttribute(path, "HobbyContent")).get(0).equals("running"));
        latch.await();
    }

    @Test
    public void testRemoteMBean() throws Exception {
        //设置运行参数
        //-Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=1099
        //-Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false

        //-Djava.rmi.server.hostname=10.42.197.163
        //如果设置认证则比较麻烦
        //-Dcom.sun.management.jmxremote.username=karaf
        //-Dcom.sun.management.jmxremote.password=karaf
        //-Dcom.sun.management.jmxremote.password.file=
        //-Dcom.sun.management.jmxremote.access.file=

        CountDownLatch latch = new CountDownLatch(1);
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        //将mbean绑定到指定path上
        server.registerMBean(person, path);
        TimeUnit.SECONDS.sleep(2);

        MBeanServerConnection mBeanServerConnection =
                getMBeanServerConnection("service:jmx:rmi:///jndi/rmi://10.42.197.163:1099/jmxrmi", "karaf", "karaf");
        MBeanInfo mBeanInfo = mBeanServerConnection.getMBeanInfo(path);

        Assert.assertEquals(mBeanInfo.getClassName(), Person.class.getName());
        Assert.assertEquals("sunquan", server.getAttribute(path, "Name"));
        Assert.assertEquals(28, server.getAttribute(path, "Age"));
        Assert.assertEquals(PersonMBean.Gender.boy, server.getAttribute(path, "Gender"));
        List<Hobby> hobbies = (List<Hobby>) server.getAttribute(path, "Hobby");
        Assert.assertTrue(hobbies.size() == 1);
        Assert.assertTrue(hobbies.get(0).getName().equals("running"));
//        latch.await();
    }

    @Test
    public void testRemoteMBeanNoPassword() throws Exception {
        //设置运行参数
        CountDownLatch latch = new CountDownLatch(1);
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        server.registerMBean(person, path);
        TimeUnit.SECONDS.sleep(2);

        MBeanServerConnection mBeanServerConnection =
                getMBeanServerConnection("10.42.197.163", "1099");
        MBeanInfo mBeanInfo = mBeanServerConnection.getMBeanInfo(path);

        Assert.assertEquals(mBeanInfo.getClassName(), Person.class.getName());
        Assert.assertEquals("sunquan", server.getAttribute(path, "Name"));
        Assert.assertEquals(28, server.getAttribute(path, "Age"));
        Assert.assertEquals(PersonMBean.Gender.boy, server.getAttribute(path, "Gender"));
        List<Hobby> hobbies = (List<Hobby>) server.getAttribute(path, "Hobby");
        Assert.assertTrue(hobbies.size() == 1);
        Assert.assertTrue(hobbies.get(0).getName().equals("running"));
//        latch.await();
    }
}
