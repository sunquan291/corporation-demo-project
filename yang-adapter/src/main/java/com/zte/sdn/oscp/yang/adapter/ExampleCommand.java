package com.zte.sdn.oscp.yang.adapter;

import net.sourceforge.argparse4j.annotation.Arg;
import org.apache.karaf.shell.commands.Argument;
import org.apache.karaf.shell.commands.Command;
import org.apache.karaf.shell.commands.Option;
import org.apache.karaf.shell.console.OsgiCommandSupport;

import java.util.concurrent.Executors;

/**
 * Created by 10184538 on 2017/10/20.
 */

@Command(scope = "livio", name = "example", description = "livio exmaple command")
public class ExampleCommand extends OsgiCommandSupport {
    @Option(name = "-n",
            aliases = {"--Name"},
            description = "Show the information of specific shard module",
            required = false,
            multiValued = false)
    @Arg(dest = "shardModuleName")
    private String shardModuleName = "";

    @Argument(index = 0, name = "command",
            description = "[help]",
            required = true, multiValued = true)
    private String command = "help";

    @Override
    protected Object doExecute() throws Exception {
        if (!shardModuleName.isEmpty()) {
            System.out.println("Name:" + shardModuleName);
        }
        
        System.out.println("command:"+command);
        switch (command) {
            case "help":
                session.getConsole().println("help command output");
                break;
            case "print":
                session.getConsole().println("print command output");
                break;
            default:
                session.getConsole().println(command);
                break;
        }
        return null;
    }
}
