package com.zte.sunquan.bean.covert;


import com.zte.sunquan.bean.annoation.Persistence;
import com.zte.sunquan.bean.annoation.PersistenceSerialize;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 操作模型与存储模型转化
 */
public class ModelBeanUtils<T, U> {
    private final static String TO_INDEX = "toIndex";


    /**
     * Bean模型转换，只针对基本类型+String的映射转换
     *
     * @param src
     * @param dst
     * @param <T>
     * @param <U>
     * @throws IntrospectionException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    public static <T, U> void convert(T src, U dst) throws IntrospectionException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        BeanInfo beanInfo = Introspector.getBeanInfo(src.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor srcDes : propertyDescriptors) {
            if (srcDes.getName().equals("class"))
                continue;//不处理
            Class<?> srcFieldType = srcDes.getPropertyType();
            try {
                if (srcFieldType == String.class || srcFieldType.isPrimitive()) {
                    PropertyDescriptor dstDes = new PropertyDescriptor(srcDes.getName(), dst.getClass());
                    Object value = srcDes.getReadMethod().invoke(src);
                    dstDes.getWriteMethod().invoke(dst, value);
                } else if (isEnum(srcDes.getPropertyType())) {
                    PropertyDescriptor dstDes = new PropertyDescriptor(srcDes.getName(), dst.getClass());
                    Object value = srcDes.getReadMethod().invoke(src);
                    if (value == null)
                        continue;
                    //toIndex string->int
                    Method toIndex = srcDes.getPropertyType().getMethod("toIndex", String.class);
                    Object intValue = toIndex.invoke(null, value.toString());
                    dstDes.getWriteMethod().invoke(dst, intValue);
                } else {
                    //复杂类型
                    //1是否序列化至存储模型字段
                    String fieldName = Character.toLowerCase(srcFieldType.getSimpleName().charAt(0)) + srcFieldType.getSimpleName().substring(1);
                    Field field = src.getClass().getDeclaredField(fieldName);
                    for (Annotation annotation : field.getAnnotations()) {
                        if (annotation instanceof PersistenceSerialize) {
                            //执行序列化动作
                        } else if (annotation instanceof Persistence) {
                            Class persistenceClass = ((Persistence) annotation).value();
                            //执行另一个类的序列化
                        }
                    }

                    System.out.println("complex field " + srcFieldType.getName());
                    Object srcFieldInstance = srcFieldType.newInstance();
                    PropertyDescriptor dstDes = new PropertyDescriptor(srcDes.getName(), dst.getClass());
                    Object dstFieldInstance = dstDes.getPropertyType().newInstance();
                    convert(srcFieldInstance, dstFieldInstance);
                    dstDes.getWriteMethod().invoke(dst, dstFieldInstance);
                }
            } catch (IntrospectionException e) {
                System.out.println("not found " + srcDes.getName() + " in dest object.");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }


    public static <T, U> void convert(T src, U dst, List<Object> result) throws IntrospectionException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        BeanInfo beanInfo = Introspector.getBeanInfo(src.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor srcDes : propertyDescriptors) {
            if (srcDes.getName().equals("class"))
                continue;//不处理
            Class<?> srcFieldType = srcDes.getPropertyType();
            try {
                if (srcFieldType == String.class || srcFieldType.isPrimitive()) {
                    PropertyDescriptor dstDes = new PropertyDescriptor(srcDes.getName(), dst.getClass());
                    Object value = srcDes.getReadMethod().invoke(src);
                    dstDes.getWriteMethod().invoke(dst, value);
                } else if (isEnum(srcDes.getPropertyType())) {
                    PropertyDescriptor dstDes = new PropertyDescriptor(srcDes.getName(), dst.getClass());
                    Object value = srcDes.getReadMethod().invoke(src);
                    if (value == null)
                        continue;
                    //toIndex string->int
                    Method toIndex = srcDes.getPropertyType().getMethod("toIndex", String.class);
                    Object intValue = toIndex.invoke(null, value.toString());
                    dstDes.getWriteMethod().invoke(dst, intValue);
                } else {
                    //复杂类型
                    //1是否序列化至存储模型字段
                    String fieldName = Character.toLowerCase(srcDes.getName().charAt(0)) + srcDes.getName().substring(1);
                    Field field = src.getClass().getDeclaredField(fieldName);
                    boolean handleByAnnotation = false;
                    for (Annotation annotation : field.getAnnotations()) {
                        if (annotation instanceof PersistenceSerialize) {
                            //执行序列化动作
                            handleByAnnotation = true;
                        } else if (annotation instanceof Persistence) {
                            Class persistenceClass = ((Persistence) annotation).value();
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
                System.out.println("not found " + srcDes.getName() + " in dest object.");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
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
