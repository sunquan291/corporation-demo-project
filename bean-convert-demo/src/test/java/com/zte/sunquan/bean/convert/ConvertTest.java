package com.zte.sunquan.bean.convert;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

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
    public void testBean3() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException, IntrospectionException, InstantiationException {
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
        beanSrc.setGender(Gender.BOY);
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
        value = BeanUtils.fieldConvert("infoDetails", "info", BeanSrc.class);
        Assert.assertEquals("info", value);
    }

    @Test
    public void testBeanField2() throws Exception {
        //测试JSON格式的输入
        Object value = BeanUtils.jsonFieldConvert("info-details", "info", BeanSrc.class);
        Assert.assertEquals("info", value);
        value = BeanUtils.jsonFieldConvert("gender", "BOY", BeanSrc.class);
        Assert.assertEquals(1, value);
    }

    @Test
    public void testBeanField3() throws Exception {
        //测试JSON格式的输入
        Object value = BeanUtils.jsonFieldConvert("not-params", "param", BeanSrc.class);
        Assert.assertEquals("param", value);
    }
}
