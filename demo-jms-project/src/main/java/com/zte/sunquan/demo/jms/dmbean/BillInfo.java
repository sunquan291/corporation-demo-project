package com.zte.sunquan.demo.jms.dmbean;

import java.util.ArrayList;
import java.util.List;
import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.DynamicMBean;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanConstructorInfo;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanNotificationInfo;
import javax.management.MBeanOperationInfo;
import javax.management.ReflectionException;

import com.google.common.base.Preconditions;

/**
 * Created by sunquan on 2017/9/29.
 * 针对DynamicMBean的使用场景
 * 运行时动态增加attribute(值可以是已知的字段计算所得)，如何赋值getAttribute
 * 运行时动态增加operation,其执行逻辑，如何设置
 * 下面的例子中，实际上是伪动态，因为其要增加的print方法提前知道了，name字段也是提前知道的
 * <p>
 * 因此要实际真动态，属性值与方法执行体需要进行保存
 */
public class BillInfo implements DynamicMBean {
    //非动态属性
    private String name;

    private MBeanInfo mBeanInfo = null;
    private String description = "Simple BillInfo of a MBean.";
    private List<MBeanAttributeInfo> attributes = new ArrayList<>();
    private List<MBeanConstructorInfo> constructors = new ArrayList<>();
    private List<MBeanOperationInfo> operations = new ArrayList<>();
    private List<MBeanNotificationInfo> mBeanNotificationInfoArray = new ArrayList<>();

    public BillInfo(String name) {
        this.name = name;
        //默认加入非动态属性name
        MBeanAttributeInfo nameAttribute =
                new MBeanAttributeInfo("name", "java.lang.String", "BillInfo: name string.",
                        true, true, false);
        //设置name的值
        addAttribute(nameAttribute);
    }

    public void addAttribute(MBeanAttributeInfo info) {
        this.attributes.add(info);
        updateMBeanInfo();
    }

    public void addOperation(MBeanOperationInfo info) {
        this.operations.add(info);
        updateMBeanInfo();
    }

    public void updateMBeanInfo() {
        mBeanInfo = new MBeanInfo(this.getClass().getName(),
                description,
                attributes.toArray(new MBeanAttributeInfo[]{}),
                constructors.toArray(new MBeanConstructorInfo[]{}),
                operations.toArray(new MBeanOperationInfo[]{}),
                mBeanNotificationInfoArray.toArray(new MBeanNotificationInfo[]{}));
    }

    @Override
    public MBeanInfo getMBeanInfo() {
        //针对DynamicBean利用该方法返回值，用于显示相应字段方法
        return mBeanInfo;
    }

    @Override
    public Object getAttribute(String attributeName) {
        //返回指定属性的值
        System.out.println("getAttribute");
        if (attributeName == null) {
            return null;
        }
        //直接返回非动态属性name
        if (attributeName.equals("name")) {
            return name;
        }
        return null;
    }

    @Override
    public void setAttribute(Attribute attribute) {
        //设置某个属性时调用
        if (attribute == null) {
            return;
        }
        String attributeName = attribute.getName();
        Object attributeValue = attribute.getValue();
        if (attributeName.equals("name")) {
            Preconditions.checkArgument(String.class.isAssignableFrom(attributeValue.getClass()));
            name = (String) attributeValue;
        }
    }

    @Override
    public AttributeList getAttributes(String[] attributeNames) {
        System.out.println("getAttributes");
        //在JConsole界面展示Attributes时调用
        if (attributeNames == null) {
            return null;
        }
        AttributeList resultList = new AttributeList();
        for (String attributeName : attributeNames) {
            Object value = getAttribute(attributeName);
            resultList.add(new Attribute(attributeName, value));
        }
        return resultList;
    }

    @Override
    public AttributeList setAttributes(AttributeList attributes) {
        System.out.println("setAttributes");
        if (attributes == null) {
            return null;
        }
        AttributeList resultList = new AttributeList();
        for (Object obj : attributes) {
            Attribute attribute = (Attribute) obj;
            setAttribute((Attribute) obj);
            resultList.add(new Attribute(attribute.getName(), getAttribute(attribute.getName())));
        }
        return resultList;
    }

    @Override
    public Object invoke(String operationName, Object params[], String signature[]) throws MBeanException, ReflectionException {
        if (operationName.equals("print")) {
            System.out.println("Hello, " + name + ", this is HelloDynamic!");
        } else {
            throw new ReflectionException(new NoSuchMethodException(operationName), "Cannot find the operation " + operationName + " in " + this.getClass().getSimpleName());
        }
        return null;
    }
}
