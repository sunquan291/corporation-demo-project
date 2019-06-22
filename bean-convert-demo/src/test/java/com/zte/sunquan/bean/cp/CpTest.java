package com.zte.sunquan.bean.cp;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * CpTest class
 *
 * @author 10184538
 * @date 2019/6/22
 */
public class CpTest {
    @Test
    public void testCp1() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Dog dog = new Dog("dog", 1, 1);
        Cat cat = new Cat("cat", 2, 2);
        PropertyUtils.copyProperties(dog, cat);
        Assert.assertEquals("cat", dog.getName());
        Assert.assertEquals(2, dog.getAge());
        Assert.assertEquals(2, dog.getGender());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCp2() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Dog dog = new Dog("dog", 1, 1);
        Pig pig = new Pig("pig", 2, 1);
        //要求属性类型一致
        PropertyUtils.copyProperties(dog, pig);
    }
}