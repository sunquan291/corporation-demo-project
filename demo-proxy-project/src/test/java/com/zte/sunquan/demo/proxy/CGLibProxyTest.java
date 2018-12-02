package com.zte.sunquan.demo.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackHelper;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import com.zte.sunquan.demo.domain.UserDAO;
import com.zte.sunquan.demo.domain.UserDAOImpl;

/**
 * Created by 10184538 on 2018/5/31.
 */
public class CGLibProxyTest {
    @Test
    public void testCGLib() {
        //cglib动态代理三步
        //第一步：实例化Enhancer enhancer = new Enhancer();
        //第二步：设置代理类类型与切面回调
        //第三步：执行方法
        UserDAO userDAO = CGLibUtils.createProxy(UserDAOImpl.class);
        userDAO.addUser("1", "sunquan", "123456");
    }

    @Test
    public void testCGLib2() {
        UserDAO userDAO = CGLibUtils.createProxy(UserDAOImpl.class, new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //切方法
                System.out.println("invoke before");
                Object result = methodProxy.invokeSuper(o, objects);
                //Object result = method.invoke(o,objects);循环调用???
                System.out.println("invoke after");
                return result;
            }
        });
        userDAO.addUser("1", "sunquan", "123456");
    }

    @Test
    public void testCGLib3() {
        UserDAO userDAO = CGLibUtils.createProxy(UserDAOImpl.class, new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                //切方法
                System.out.println("invoke before");
                Object result = true;
                //Object result = method.invoke(o,objects);
                System.out.println("invoke after");
                return result;
            }
        });
        userDAO.addUser("1", "sunquan", "123456");
    }

    @Test
    public void testCGLib4() {
        UserDAO userDAO = CGLibUtils.createProxy(UserDAOImpl.class, new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return false;
            }
        });
        boolean result = userDAO.addUser("1", "sunquan", "123456");
        System.out.println(result);
    }

    @Test
    public void testCGLib5() {
//        UserDAO userDAO = CGLibUtils.createProxy(UserDAOImpl.class, new CallbackHelper(UserDAO.class, UserDAO.class.getInterfaces()) {
//            @Override
//            protected Object getCallback(Method method) {
//                if (method.getName().equals("addUser"))
//                    return method;
//                return method;
//            }
//        });
//        boolean result = userDAO.addUser("1", "sunquan", "123456");
//        System.out.println(result);
    }
}
