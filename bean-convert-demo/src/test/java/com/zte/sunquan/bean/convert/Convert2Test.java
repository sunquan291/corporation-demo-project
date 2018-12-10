package com.zte.sunquan.bean.convert;

import com.esotericsoftware.reflectasm.MethodAccess;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Convert2Test {
    @Test
    public void testPropertyUtils() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        BeanSrc beanSrc = new BeanSrc();
        beanSrc.setName("sunquan");
        beanSrc.setAge(28);
        beanSrc.setTopic("topic1");
        beanSrc.setGender(null);
        SubBean subBean = new SubBean();
        subBean.setName("sub-bean");
        beanSrc.setSubBean(subBean);

        BeanDst beanDst = new BeanDst();
        PropertyUtils.copyProperties(beanDst, beanSrc);
        System.out.println(beanDst);
    }

    @Test
    public void testBeanUtils() throws InvocationTargetException, IllegalAccessException {
        BeanSrc beanSrc = new BeanSrc();
        beanSrc.setName("sunquan");
        beanSrc.setAge(28);
        beanSrc.setTopic("topic1");
        beanSrc.setGender(null);
        SubBean subBean = new SubBean();
        subBean.setName("sub-bean");
        beanSrc.setSubBean(subBean);
        BeanDst beanDst = new BeanDst();
        BeanUtils.copyProperties(beanDst, beanSrc);
        System.out.println(beanDst);
    }

    @Test
    public void testAsm() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        BeanSrc beanSrc = new BeanSrc();
        beanSrc.setName("sunquan");
        beanSrc.setAge(28);
        beanSrc.setTopic("topic1");
        beanSrc.setGender(null);
        SubBean subBean = new SubBean();
        subBean.setName("sub-bean");
        beanSrc.setSubBean(subBean);
        long current = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++)
            testJDKReflect(beanSrc);
        System.out.println(System.currentTimeMillis() - current);
        current = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++)
            testReflectAsm(beanSrc);
        System.out.println(System.currentTimeMillis() - current);

        //下列的使用方法，性能急剧上升，但MethodAccess处理耗时，需要缓存或提前处理
        current = System.currentTimeMillis();
        MethodAccess access = MethodAccess.get(beanSrc.getClass());
        for (int i = 0; i < 100000; i++)
            testReflectAsm2(access, beanSrc);
        System.out.println(System.currentTimeMillis() - current);

        current = System.currentTimeMillis();
        int setName = access.getIndex("setName", String.class);
        for (int i = 0; i < 100000; i++)
            testReflectAsm3(access, setName, beanSrc);
        System.out.println(System.currentTimeMillis() - current);
    }

    private void testJDKReflect(Object object) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method setName = object.getClass().getMethod("setName", String.class);
        setName.invoke(object, "sunquan");
    }

    private void testReflectAsm(Object object) {
        MethodAccess access = MethodAccess.get(object.getClass());
        access.invoke(object, "setName", "sunquan");
        //  String name = (String) access.invoke(beanSrc, "getName", null);
    }

    private void testReflectAsm2(MethodAccess access, Object object) {
        access.invoke(object, "setName", "sunquan");
        //  String name = (String) access.invoke(beanSrc, "getName", null);
        //ConstructorAccess<BeanSrc> access2 = ConstructorAccess.get(object.getClass());
    }

    private void testReflectAsm3(MethodAccess access, int index, Object object) {
        access.invoke(object, index, "sunquan");
    }
}
