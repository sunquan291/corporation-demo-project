package com.zte.sunquan.demo.jms;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.AttributeNotFoundException;
import javax.management.DynamicMBean;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanConstructorInfo;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.ReflectionException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

/**
 * Created by 10184538 on 2017/9/30.
 * 新增属性
 */
public class Bill implements DynamicMBean {

    private Map<String, Long> prices = new HashMap<>();
    private MBeanInfo mBeanInfo;
    private MBeanAttributeInfo[] attributes;

    private MBeanConstructorInfo[] mBeanConstructorInfos;

    public Bill() {
        Constructor[] constructors = this.getClass().getConstructors();
        MBeanConstructorInfo mBeanConstructorInfo = new MBeanConstructorInfo("constructors", constructors[0]);
        mBeanConstructorInfos = new MBeanConstructorInfo[1];
        mBeanConstructorInfos[0] = mBeanConstructorInfo;
        mBeanInfo = new MBeanInfo(this.getClass().getName(),
                "description", attributes, mBeanConstructorInfos,
                null, null);
    }

    /**
     * 方法 动态新增属性，需要重新实例化mBeanInfo
     */
    public void addAttribute() {
        attributes = new MBeanAttributeInfo[1];
        attributes[0] = new MBeanAttributeInfo("price1", "java.lang.String", "price11", true, true, false);
        prices.put("price1", 100L);
        mBeanInfo = new MBeanInfo(this.getClass().getName(),
                "description", attributes, mBeanConstructorInfos,
                null, null);
    }

    @Override
    public Object getAttribute(String attribute) throws AttributeNotFoundException, MBeanException, ReflectionException {
        System.out.println("getAttribute");
        return Optional.ofNullable(prices.get(attribute)).orElse(0L);
    }

    @Override
    public void setAttribute(Attribute attribute) throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
        System.out.println("setAttribute");
        prices.put(attribute.getName(), Long.parseLong(attribute.getValue().toString()));
    }

    @Override
    public AttributeList getAttributes(String[] attributes) {
        //通过该方法获取属性名与值
        System.out.println("getAttributes");
        AttributeList resultList = new AttributeList();
        for (String attr : attributes) {
            try {
                resultList.add(new Attribute(attr, getAttribute(attr)));
            } catch (AttributeNotFoundException e) {
                e.printStackTrace();
            } catch (MBeanException e) {
                e.printStackTrace();
            } catch (ReflectionException e) {
                e.printStackTrace();
            }
        }
        return resultList;
    }

    @Override
    public AttributeList setAttributes(AttributeList attributes) {
        AttributeList resultList = new AttributeList();
        for (Iterator i = attributes.iterator(); i.hasNext(); ) {
            Attribute attr = (Attribute) i.next();
            try {
                setAttribute(attr);
                String name = attr.getName();
                Object value = getAttribute(name);
                resultList.add(new Attribute(name, value));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultList;
    }

    @Override
    public Object invoke(String actionName, Object[] params, String[] signature) throws MBeanException, ReflectionException {
        return null;
    }

    @Override
    public MBeanInfo getMBeanInfo() {
        return mBeanInfo;
    }
}
