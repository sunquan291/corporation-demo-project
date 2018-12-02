package com.zte.sunquan.demo.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.Mixin;
import net.sf.cglib.proxy.NoOp;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by 10184538 on 2017/2/24.
 */
public class CGLibTest {
    @Test
    public void testUserDao() {
        UserDao useDaoProxy = CGLibUtils.createProxy(UserDao.class);
        useDaoProxy.setName("sunquan");
        String name = useDaoProxy.getName();
        Assert.assertEquals("sunquan", name);
    }

    @Test
    public void testUserDao2() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDao.class);
        enhancer.setCallback(new AuthorizationInterceptor());
        UserDao useDaoProxy = (UserDao) enhancer.create();
        useDaoProxy.setName("sunquan");
        String name = useDaoProxy.getName();
        Assert.assertEquals("sunquan", name);
    }

    @Test
    public void testUserDao3() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDao.class);
        enhancer.setCallbackFilter(new PersistenceServiceCallbackFilter());
        enhancer.setCallbacks(Arrays.asList(new AuthorizationInterceptor(), NoOp.INSTANCE).toArray(new Callback[]{}));
        UserDao useDaoProxy = (UserDao) enhancer.create();
        useDaoProxy.setName("sunquan");
        String name = useDaoProxy.getName();

    }

    @Test
    public void testUserDao4() {
        Class[] interfaces = new Class[]{UserInterface.class};//must interface
        Object[] delegates = new Object[]{new UserDao()};
        Object obj = Mixin.create(interfaces, delegates);
        ((UserInterface) obj).setName("sunquan");//must interface
        String name = ((UserInterface) obj).getName();
        Assert.assertEquals("sunquan", name);

    }

    @Test
    public void testA() {
        String a = "a" + "\\" + "b" + "\\";
        System.out.println(a.replace("\\", "\\\\"));
    }
}
