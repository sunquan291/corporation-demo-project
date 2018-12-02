package com.zte.sunquan.demo.hello.command;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.karaf.shell.commands.Argument;
import org.apache.karaf.shell.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;

/**
 * Created by 10184538 on 2017/1/13.
 */
@Command(scope = "sunquan", name = "hello", description = "hello command")
public class HelloCommand extends OsgiCommandSupport {

    @Argument(index = 0, name = "command",
            description = "[print]",
            required = true, multiValued = false)
    private String command = "print-sunquan";

    @Argument(index = 1, name = "argument1",
            description = "argument 1",
            required = false, multiValued = false)
    private String arg1 = "";

    @Override
    protected Object doExecute() throws Exception {
        switch (command) {
            case "print-sunquan":
                System.out.println("hello,world");
                break;
        }
        return null;
    }

}
