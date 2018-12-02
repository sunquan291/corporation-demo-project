package com.zte.sunquan.demo.jms.dmbean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import javax.management.Attribute;
import javax.management.AttributeChangeNotification;
import javax.management.AttributeList;
import javax.management.DynamicMBean;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanConstructorInfo;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanNotificationInfo;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotificationBroadcasterSupport;
import javax.management.NotificationListener;
import javax.management.ObjectName;
import javax.management.ReflectionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

/**
 * Created by 10184538 on 2018/5/29.
 * 继承自该类的所有子类，实现beanParameters方法返回地址，则自动包装成MBean
 */
public abstract class AbstractDynamicMBean extends NotificationBroadcasterSupport implements DynamicMBean {
    protected static final Logger LOG = LoggerFactory.getLogger(AbstractDynamicMBean.class);
    private AtomicLong sequenceNumber = new AtomicLong(1);
    private final static String OBJECT_NAME_PATTERN = "{0}:type={1},category={2},name={3}";
    private static MBeanServer server;
    //属性
    private Map<MBeanAttributeInfo, Field> attributes = new HashMap<>();
    //方法
    private Map<MBeanOperationInfo, Method> operations = new HashMap<>();

    private MBeanInfo mBeanInfo = null;
    private String description = "AbstractDynamicMBean";
    private List<MBeanConstructorInfo> constructors = new ArrayList<>();
    private List<MBeanNotificationInfo> mBeanNotificationInfoArray = new ArrayList<>();

    private Map<Field, Method> showRules = new HashMap<>();


    public AbstractDynamicMBean() {
        for (Field field : this.getClass().getDeclaredFields()) {
            ShowInBean showInBeanAnnotation = field.getAnnotation(ShowInBean.class);
            if (showInBeanAnnotation != null) {

                boolean canWrite = isBaseDataType(field);
                this.attributes.put(new MBeanAttributeInfo(field.getName(),
                        field.getType().getCanonicalName(),
                        field.getName(), true, canWrite, false), field);

                String value = showInBeanAnnotation.value();
                try {
                    Method declaredMethod = this.getClass().getDeclaredMethod(value, null);
                    showRules.put(field, declaredMethod);
                } catch (NoSuchMethodException e) {
                    LOG.error("Can not found method.", e);
                }
            }
        }
        for (Method method : this.getClass().getDeclaredMethods()) {
            ShowInBean showInBeanAnnotation = method.getAnnotation(ShowInBean.class);
            if (showInBeanAnnotation != null) {
                this.operations.put(new MBeanOperationInfo(method.getName(), method),method);
//                List<MBeanParameterInfo> parameterInfos = new ArrayList<>();
//                for (Parameter parameter : method.getParameters()) {
//                    parameterInfos.add(new MBeanParameterInfo(parameter.getName(),
//                            parameter.getType().getCanonicalName(), parameter.getName()));
//                }
//                this.operations.put(new MBeanOperationInfo(method.getName(),
//                        method.getName(),
//                        parameterInfos.toArray(new MBeanParameterInfo[]{})
//                        , method.getReturnType().getCanonicalName(),
//                        MBeanOperationInfo.INFO
//                ), method);
            }
        }
        updateMBeanInfo();
        if (autoRegister())
            registerMBean();
    }

    /**
     * 默认取消自动加载（主要原因是由于objectName的字段可能会字段字
     * 而字段值，只有子类构造函数走完才会赋值
     * 之前的注册会导致objectname不是期望的地址
     *
     * @return
     */
    protected boolean autoRegister() {
        return false;
    }

    protected ObjectName checkBeanParameter() {
        String[] objectName = beanParameters();
        Preconditions.checkArgument(objectName.length == 4, "Need three four name arguments");
        ObjectName name = null;
        try {
            name = new ObjectName(MessageFormat.format(OBJECT_NAME_PATTERN, objectName));
        } catch (MalformedObjectNameException e) {
            LOG.error("Object name format error.", e);
        }
        return name;
    }

    protected void registerMBean() {
        server = ManagementFactory.getPlatformMBeanServer();
        try {
            server.registerMBean(this, checkBeanParameter());
        } catch (Exception e) {
            LOG.error("Register mbean error.", e);
        }
    }

    /**
     * 返回生成ObjectName所需要的
     * jmxServerName
     * type
     * Category
     * name
     *
     * @return 长度为3的字符数组
     */
    public abstract String[] beanParameters();

    public void addAttribute(MBeanAttributeInfo info) {
        this.attributes.put(info, null);
        updateMBeanInfo();
    }

    public void addOperation(MBeanOperationInfo info) {
        this.operations.put(info, null);
        updateMBeanInfo();
    }

    public void updateMBeanInfo() {
        mBeanInfo = new MBeanInfo(this.getClass().getName(),
                description,
                attributes.keySet().toArray(new MBeanAttributeInfo[]{}),
                constructors.toArray(new MBeanConstructorInfo[]{}),
                operations.keySet().toArray(new MBeanOperationInfo[]{}),
                mBeanNotificationInfoArray.toArray(new MBeanNotificationInfo[]{}));
    }

    private boolean isBaseDataType(Field field) {
        return field.getType().isPrimitive() || Number.class.isAssignableFrom(field.getType());
    }

    @Override
    public Object getAttribute(String attribute) {
        if (attribute == null)
            return null;
        Optional<MBeanAttributeInfo> any = attributes.keySet().stream().filter(p -> p.getName().equals(attribute)).findAny();
        if (any.isPresent()) {
            try {
                Field field = attributes.get(any.get());
                field.setAccessible(true);
                //注解优先级最高
                if (showRules.containsKey(field))
                    return showRules.get(field).invoke(this, null);
                else if (isBaseDataType(field))
                    return field.get(this);
                else
                    return field.get(this).toString();
            } catch (IllegalAccessException e) {
                LOG.error("Field can not be accessed.", e);
            } catch (InvocationTargetException e) {
                LOG.error("Invoke method error.", e);
            }
        }
        return null;
    }

    @Override
    public void setAttribute(Attribute attribute) {
        if (attribute == null) {
            return;
        }
        String attributeName = attribute.getName();
        Object attributeValue = attribute.getValue();

        Optional<MBeanAttributeInfo> any = attributes.keySet().stream().filter(p -> p.getName().equals(attributeName)).findAny();
        if (any.isPresent()) {
            Field field = attributes.get(any.get());
            field.setAccessible(true);
            //attributeValue是基本类型的包装类型
            if (field.getType().isPrimitive())
                Preconditions.checkArgument(field.getType() == primitiveType(attributeValue.getClass())
                        , "Type %s can not match %s", field.getType(), attributeValue.getClass());
            else
                Preconditions.checkArgument(field.getType().isAssignableFrom(attributeValue.getClass())
                        , "Type %s can not match %s", field.getType(), attributeValue.getClass());
            try {
                field.set(this, attributeValue);
            } catch (IllegalAccessException e) {
                LOG.error("Field can not be set.", e);
            }
        }
    }


    private Class primitiveType(final Class cls) {
        if (Number.class.isAssignableFrom(cls)) {
            try {
                return (Class) cls.getDeclaredField("TYPE").get(null);
            } catch (IllegalAccessException | NoSuchFieldException e) {
                LOG.error("Can not get field [TYPE].", e);
            }
        }
        return null;
    }

    @Override
    public AttributeList getAttributes(String[] attributes) {
        if (attributes == null)
            return null;
        AttributeList resultList = new AttributeList();
        for (String attr : attributes) {
            resultList.add(new Attribute(attr, getAttribute(attr)));
        }
        return resultList;
    }

    @Override
    public AttributeList setAttributes(AttributeList attributes) {
        return null;
    }

    @Override
    public Object invoke(String operationName, Object params[], String signature[]) throws MBeanException, ReflectionException {
        Optional<MBeanOperationInfo> any = operations.keySet().stream().filter(p -> p.getName().equals(operationName)).findAny();
        if (any.isPresent()) {
            try {
                return operations.get(any.get()).invoke(this, params);
            } catch (IllegalAccessException | InvocationTargetException e) {
                LOG.error("Can not invoke method.", e);
            }
        } else
            throw new ReflectionException(new NoSuchMethodException(operationName), "Cannot find the operation " + operationName + " in " + this.getClass().getSimpleName());
        return null;
    }

    @Override
    public MBeanInfo getMBeanInfo() {
        return mBeanInfo;
    }

    protected AttributeChangeNotification notifyAttributeChange(String attributeName,
                                                                String attributeType,
                                                                Object oldValue,
                                                                Object newValue) {
        AttributeChangeNotification notification = new AttributeChangeNotification(
                this, sequenceNumber.getAndIncrement(),
                System.currentTimeMillis(),
                AttributeChangeNotification.ATTRIBUTE_CHANGE,
                attributeName,
                attributeType,
                oldValue,
                newValue
        );
        super.sendNotification(notification);
        return notification;
    }

    protected void registerNotificationListener(NotificationListener listener) {
        try {
            server.addNotificationListener(checkBeanParameter(), listener, null, null);
        } catch (InstanceNotFoundException e) {
            LOG.error("InstanceNotFound", e);
        }
    }

    /**
     * 用于标识需要加载的Bean字段或方法
     * 注意该注解虽然以human-read方式显示在jconsole里
     * 但通过代码获取的attribute亦是转换后的字符串
     */
    @Target({ElementType.METHOD, ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ShowInBean {
        String value() default "toString";
    }
}
