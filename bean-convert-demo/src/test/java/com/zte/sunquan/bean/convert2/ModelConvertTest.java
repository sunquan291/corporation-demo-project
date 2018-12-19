package com.zte.sunquan.bean.convert2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.zte.sunquan.bean.covert.ModelBeanUtils;

public class ModelConvertTest {

    @Test
    public void testBean5() throws Exception {
        BeanA beanA = new BeanA();
        beanA.setName("sunquan");
        beanA.setAge(28);
        beanA.setTopic("topic1");
        beanA.setGender(AGender.BOY);
        ASubBean subBean = new ASubBean();
        subBean.setName("sub-bean");
        beanA.setSubBean(subBean);

        BeanB beanB = new BeanB();
        ModelBeanUtils.<BeanA, BeanB>convert(beanA, beanB);
        System.out.println(beanB);
    }

    @Test
    public void testEnum() {
        boolean assignableFrom = Enum.class.isAssignableFrom(AGender.class);
        System.out.println(assignableFrom);
    }


    @Test
    public void testBean6() throws Exception {
        List<Object> result = new ArrayList<>();

        BeanA beanA = new BeanA();
        beanA.setName("sunquan");
        beanA.setAge(28);
        beanA.setTopic("topic1");
        beanA.setGender(AGender.BOY);
        ASubBean subBean = new ASubBean();
        subBean.setName("sub-bean");
        beanA.setSubBean(subBean);

        BeanB beanB = new BeanB();
        ModelBeanUtils.<BeanA, BeanB>convert(beanA, beanB, result);
        System.out.println(result);
    }

    @Test
    public void testBean7() throws Exception {
        List<Object> result = new ArrayList<>();

        BeanA beanA = new BeanA();
        beanA.setName("sunquan");
        beanA.setAge(28);
        beanA.setTopic("topic1");
        beanA.setGender(AGender.BOY);

        ASubBean bSubBean = new ASubBean();
        bSubBean.setName("hello,world");
        beanA.setBSubBean(bSubBean);

        ASubBean subBean = new ASubBean();
        subBean.setName("sub-bean");
        beanA.setSubBean(subBean);

        BeanB beanB = new BeanB();
        ModelBeanUtils.<BeanA, BeanB>convert(beanA, beanB, result);
        result.forEach(System.out::println);
    }


    @Test
    public void testBean8() throws Exception {
        BeanA beanA = new BeanA();
        beanA.setName("sunquan");
        beanA.setAge(28);
        beanA.setTopic("topic1");
        beanA.setGender(AGender.BOY);
        beanA.setBGender(BGender.GIRL);

        BeanB beanB = new BeanB();
        ModelBeanUtils.<BeanA, BeanB>convert(beanA, beanB);
        System.out.println(beanB);
    }

    @Test
    public void testBean9() throws Exception {
        BeanA beanA = new BeanA();
        beanA.setName("sunquan");
        beanA.setAge(28);
        beanA.setTopic("topic1");
        beanA.setGender(AGender.BOY);
        beanA.setBGender(BGender.GIRL);

        ASubBean bSubBean = new ASubBean();
        bSubBean.setName("hello,world");
        beanA.setBSubBean(bSubBean);

        beanA.setASubBean(bSubBean);

        BeanB beanB = new BeanB();
        ModelBeanUtils.<BeanA, BeanB>convert(beanA, beanB);
        System.out.println(beanB);
    }

}
