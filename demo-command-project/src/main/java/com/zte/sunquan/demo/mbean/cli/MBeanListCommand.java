package com.zte.sunquan.demo.mbean.cli;


import java.util.Arrays;
import java.util.stream.Collectors;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanInfo;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;

import org.apache.karaf.shell.commands.Command;
import org.apache.karaf.shell.commands.Option;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.apache.karaf.shell.table.ShellTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zte.sunquan.demo.mbean.utils.MBeanServerUtils;
import com.zte.sunquan.demo.mbean.utils.NetUtils;

/**
 * Created by 10184538 on 2018/5/30.
 * <p>
 * mbean:list -n java.lang:type=Memory -a NonHeapMemoryUsage
 * <p>
 * mbean:list -n org.apache.karaf:type=feature,name=root
 */
@Command(scope = "mbean", name = "list", description = "invoke mbean operations")
public class MBeanListCommand extends OsgiCommandSupport {
    private static final Logger LOG = LoggerFactory.getLogger(MBeanListCommand.class);
    @Option(name = "-p",
            aliases = {"--port"},
            description = "jms bean listener port")
    private String port = "1099";

    @Option(name = "-n",
            aliases = {"--oname"},
            description = "enter object name[{0}:type={1},category={2},name={3}]",
            multiValued = false)
    private String objectName;


    @Option(name = "-a",
            aliases = {"--attribute"},
            description = "enter mbean attribute name",
            multiValued = false)
    private String attributeName;

    @Override
    protected Object doExecute() throws Exception {
        MBeanServerConnection mBeanServerConn = MBeanServerUtils.getMBeanServerConnection(NetUtils.getLocalAddress(), port);
        if (objectName != null) {
            MBeanInfo mBeanInfo = mBeanServerConn.getMBeanInfo(new ObjectName(objectName));
            if (attributeName != null) {
                Object attribute = mBeanServerConn.getAttribute(new ObjectName(objectName), attributeName);
                session.getConsole().println(attribute);
                return null;
            }

            ShellTable table = new ShellTable();
            table.column("Attribute");
            table.column("Type");

            for (MBeanAttributeInfo attrInfo : mBeanInfo.getAttributes()) {
                table.addRow().addContent(attrInfo.getName(), attrInfo.getType());
            }
            table.print(session.getConsole());

            table = new ShellTable();
            table.column("Operation");
            table.column("Parameter");
            table.column("ReturnType");

            for (MBeanOperationInfo operInfo : mBeanInfo.getOperations()) {
                table.addRow().addContent(operInfo.getName()
                        , Arrays.stream(operInfo.getSignature()).map(p -> p.getType())
                                .collect(Collectors.joining(" ")),
                        operInfo.getReturnType());
            }
            table.print(session.getConsole());
        } else {
            mBeanServerConn.queryNames(null, null)
                    .stream().forEach(p -> session.getConsole().println(p.toString()));
        }
        return null;
    }
}
