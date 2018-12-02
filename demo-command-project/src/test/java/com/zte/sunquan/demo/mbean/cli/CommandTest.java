package com.zte.sunquan.demo.mbean.cli;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 10184538 on 2018/5/31.
 */
public class CommandTest {

    @Test
    public void testLocateOperation1() throws NoSuchFieldException, IllegalAccessException {
        MBeanOperateCommand command = new MBeanOperateCommand();
        Field parameter = MBeanOperateCommand.class.getDeclaredField("parameter");
        parameter.setAccessible(true);
        Field methodName = MBeanOperateCommand.class.getDeclaredField("methodName");
        methodName.setAccessible(true);

        //"-m test"
        parameter.set(command, null);
        methodName.set(command, "test");

        //test()
        List<MBeanOperationInfo> operationInfos = new ArrayList<>();
        List<MBeanParameterInfo> paraInfos = new ArrayList<>();
        operationInfos.add(new MBeanOperationInfo("test", "test", paraInfos.toArray(new MBeanParameterInfo[]{}), "java.lang.String", MBeanOperationInfo.INFO));
        MBeanOperationInfo result = command.locateOperation(operationInfos.toArray(new MBeanOperationInfo[]{}));
        Assert.assertTrue(result != null);
        //test(String p1)
        operationInfos.clear();
        paraInfos.clear();
        paraInfos.add(new MBeanParameterInfo("p1", "java.lang.String", "p1"));
        operationInfos.add(new MBeanOperationInfo("test", "test", paraInfos.toArray(new MBeanParameterInfo[]{}), "java.lang.String", MBeanOperationInfo.INFO));
        result = command.locateOperation(operationInfos.toArray(new MBeanOperationInfo[]{}));
        Assert.assertTrue(result == null);
        //test1(String p1)
        operationInfos.clear();
        paraInfos.clear();
        paraInfos.add(new MBeanParameterInfo("p1", "java.lang.String", "p1"));
        operationInfos.add(new MBeanOperationInfo("test1", "test", paraInfos.toArray(new MBeanParameterInfo[]{}), "java.lang.String", MBeanOperationInfo.INFO));
        result = command.locateOperation(operationInfos.toArray(new MBeanOperationInfo[]{}));
        Assert.assertTrue(result == null);
        //test1()
        operationInfos.clear();
        paraInfos.clear();
        operationInfos.add(new MBeanOperationInfo("test1", "test", paraInfos.toArray(new MBeanParameterInfo[]{}), "java.lang.String", MBeanOperationInfo.INFO));
        result = command.locateOperation(operationInfos.toArray(new MBeanOperationInfo[]{}));
        Assert.assertTrue(result == null);
    }

    @Test
    public void testLocateOperation2() throws NoSuchFieldException, IllegalAccessException {
        MBeanOperateCommand command = new MBeanOperateCommand();
        Field parameter = MBeanOperateCommand.class.getDeclaredField("parameter");
        parameter.setAccessible(true);
        Field methodName = MBeanOperateCommand.class.getDeclaredField("methodName");
        methodName.setAccessible(true);
        //test(String p1,int p2)
        parameter.set(command, "abc:java.lang.String 1:java.lang.Integer");
        methodName.set(command, "test");

        //test()
        List<MBeanOperationInfo> operationInfos = new ArrayList<>();
        List<MBeanParameterInfo> paraInfos = new ArrayList<>();
        operationInfos.add(new MBeanOperationInfo("test", "test", paraInfos.toArray(new MBeanParameterInfo[]{}), "java.lang.String", MBeanOperationInfo.INFO));
        MBeanOperationInfo result = command.locateOperation(operationInfos.toArray(new MBeanOperationInfo[]{}));
        Assert.assertTrue(result == null);
        //test(String p1)
        operationInfos.clear();
        paraInfos.clear();
        paraInfos.add(new MBeanParameterInfo("p1", "java.lang.String", "p1"));
        operationInfos.add(new MBeanOperationInfo("test", "test", paraInfos.toArray(new MBeanParameterInfo[]{}), "java.lang.String", MBeanOperationInfo.INFO));
        result = command.locateOperation(operationInfos.toArray(new MBeanOperationInfo[]{}));
        Assert.assertTrue(result == null);

        //test(String p1,int p2)
        operationInfos.clear();
        paraInfos.clear();
        paraInfos.add(new MBeanParameterInfo("p1", "java.lang.String", "p1"));
        paraInfos.add(new MBeanParameterInfo("p2", "java.lang.Integer", "p2"));
        operationInfos.add(new MBeanOperationInfo("test", "test", paraInfos.toArray(new MBeanParameterInfo[]{}), "java.lang.String", MBeanOperationInfo.INFO));
        result = command.locateOperation(operationInfos.toArray(new MBeanOperationInfo[]{}));
        Assert.assertTrue(result != null);
        //test(String p1,int p2,int p3)
        operationInfos.clear();
        paraInfos.clear();
        paraInfos.add(new MBeanParameterInfo("p1", "java.lang.String", "p1"));
        paraInfos.add(new MBeanParameterInfo("p2", "java.lang.Integer", "p2"));
        paraInfos.add(new MBeanParameterInfo("p3", "java.lang.Integer", "p3"));
        operationInfos.add(new MBeanOperationInfo("test", "test", paraInfos.toArray(new MBeanParameterInfo[]{}), "java.lang.String", MBeanOperationInfo.INFO));
        result = command.locateOperation(operationInfos.toArray(new MBeanOperationInfo[]{}));
        Assert.assertTrue(result == null);
        //test1(String p1)
        operationInfos.clear();
        paraInfos.clear();
        paraInfos.add(new MBeanParameterInfo("p1", "java.lang.String", "p1"));
        operationInfos.add(new MBeanOperationInfo("test1", "test", paraInfos.toArray(new MBeanParameterInfo[]{}), "java.lang.String", MBeanOperationInfo.INFO));
        result = command.locateOperation(operationInfos.toArray(new MBeanOperationInfo[]{}));
        Assert.assertTrue(result == null);
        //test1()
        operationInfos.clear();
        paraInfos.clear();
        operationInfos.add(new MBeanOperationInfo("test1", "test", paraInfos.toArray(new MBeanParameterInfo[]{}), "java.lang.String", MBeanOperationInfo.INFO));
        result = command.locateOperation(operationInfos.toArray(new MBeanOperationInfo[]{}));
        Assert.assertTrue(result == null);
    }

    @Test
    public void testLocateOperation3() throws NoSuchFieldException, IllegalAccessException {
        MBeanOperateCommand command = new MBeanOperateCommand();
        Field parameter = MBeanOperateCommand.class.getDeclaredField("parameter");
        parameter.setAccessible(true);
        Field methodName = MBeanOperateCommand.class.getDeclaredField("methodName");
        methodName.setAccessible(true);
        //test(String p1)
        parameter.set(command, "abc:java.lang.String");
        methodName.set(command, "test");

        //test()
        List<MBeanOperationInfo> operationInfos = new ArrayList<>();
        List<MBeanParameterInfo> paraInfos = new ArrayList<>();
        operationInfos.add(new MBeanOperationInfo("test", "test", paraInfos.toArray(new MBeanParameterInfo[]{}), "java.lang.String", MBeanOperationInfo.INFO));
        MBeanOperationInfo result = command.locateOperation(operationInfos.toArray(new MBeanOperationInfo[]{}));
        Assert.assertTrue(result == null);
        //test(String p1)
        operationInfos.clear();
        paraInfos.clear();
        paraInfos.add(new MBeanParameterInfo("p1", "java.lang.String", "p1"));
        operationInfos.add(new MBeanOperationInfo("test", "test", paraInfos.toArray(new MBeanParameterInfo[]{}), "java.lang.String", MBeanOperationInfo.INFO));
        result = command.locateOperation(operationInfos.toArray(new MBeanOperationInfo[]{}));
        Assert.assertTrue(result != null);

        //test(String p1,int p2)
        operationInfos.clear();
        paraInfos.clear();
        paraInfos.add(new MBeanParameterInfo("p1", "java.lang.String", "p1"));
        paraInfos.add(new MBeanParameterInfo("p2", "java.lang.Integer", "p2"));
        operationInfos.add(new MBeanOperationInfo("test", "test", paraInfos.toArray(new MBeanParameterInfo[]{}), "java.lang.String", MBeanOperationInfo.INFO));
        result = command.locateOperation(operationInfos.toArray(new MBeanOperationInfo[]{}));
        Assert.assertTrue(result == null);
        //test(String p1,int p2,int p3)
        operationInfos.clear();
        paraInfos.clear();
        paraInfos.add(new MBeanParameterInfo("p1", "java.lang.String", "p1"));
        paraInfos.add(new MBeanParameterInfo("p2", "java.lang.Integer", "p2"));
        paraInfos.add(new MBeanParameterInfo("p3", "java.lang.Integer", "p3"));
        operationInfos.add(new MBeanOperationInfo("test", "test", paraInfos.toArray(new MBeanParameterInfo[]{}), "java.lang.String", MBeanOperationInfo.INFO));
        result = command.locateOperation(operationInfos.toArray(new MBeanOperationInfo[]{}));
        Assert.assertTrue(result == null);
        //test1(String p1)
        operationInfos.clear();
        paraInfos.clear();
        paraInfos.add(new MBeanParameterInfo("p1", "java.lang.String", "p1"));
        operationInfos.add(new MBeanOperationInfo("test1", "test", paraInfos.toArray(new MBeanParameterInfo[]{}), "java.lang.String", MBeanOperationInfo.INFO));
        result = command.locateOperation(operationInfos.toArray(new MBeanOperationInfo[]{}));
        Assert.assertTrue(result == null);
        //test1()
        operationInfos.clear();
        paraInfos.clear();
        operationInfos.add(new MBeanOperationInfo("test1", "test", paraInfos.toArray(new MBeanParameterInfo[]{}), "java.lang.String", MBeanOperationInfo.INFO));
        result = command.locateOperation(operationInfos.toArray(new MBeanOperationInfo[]{}));
        Assert.assertTrue(result == null);
    }
}
