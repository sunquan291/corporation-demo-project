/*
 * Copyright (c) 2016 Inocybe Technologies and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package com.zte.sunquan.demo.test.cases.cli;

import org.apache.karaf.shell.commands.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 10184538 on 2018/4/26.
 *  * eg.
 * testcase:invoke
 * testcase:invoke -c xxx.xxx.xxx.xxx
 * 注意要使该命令生效，有几点注意
 * 1.测试用例的类都要打到源码路径里，OSGI环境中才可以找到相应class执行
 * <p>
 * <p>
 * <p>
 * <p>
 * 2.测试用例中针对服务获致要进行简单的修改
 * 可以使用ExecutePlatform.isOSGIPlatform
 * <p>
 * 服务获取
 */
@Command(scope = "testcase", name = "invoke", description = "invoke test case")
public class TestCasesInvokeCommand extends AbstractTestCaseCommand {
    private static final Logger LOG = LoggerFactory.getLogger(TestCasesInvokeCommand.class);

    @Override
    public void preTestCases() {
    }
}


//    public <T> T get(Class<T> serviceClass) {
//        BundleContext bc = FrameworkUtil.getBundle(serviceClass).getBundleContext();
//        if (bc != null) {
//            ServiceReference<T> reference = bc.getServiceReference(serviceClass);
//            if (reference != null) {
//                T impl = bc.getService(reference);
//                if (impl != null) {
//                    return impl;
//                }
//            }
//        }
//        throw new RuntimeException("Service " + serviceClass.getName() + " not found");
//    }
//打包指定目录至源码路径
//                <plugin>
//                <groupId>org.codehaus.mojo</groupId>
//                <artifactId>build-helper-maven-plugin</artifactId>
//                <executions>
//                    <execution>
//                        <id>add-source</id>
//                        <goals>
//                            <goal>add-source</goal>
//                        </goals>
//                        <configuration>
//                            <sources>
//                                <source>src/test/java</source>
//                            </sources>
//                        </configuration>
//                    </execution>
//                </executions>
//            </plugin>