package com.zte.sunquan.bean.convert;

import com.zte.sunquan.bean.covert.BeanUtils;
import org.junit.Test;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

public class ConvertTest {
    @Test
    public void testBean1() throws Exception {
        BeanSrc beanSrc = new BeanSrc();
        beanSrc.setName("sunquan");
        beanSrc.setAge(28);
        BeanDst beanDst = new BeanDst();
        BeanUtils.<BeanSrc, BeanDst>shallowConvert(beanSrc, beanDst);
        System.out.println(beanDst);
    }

    @Test
    public void testBean2() throws Exception {
        BeanSrc beanSrc = new BeanSrc();
        beanSrc.setName("sunquan");
        beanSrc.setAge(28);
        beanSrc.setGender(Gender.BOY);
        BeanDst beanDst = new BeanDst();
        BeanUtils.<BeanSrc, BeanDst>shallowConvert(beanSrc, beanDst);
        System.out.println(beanDst);
    }

    @Test
    public void testBean3() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException, IntrospectionException {
        BeanSrc beanSrc = new BeanSrc();
        beanSrc.setName("sunquan");
        beanSrc.setAge(28);
        beanSrc.setTopic("topic1");
        beanSrc.setGender(Gender.BOY);
        BeanDst beanDst = new BeanDst();
        BeanUtils.<BeanSrc, BeanDst>shallowConvert(beanSrc, beanDst);
        System.out.println(beanDst);
    }

    @Test
    public void testBean4() throws Exception {
        BeanSrc beanSrc = new BeanSrc();
        beanSrc.setName("sunquan");
        beanSrc.setAge(28);
        beanSrc.setTopic("topic1");
        beanSrc.setGender(null);
        BeanDst beanDst = new BeanDst();
        BeanUtils.<BeanSrc, BeanDst>shallowConvert(beanSrc, beanDst);
        System.out.println(beanDst);
    }
}
