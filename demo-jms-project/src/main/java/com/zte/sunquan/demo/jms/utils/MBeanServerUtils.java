package com.zte.sunquan.demo.jms.utils;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.text.MessageFormat;
import java.util.HashMap;
import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

/**
 * Created by 10184538 on 2018/5/29.
 */
public class MBeanServerUtils {
    private static final String USER_NAME = "karaf";
    private static final String PASSWORD = "karaf";

    private static final String RMI_JMX_URL_PATTERN = "service:jmx:rmi:///jndi/rmi://{0}:{1}/jmxrmi";

    public static MBeanServerConnection getMBeanServerConnection(final String ip, final String port) {
        String rmiJmxUrl = MessageFormat.format(RMI_JMX_URL_PATTERN, ip, port);
        return getMBeanServerConnection(rmiJmxUrl);
    }

    public static MBeanServerConnection getMBeanServerConnection(final String rmiJmxUrl) {
        HashMap<String, String[]> environment = new HashMap<String, String[]>();
        String[] creds = {USER_NAME, PASSWORD};
        environment.put(JMXConnector.CREDENTIALS, creds);
        return connect(rmiJmxUrl, environment);
    }

    public static MBeanServerConnection getMBeanServerConnection(final String rmiJmxUrl, final String user, final String password) {
        if ((user == null) || (password == null)) {
            return getMBeanServerConnection(rmiJmxUrl);
        } else {
            HashMap<String, String[]> environment = new HashMap<String, String[]>();
            String[] creds = {user, password};
            environment.put(JMXConnector.CREDENTIALS, creds);
            return connect(rmiJmxUrl, environment);
        }
    }

    private static MBeanServerConnection connect(final String rmiJmxUrl, HashMap<String, String[]> environment) {
        if (rmiJmxUrl == null) {
            return ManagementFactory.getPlatformMBeanServer();
        }
        MBeanServerConnection mbeanServer = null;
        try {
            JMXServiceURL url = new JMXServiceURL(rmiJmxUrl);
            JMXConnector connector = JMXConnectorFactory.connect(url, environment);
            mbeanServer = connector.getMBeanServerConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mbeanServer;
    }
}
