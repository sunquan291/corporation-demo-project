package com.zte.sunquan.demo.mbean.cli;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

import org.apache.karaf.shell.commands.Argument;
import org.apache.karaf.shell.commands.Command;
import org.apache.karaf.shell.commands.Option;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.zte.sunquan.demo.mbean.utils.MBeanServerUtils;
import com.zte.sunquan.demo.mbean.utils.NetUtils;

/**
 * Created by 10184538 on 2018/5/30.
 * <p>
 * 用于执行指定MBean里的指定方法
 * -v p1:java.lang.String 1:java.lang.Integer
 * <p>
 * -p 1990
 * <p>
 * eg.
 * <p>
 * mbean:invoke -n java.lang:type=Threading -m getThreadInfo -v 10:long
 * <p>
 * mbean:invoke -n com.sun.management:type=DiagnosticCommand -m vmVersion
 */
@Command(scope = "mbean", name = "invoke", description = "invoke mbean operations")
public class MBeanOperateCommand extends OsgiCommandSupport {
    private static final Logger LOG = LoggerFactory.getLogger(MBeanOperateCommand.class);

    /**
     * 预定义的操作，如gc  mbean:invoke gc
     */
    private static final Map<String, String> preOperations =
            Maps.newConcurrentMap();

    static {
        preOperations.put("gc", "java.lang:type=Memory");
    }

    @Argument(index = 0, name = "command",
            description = "pre define operations",
            multiValued = false)
    private String command;

    @Option(name = "-n",
            aliases = {"--oname"},
            description = "enter object name[{0}:type={1},category={2},name={3}]",
            multiValued = false)
    private String objectName;
    @Option(name = "-m",
            aliases = {"--method"},
            description = "which method will be invoked.",
            multiValued = false)
    private String methodName;

    @Option(name = "-v",
            aliases = {"--parameter"},
            description = "method and type 9:java.lang.Integer 10:java.lang.String")
    private String parameter;

    @Option(name = "-p",
            aliases = {"--port"},
            description = "jms bean listener port")
    private String port = "1099";

    @Override
    protected Object doExecute() throws Exception {
        Object result = null;
        MBeanServerConnection mBeanServerConn = MBeanServerUtils.getMBeanServerConnection(NetUtils.getLocalAddress(), port);
        if (command != null && "gc".equalsIgnoreCase(command)) {
            mBeanServerConn.invoke(new ObjectName(preOperations.get("gc")), "gc", null, null);
            return null;
        }

        ObjectName name = checkBeanParameter();
        //定位Operation
        MBeanOperationInfo operationInfo = locateOperation(mBeanServerConn.getMBeanInfo(name).getOperations());
        if (operationInfo == null) {
            session.getConsole().printf("No %s found.\n", methodName);
        } else {
            if (parameter == null) {
                result = mBeanServerConn.invoke(name, methodName, null, null);
            } else {
                List<String> type = Arrays.stream(operationInfo.getSignature())
                        .map(p -> p.getType()).collect(Collectors.toList());

                List<Object> para = Arrays.stream(parameter.split(" "))
                        .map(p -> {
                            String v = p.split(":")[0];
                            String t = p.split(":")[1];
                            return translateTypeValue(t, v);
                        })
                        .collect(Collectors.toList());
                result = mBeanServerConn.invoke(name, methodName, para.toArray(), type.toArray(new String[]{}));
            }
        }
        return result;
    }

    private ObjectName checkBeanParameter() {
        Preconditions.checkNotNull(objectName);
        ObjectName name = null;
        try {
            name = new ObjectName(objectName);
        } catch (MalformedObjectNameException e) {
            LOG.error("Object name format error.", e);
        }
        return name;
    }

    @VisibleForTesting
    public MBeanOperationInfo locateOperation(MBeanOperationInfo[] operations) {
        if (parameter == null) {
            for (MBeanOperationInfo operation : operations) {
                if (operation.getName().equals(methodName) && operation.getSignature().length == 0)
                    return operation;
            }
        } else {
            String[] para = parameter.split(" ");
            for (MBeanOperationInfo operation : operations) {
                loop:
                if (operation.getName().equals(methodName)) {
                    if (operation.getSignature().length == para.length) {
                        for (int i = 0; i < operation.getSignature().length; i++) {
                            if (!operation.getSignature()[i].getType().equals(para[i].split(":")[1]))
                                break loop;
                        }
                    } else {
                        break loop;
                    }
                    return operation;
                }

            }
        }
        return null;
    }

    private Object translateTypeValue(String type, String value) {
        switch (type) {
            case "java.lang.String":
                return value;
            case "java.lang.Integer":
            case "int":
                return Integer.parseInt(value);
            case "java.lang.Long":
            case "long":
                return Long.parseLong(value);
            case "java.lang.Short":
            case "short":
                return Short.parseShort(value);
            case "java.lang.Float":
            case "float":
                return Float.parseFloat(value);
            case "java.lang.Double":
            case "double":
                return Double.parseDouble(value);
            case "java.lang.Byte":
            case "byte":
                return Byte.parseByte(value);
            case "java.lang.Boolean":
            case "boolean":
                return Boolean.parseBoolean(value);
            default:
                return null;
        }
    }
}
