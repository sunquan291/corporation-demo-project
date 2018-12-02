package com.zte.sunquan.demo.proxy;

import java.lang.reflect.Proxy;

import org.junit.Test;

import com.zte.sunquan.demo.domain.UserDAO;
import com.zte.sunquan.demo.domain.UserDAOImpl;

/**
 * Created by 10184538 on 2018/5/31.
 */
public class ProxyTest {
    @Test
    public void testUserDAOProxy() {
        //1.创建代理club
        ProxyClub<UserDAO> proxyClub = new ProxyClub<>();
        //2.设置需要代码的对象实例(或通过构造函数传入) 并完成切入逻辑
        UserDAO impl = new UserDAOImpl();
        proxyClub.setRealObject(new UserDAOImpl());
        //3.根据代理club创建代理实例
        UserDAO userDAO = (UserDAO) Proxy.newProxyInstance(impl.getClass().getClassLoader(),
                new Class[]{UserDAO.class},
                proxyClub);
        //4.执行
        userDAO.addUser("1", "sunquan", "123456");
    }

    @Test
    public void testDynamicProxy(){
        //存在静态代理，自然会有动态代码，从上面静态代码的测试case中，其需要对被代理对象信息有足够了解
        //某些场景中，是无法获取被代理对象足够信息的
        //实现动态代码的方式有很多CglibProxy

    }
}
