package com.zte.sunquan.bean.covert;


import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

import lombok.extern.slf4j.Slf4j;

import com.zte.sunquan.bean.annoation.Converter;
import com.zte.sunquan.bean.annoation.Store;
import com.zte.sunquan.bean.annoation.StoreConvert;

/**
 * 操作模型与存储模型转化
 */
@Slf4j
public class ModelBeanUtils<T, U> {
    public static final int OPER2STORE = 1;
    public static final int STORE2OPER = 2;
    private final static String ENUM_TO_INDEX = "toIndex";

    public static <T, U> void convert(T src, U dst) {
        convert(src, dst, OPER2STORE);
    }

    /**
     * Bean模型转换，只针对基本类型+String的映射转换
     *
     * @param src
     * @param dst
     * @param <T>
     * @param <U>
     */
    public static <T, U> void convert(T src, U dst, int direction) {
        Objects.requireNonNull(src, "src object can  not be null.");
        Objects.requireNonNull(dst, "src object can  not be null.");
        Object source;
        Object dest;
        if (direction == OPER2STORE) {
            source = src;
            dest = dst;
        } else if (direction == STORE2OPER) {
            source = dst;
            dest = src;
        }
        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(src.getClass());
        } catch (IntrospectionException e) {
            log.error("ERROR:{} is not java bean", src.getClass());
        }
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor srcDes : propertyDescriptors) {
            if (srcDes.getName().equals("class"))
                continue;//不处理
            Class<?> srcFieldType = srcDes.getPropertyType();
            try {
                if (srcFieldType == String.class || srcFieldType.isPrimitive() || Number.class.isAssignableFrom(srcFieldType)) {
                    PropertyDescriptor dstDes = new PropertyDescriptor(srcDes.getName(), dst.getClass());
                    Object value = srcDes.getReadMethod().invoke(src);
                    dstDes.getWriteMethod().invoke(dst, value);
                } else if (Indexable.class.isAssignableFrom(srcDes.getPropertyType())) {
                    PropertyDescriptor dstDes = new PropertyDescriptor(srcDes.getName(), dst.getClass());
                    Indexable value = (Indexable) srcDes.getReadMethod().invoke(src);
                    if (value == null)
                        continue;
                    dstDes.getWriteMethod().invoke(dst, value.index(value));
                } else if (isEnum(srcDes.getPropertyType())) {
                    PropertyDescriptor dstDes = new PropertyDescriptor(srcDes.getName(), dst.getClass());
                    Object value = srcDes.getReadMethod().invoke(src);
                    if (value == null)
                        continue;
                    //toIndex string->int
                    Method toIndex = srcDes.getPropertyType().getMethod(ENUM_TO_INDEX, String.class);
                    Object intValue = toIndex.invoke(null, value.toString());
                    dstDes.getWriteMethod().invoke(dst, intValue);
                } else {
                    //复杂类型
                    //1是否序列化至存储模型字段
                    String fieldName = Character.toLowerCase(srcDes.getName().charAt(0)) + srcDes.getName().substring(1);
                    Field field = src.getClass().getDeclaredField(fieldName);
                    boolean handleByAnnotation = false;
                    for (Annotation annotation : field.getAnnotations()) {
                        if (annotation instanceof StoreConvert) {
                            //执行序列化动作
                            Class<? extends Converter> converter = ((StoreConvert) annotation).converter();
                            Object srcValue = srcDes.getReadMethod().invoke(src);
                            Object convertValue = converter.newInstance().convert(srcValue);
                            PropertyDescriptor dstDes = new PropertyDescriptor(srcDes.getName(), dst.getClass());
                            dstDes.getWriteMethod().invoke(dst, convertValue);
                            handleByAnnotation = true;
                        } else if (annotation instanceof Store) {
                            //不支持
                        }

                    }
                    if (handleByAnnotation)
                        continue;
                    //没有任何注解
                    System.out.println("complex field " + srcDes.getName());
                    Object srcValue = srcDes.getReadMethod().invoke(src);
                    if (srcValue == null)
                        continue;
                    PropertyDescriptor dstDes = new PropertyDescriptor(srcDes.getName(), dst.getClass());
                    Object dstFieldInstance = dstDes.getPropertyType().newInstance();
                    convert(srcValue, dstFieldInstance, direction);
                    dstDes.getWriteMethod().invoke(dst, dstFieldInstance);
                }
            } catch (IntrospectionException e) {
                log.error("IntrospectionException", e);
            } catch (NoSuchFieldException e) {
                log.error("NoSuchFieldException", e);
            } catch (InvocationTargetException e) {
                log.error("InvocationTargetException", e);
            } catch (IllegalAccessException e) {
                log.error("IllegalAccessException", e);
            } catch (NoSuchMethodException e) {
                log.error("NoSuchMethodException", e);
            } catch (InstantiationException e) {
                log.error("InstantiationException", e);
            }
        }


    }


    public static <T, U> void convert2(T src, U dst, int direction) {
        Objects.requireNonNull(src, "src object can  not be null.");
        Objects.requireNonNull(dst, "src object can  not be null.");
        Object source = null;
        Object dest = null;
        if (direction == OPER2STORE) {
            source = src;
            dest = dst;
        } else if (direction == STORE2OPER) {
            source = dst;
            dest = src;
        }
//////////////////////////////////////////////
        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(src.getClass());
        } catch (IntrospectionException e) {
            log.error("ERROR:{} is not java bean", src.getClass());
        }
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor srcDes : propertyDescriptors) {
            if (srcDes.getName().equals("class"))
                continue;//不处理
            Class<?> srcFieldType = srcDes.getPropertyType();
            try {
                if (srcFieldType == String.class || srcFieldType.isPrimitive() || Number.class.isAssignableFrom(srcFieldType)) {
                    PropertyDescriptor dstDes = new PropertyDescriptor(srcDes.getName(), dst.getClass());
                    Object value = srcDes.getReadMethod().invoke(src);
                    dstDes.getWriteMethod().invoke(dst, value);
                } else if (Indexable.class.isAssignableFrom(srcDes.getPropertyType())) {
                    PropertyDescriptor dstDes = new PropertyDescriptor(srcDes.getName(), dst.getClass());
                    Indexable value = (Indexable) srcDes.getReadMethod().invoke(src);
                    if (value == null)
                        continue;
                    dstDes.getWriteMethod().invoke(dst, value.index(value));
                } else if (isEnum(srcDes.getPropertyType())) {
                    PropertyDescriptor dstDes = new PropertyDescriptor(srcDes.getName(), dst.getClass());
                    Object value = srcDes.getReadMethod().invoke(src);
                    if (value == null)
                        continue;
                    //toIndex string->int
                    Method toIndex = srcDes.getPropertyType().getMethod(ENUM_TO_INDEX, String.class);
                    Object intValue = toIndex.invoke(null, value.toString());
                    dstDes.getWriteMethod().invoke(dst, intValue);
                } else {
                    //复杂类型
                    //1是否序列化至存储模型字段
                    String fieldName = Character.toLowerCase(srcDes.getName().charAt(0)) + srcDes.getName().substring(1);
                    Field field = src.getClass().getDeclaredField(fieldName);
                    boolean handleByAnnotation = false;
                    for (Annotation annotation : field.getAnnotations()) {
                        if (annotation instanceof StoreConvert) {
                            //执行序列化动作
                            Class<? extends Converter> converter = ((StoreConvert) annotation).converter();
                            Object srcValue = srcDes.getReadMethod().invoke(src);
                            Object convertValue = converter.newInstance().convert(srcValue);
                            PropertyDescriptor dstDes = new PropertyDescriptor(srcDes.getName(), dst.getClass());
                            dstDes.getWriteMethod().invoke(dst, convertValue);
                            handleByAnnotation = true;
                        } else if (annotation instanceof Store) {
                            //不支持
                        }

                    }
                    if (handleByAnnotation)
                        continue;
                    //没有任何注解
                    System.out.println("complex field " + srcDes.getName());
                    Object srcValue = srcDes.getReadMethod().invoke(src);
                    if (srcValue == null)
                        continue;
                    PropertyDescriptor dstDes = new PropertyDescriptor(srcDes.getName(), dst.getClass());
                    Object dstFieldInstance = dstDes.getPropertyType().newInstance();
                    convert(srcValue, dstFieldInstance, direction);
                    dstDes.getWriteMethod().invoke(dst, dstFieldInstance);
                }
            } catch (IntrospectionException e) {
                log.error("IntrospectionException", e);
            } catch (NoSuchFieldException e) {
                log.error("NoSuchFieldException", e);
            } catch (InvocationTargetException e) {
                log.error("InvocationTargetException", e);
            } catch (IllegalAccessException e) {
                log.error("IllegalAccessException", e);
            } catch (NoSuchMethodException e) {
                log.error("NoSuchMethodException", e);
            } catch (InstantiationException e) {
                log.error("InstantiationException", e);
            }
        }

    }

    public static <T, U> void convert(T src, U dst, List<Object> result) {
        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(src.getClass());
        } catch (IntrospectionException e) {
            log.error("ERROR:{} is not java bean", src.getClass());
        }
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor srcDes : propertyDescriptors) {
            if (srcDes.getName().equals("class"))
                continue;//不处理
            Class<?> srcFieldType = srcDes.getPropertyType();
            try {
                if (srcFieldType == String.class || srcFieldType.isPrimitive() || Number.class.isAssignableFrom(srcFieldType)) {
                    PropertyDescriptor dstDes = new PropertyDescriptor(srcDes.getName(), dst.getClass());
                    Object value = srcDes.getReadMethod().invoke(src);
                    dstDes.getWriteMethod().invoke(dst, value);
                } else if (isEnum(srcDes.getPropertyType())) {
                    PropertyDescriptor dstDes = new PropertyDescriptor(srcDes.getName(), dst.getClass());
                    Object value = srcDes.getReadMethod().invoke(src);
                    if (value == null)
                        continue;
                    //toIndex string->int
                    Method toIndex = srcDes.getPropertyType().getMethod(ENUM_TO_INDEX, String.class);
                    Object intValue = toIndex.invoke(null, value.toString());
                    dstDes.getWriteMethod().invoke(dst, intValue);
                } else {
                    //复杂类型
                    //1是否序列化至存储模型字段
                    String fieldName = Character.toLowerCase(srcDes.getName().charAt(0)) + srcDes.getName().substring(1);
                    Field field = src.getClass().getDeclaredField(fieldName);
                    boolean handleByAnnotation = false;
                    for (Annotation annotation : field.getAnnotations()) {
                        if (annotation instanceof StoreConvert) {
                            //执行序列化动作
                            handleByAnnotation = true;
                        } else if (annotation instanceof Store) {
                            Class persistenceClass = ((Store) annotation).value();
                            //执行另一个类的序列化
                            Object srcValue = srcDes.getReadMethod().invoke(src);
                            Object dstFieldInstance = persistenceClass.newInstance();
                            convert(srcValue, dstFieldInstance, result);
                            handleByAnnotation = true;
                        }

                    }
                    if (handleByAnnotation)
                        continue;
                    //没有任何注解
                    System.out.println("complex field " + srcDes.getName());
                    Object srcValue = srcDes.getReadMethod().invoke(src);
                    if (srcValue == null)
                        continue;
                    PropertyDescriptor dstDes = new PropertyDescriptor(srcDes.getName(), dst.getClass());
                    Object dstFieldInstance = dstDes.getPropertyType().newInstance();
                    convert(srcValue, dstFieldInstance, result);
                    dstDes.getWriteMethod().invoke(dst, dstFieldInstance);
                }
            } catch (IntrospectionException e) {
                log.error("IntrospectionException", e);
            } catch (NoSuchFieldException e) {
                log.error("NoSuchFieldException", e);
            } catch (InvocationTargetException e) {
                log.error("InvocationTargetException", e);
            } catch (IllegalAccessException e) {
                log.error("IllegalAccessException", e);
            } catch (NoSuchMethodException e) {
                log.error("NoSuchMethodException", e);
            } catch (InstantiationException e) {
                log.error("InstantiationException", e);
            }
        }
        result.add(dst);
    }

    private static boolean isEnum(Class cls) {
        boolean flag = false;
        Class cur = cls;
        while (cur != null && cur != Object.class) {
            if (cur == Enum.class) {
                flag = true;
                break;
            }
            cur = cur.getSuperclass();
        }
        return flag;
    }

}
