/*
 * Copyright (c) 2016 Inocybe Technologies and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package com.zte.sunquan.demo.test.cases.cli;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.karaf.shell.commands.Command;
import org.apache.karaf.shell.commands.Option;
import org.apache.karaf.shell.console.AbstractAction;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 10184538 on 2018/4/26.
 * <p>
 */
public abstract class AbstractTestCaseCommand extends AbstractAction {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractTestCaseCommand.class);

    protected List<Class> preTestCaseLib = new ArrayList<>();
    private PGUnitRunNotifier notifier = new PGUnitRunNotifier();

    @Option(name = "-c",
            aliases = {"--case"},
            description = "test case",
            multiValued = false)
    private String testCase;

    public AbstractTestCaseCommand() {
        preTestCases();
    }

    public abstract void preTestCases();

    @Override
    protected Object doExecute() throws Exception {
        List<Class> testCases = preTestCaseLib;
        if (testCase != null) {
            testCases = preTestCaseLib.stream()
                    .filter(p -> p.getSimpleName().equals(testCase)
                            || p.getName().equals(testCase))
                    .collect(Collectors.toList());
            if (!testCases.isEmpty() && testCase.split("\\.").length > 0) {
                try {
                    Class<?> aClass = Class.forName(testCase);
                    testCases.add(aClass);
                } catch (Exception e) {
                    session.getConsole().println("Cant not found class");
                    LOG.error("Can not found class", e);
                    return null;
                }
            }
        }


        int totalTestCase = 0;
        long now = System.currentTimeMillis();
        for (Class cls : testCases) {
            try {
                BlockJUnit4ClassRunner runner = new BlockJUnit4ClassRunner(cls);
                runner.run(notifier);
                totalTestCase += runner.testCount();
            } catch (InitializationError e) {
                session.getConsole().printf("%s not test case.\n", cls.getSimpleName());
            }
        }
        long time = System.currentTimeMillis() - now;
        session.getConsole().println("Total Test Case:\t" + totalTestCase);
        session.getConsole().println("Total Cost Time:\t" + ((double) time) / 1000 + "(s)");
        session.getConsole().println("Total Success Case:\t" + notifier.getTestCase(TestCaseStatus.Success));
        session.getConsole().println("Total Failure Case:\t" + notifier.getTestCase(TestCaseStatus.Failure));
        return null;
    }
}
