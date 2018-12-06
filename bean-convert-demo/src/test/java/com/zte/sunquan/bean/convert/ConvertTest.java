package com.zte.sunquan.bean.convert;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.zte.sunquan.bean.covert.BeanUtils;

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

    @Test
    public void testBean5() throws Exception {
        BeanSrc beanSrc = new BeanSrc();
        beanSrc.setName("sunquan");
        beanSrc.setAge(28);
        beanSrc.setTopic("topic1");
        beanSrc.setGender(null);
        SubBean subBean = new SubBean();
        subBean.setName("sub-bean");
        beanSrc.setSubBean(subBean);

        BeanDst beanDst = new BeanDst();
        BeanUtils.<BeanSrc, BeanDst>shallowConvert(beanSrc, beanDst);
        System.out.println(beanDst);
        SubBean dstSubBean = new SubBean();
        BeanUtils.shallowConvert(subBean, dstSubBean);
        System.out.println(dstSubBean);

        beanDst.setSubBean(dstSubBean);
        System.out.println(beanDst);
    }


    @Test
    public void testBeanField() throws Exception {
        Object value = BeanUtils.fieldConvert("name", "sunquan", BeanSrc.class);
        Assert.assertEquals("sunquan", value);
        value = BeanUtils.fieldConvert("gender", "BOY", BeanSrc.class);
        Assert.assertEquals(1, value);
        value = BeanUtils.fieldConvert("info-details", "info", BeanSrc.class);
        Assert.assertEquals("info", value);
    }

    @Test
    public void testBeanField2() throws Exception {
        Object value = BeanUtils.jsonFieldConvert("info-details", "info", BeanSrc.class);
        Assert.assertEquals("info", value);
    }

    @Test
    public void testBeanField3() throws Exception {
        Object value = BeanUtils.jsonFieldConvert("not-params", "param", BeanSrc.class);
        Assert.assertEquals("param", value);
    }
}
