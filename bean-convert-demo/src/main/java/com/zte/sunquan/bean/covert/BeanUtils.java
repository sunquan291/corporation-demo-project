package com.zte.sunquan.bean.covert;


import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanUtils<T, U> {
//    public static <T, U> void shallowConvert(T src, U dst) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        Field[] fields = src.getClass().getDeclaredFields();
//        for (Field field : fields) {
//            System.out.println(field.getName());
//            field.setAccessible(true);
//            Field dstField = null;
//            try {
//                dstField = dst.getClass().getDeclaredField(field.getName());
//            } catch (NoSuchFieldException e) {
//                continue;
//            }
//            if (dstField == null)
//                continue;
//            dstField.setAccessible(true);
//            if (field.getType().getSuperclass() == Enum.class) {
//                Object value = field.get(src);
//                if (value == null)
//                    continue;
//                Method toIndex = field.getType().getMethod("toIndex", String.class);
//                Object intValue = toIndex.invoke(null, value.toString());
//                dstField.set(dst, intValue);
//            } else {
//                dstField.set(dst, field.get(src));
//            }
//        }
//    }

    public static <T, U> void shallowConvert(T src, U dst) throws IntrospectionException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        BeanInfo beanInfo = Introspector.getBeanInfo(src.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor srcDes : propertyDescriptors) {
            if (srcDes.getName().equals("class"))
                continue;
            PropertyDescriptor dstDes = new PropertyDescriptor(srcDes.getName(), dst.getClass());
            Object value = srcDes.getReadMethod().invoke(src);
            if (null == value)
                continue;
            if (isEnum(srcDes.getPropertyType())) {
                //toIndex string->int
                Method toIndex = srcDes.getPropertyType().getMethod("toIndex", String.class);
                Object intValue = toIndex.invoke(null, value.toString());
                dstDes.getWriteMethod().invoke(dst, intValue);

            } else
                dstDes.getWriteMethod().invoke(dst, value);
        }
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
