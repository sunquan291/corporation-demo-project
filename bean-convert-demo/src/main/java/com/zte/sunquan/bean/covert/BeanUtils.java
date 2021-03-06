package com.zte.sunquan.bean.covert;


import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Bean模型的转化
 *
 * @param <T>
 * @param <U>
 */
@Slf4j
public class BeanUtils<T, U> {
    private final static String TO_INDEX = "toIndex";

    /**
     * 字段值的转换(支持枚举,但注意是属性名，非JSON)
     *
     * @param fieldName
     * @param cls
     * @param <T>
     * @param <U>
     * @return
     */
    public static <T, U> Object fieldConvert(String fieldName, Object fieldValue, Class cls) throws IntrospectionException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        PropertyDescriptor des = new PropertyDescriptor(fieldName, cls);
        if (isEnum(des.getPropertyType())) {
            Method toIndex = des.getPropertyType().getMethod(TO_INDEX, String.class);
            Object intValue = toIndex.invoke(null, fieldValue);
            return intValue;
        } else {
            return fieldValue;
        }
    }

    public static <T, U> Object jsonFieldConvert(String jsonField, Object fieldValue, Class cls) {
        String fieldName = getFieldByJsonProperty(cls, jsonField);
        PropertyDescriptor des = null;
        try {
            des = new PropertyDescriptor(fieldName, cls);
            if (isEnum(des.getPropertyType())) {
                Method toIndex = des.getPropertyType().getMethod(TO_INDEX, String.class);
                Object intValue = toIndex.invoke(null, fieldValue);
                return intValue;
            } else {
                return fieldValue;
            }
        } catch (IntrospectionException e) {
            log.error("IntrospectionException", e);
        } catch (NoSuchMethodException e) {
            log.error("NoSuchMethodException", e);
        } catch (IllegalAccessException e) {
            log.error("IllegalAccessException", e);
        } catch (InvocationTargetException e) {
            log.error("InvocationTargetException", e);
        }
        return fieldValue;
    }

    public static String getFieldByJsonProperty(Class searchType, String jsonPropertyName) {
        while (!Object.class.equals(searchType) && searchType != null) {
            Field[] fields = searchType.getDeclaredFields();
            for (Field field : fields) {
                if (field.getName().equals(jsonPropertyName)) {
                    return jsonPropertyName;
                }
                if (field.isAnnotationPresent(JsonProperty.class)) {
                    JsonProperty myAnnotation = field.getAnnotation(JsonProperty.class);
                    if (myAnnotation.value().equals(jsonPropertyName)) {
                        return field.getName();
                    }
                } else if (camel2KebabCase(field.getName()).equals(jsonPropertyName)) {
                    return field.getName();
                }
            }
            searchType = searchType.getSuperclass();
        }
        return null;
    }

    private static String kebab2CamelCase(String input) {
        if (input == null) return input;
        int length = input.length();
        if (length == 0) {
            return input;
        }
        StringBuilder result = new StringBuilder(length + (length >> 1));
        for (int i = 0; i < length; i++) {
            char ch = input.charAt(i);
            if (ch == '-') {
                int j = i + 1;
                if (j < length) {
                    result.append(Character.toUpperCase(input.charAt(j)));
                    i = i + 1;
                }
            }
            result.append(ch);
        }
        return result.toString();
    }

    private static String camel2KebabCase(String input) {
        if (input == null) return input; // garbage in, garbage out
        int length = input.length();
        if (length == 0) {
            return input;
        }

        StringBuilder result = new StringBuilder(length + (length >> 1));

        int upperCount = 0;

        for (int i = 0; i < length; ++i) {
            char ch = input.charAt(i);
            char lc = Character.toLowerCase(ch);

            if (lc == ch) { // lower-case letter means we can get new word
                // but need to check for multi-letter upper-case (acronym), where assumption
                // is that the last upper-case char is start of a new word
                if (upperCount > 1) {
                    // so insert hyphen before the last character now
                    result.insert(result.length() - 1, '-');
                }
                upperCount = 0;
            } else {
                // Otherwise starts new word, unless beginning of string
                if ((upperCount == 0) && (i > 0)) {
                    result.append('-');
                }
                ++upperCount;
            }
            result.append(lc);
        }
        return result.toString();
    }


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
    public static <T, U> void shallowConvert(T src, U dst) throws IntrospectionException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
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

                    //srcDes.getPropertyType().getEnumConstants()[0]

                    Object intValue = toIndex.invoke(null, value.toString());
                    dstDes.getWriteMethod().invoke(dst, intValue);
                } else {
                    //复杂类型
                    System.out.println("complex field " + srcFieldType.getName());
                    Object srcFieldInstance = srcFieldType.newInstance();
                    PropertyDescriptor dstDes = new PropertyDescriptor(srcDes.getName(), dst.getClass());
                    Object dstFieldInstance = dstDes.getPropertyType().newInstance();
                    shallowConvert(srcFieldInstance, dstFieldInstance);

                    dstDes.getWriteMethod().invoke(dst, dstFieldInstance);

                }
            } catch (IntrospectionException e) {
                System.out.println("not found " + srcDes.getName() + " in dest object.");
            }
        }
    }

    /**
     * 判断一个对象是否是基本类型或基本类型的封装类型
     */
    private static boolean isPrimitive(Object obj) {
        try {
            return ((Class<?>) obj.getClass().getField("TYPE").get(null)).isPrimitive();
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isPrimitiveExceptString(Class cls) {
        if (cls == String.class)
            return true;
        try {
            //return ((Class<?>) cls.getField("TYPE").get(null)).isPrimitive();
            return cls.isPrimitive();
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isEnum(Class cls) {
//        boolean flag = false;
//        Class cur = cls;
//        while (cur != null && cur != Object.class) {
//            if (cur == Enum.class) {
//                flag = true;
//                break;
//            }
//            cur = cur.getSuperclass();
//        }
//        return flag;

        return Enum.class.isAssignableFrom(cls);
    }
}
