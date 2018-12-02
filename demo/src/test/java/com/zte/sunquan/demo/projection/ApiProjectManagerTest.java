package com.zte.sunquan.demo.projection;

import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by 10184538 on 2017/1/7.
 */
public class ApiProjectManagerTest {
    @Test
    public void testProperty() {
        ApiProjectManager apiProjectManager = new ApiProjectManager();
        apiProjectManager.getApiPrjPropMap().forEach((k, v) -> System.out.println("key1:" + k + ",value=" + v));
        apiProjectManager.getApiPrjMap().forEach((k, v) -> System.out.println("key2:" + k + ",value=" + v));
        apiProjectManager.getInstance("default,property-subroot,com.zte.sunquan.demo.actor.ActorMain");
        apiProjectManager.getApiPrjInstMap().forEach((k, v) -> System.out.println("key3:" + k + ",value=" + v));
    }

    @Test
    public void testPath() {
        RuntimeMXBean rmb = (RuntimeMXBean) ManagementFactory.getRuntimeMXBean();
        String classPath = rmb.getClassPath();
        String[] paths = classPath.split(System.getProperties().getProperty("path.separator"));
        Arrays.stream(paths).forEach(System.out::println);
    }

    @Test
    public void getProperties() {
        System.out.println(System.getProperty("java.vendor"));    //Java提供商名称
        System.out.println(System.getProperty("java.vendor.url"));   //Java提供商网站
        System.out.println(System.getProperty("java.home"));   //Java，哦，应该是jre目录
        System.out.println(System.getProperty("java.vm.specification.version"));   //Java虚拟机规范版本号
        System.out.println(System.getProperty("java.vm.specification.vendor"));   //Java虚拟机规范提供商
        System.out.println(System.getProperty("java.vm.specification.name"));   //Java虚拟机规范名称
        System.out.println(System.getProperty("java.vm.version"));   //Java虚拟机版本号
        System.out.println(System.getProperty("java.vm.vendor"));   //Java虚拟机提供商
        System.out.println(System.getProperty("java.vm.name"));   //Java虚拟机名称
        System.out.println(System.getProperty("java.specification.version"));   //Java规范版本号
        System.out.println(System.getProperty("java.specification.vendor"));   //Java规范提供商
        System.out.println(System.getProperty("java.specification.name"));   //Java规范名称
        System.out.println(System.getProperty("java.class.version"));   //Java类版本号
        System.out.println(System.getProperty("java.class.path"));   //Java类路径
        System.out.println(System.getProperty("java.library.path"));   //<a href="http://lib.csdn.net/base/java" class='replace_word' title="Java 知识库" target='_blank' style='color:#df3434; font-weight:bold;'>Java </a>lib路径
        System.out.println(System.getProperty("java.io.tmpdir"));   //Java输入输出临时路径
        System.out.println(System.getProperty("java.compiler"));   //Java编译器
        System.out.println(System.getProperty("java.ext.dirs"));   //Java执行路径
        System.out.println(System.getProperty("os.name"));   //<a href="http://lib.csdn.net/base/operatingsystem" class='replace_word' title="操作系统知识库" target='_blank' style='color:#df3434; font-weight:bold;'>操作系统</a>名称
        System.out.println(System.getProperty("os.arch"));   //
        System.out.println(System.getProperty("os.version"));   //版本号
        System.out.println(System.getProperty("file.separator"));   //文件分隔符
        System.out.println(System.getProperty("path.separator"));   //路径分隔符
        System.out.println(System.getProperty("line.separator"));   //直线分隔符
        System.out.println(System.getProperty("user.name"));   //用户名
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir"));
    }
    @Test
    public void test(){
        System.out.println(Object.class.getSuperclass());
    }
}
