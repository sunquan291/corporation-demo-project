/*
 * Copyright (c) 2016 Inocybe Technologies and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package com.zte.sunquan.demo.test.cases.cli;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.notification.StoppedByUserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 10184538 on 2018/5/16.
 */
public class PGUnitRunNotifier extends RunNotifier {
    private Map<Description, TestCaseStatus> testResultMap = new ConcurrentHashMap<>();
    private static final Logger LOG = LoggerFactory.getLogger(PGUnitRunNotifier.class);

    public long getTestCase(TestCaseStatus status) {
        return testResultMap.values().stream().filter(p -> p == status).count();
    }

    @Override
    public void fireTestStarted(Description description) throws StoppedByUserException {
        testResultMap.put(description, TestCaseStatus.Started);
        super.fireTestStarted(description);
    }

    @Override
    public void fireTestFailure(Failure failure) {
        LOG.error("Test failure", failure.getException());
        testResultMap.put(failure.getDescription(), TestCaseStatus.Failure);
        super.fireTestFailure(failure);
    }

    @Override
    public void fireTestIgnored(Description description) {
        testResultMap.put(description, TestCaseStatus.Ignored);
        super.fireTestIgnored(description);
    }

    @Override
    public void fireTestFinished(Description description) {
        if (testResultMap.get(description) == TestCaseStatus.Started) {
            testResultMap.put(description, TestCaseStatus.Success);
        }
        super.fireTestFinished(description);
    }

    @Override
    public void fireTestAssumptionFailed(Failure failure) {
        testResultMap.put(failure.getDescription(), TestCaseStatus.Ignored);
        super.fireTestAssumptionFailed(failure);
    }

}
