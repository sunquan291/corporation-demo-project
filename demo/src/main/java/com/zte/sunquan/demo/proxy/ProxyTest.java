package com.zte.sunquan.demo.proxy;


import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.Base64;

/**
 * Created by 10184538 on 2017/11/29.
 */
public class ProxyTest {
    @Test
    public void proxyTest() {
        HelloImpl impl = new HelloImpl();
        LogHandler handler = new LogHandler(impl);
        //这里把handler与impl新生成的代理类相关联
        Class[] cls = new Class[]{Hello.class, Hello.class};
        Hello hello = (Hello) Proxy.newProxyInstance(impl.getClass().getClassLoader(), cls, handler);
        //这里无论访问哪个方法，都是会把请求转发到handler.invoke
        hello.print("All the test");
        hello.sayHello("Denny");
    }


    @Before
    public void init() throws IOException {
        String path = "E:\\sunquan-project\\demo\\target\\classes\\com\\zte\\sunquan\\demo\\proxy\\HelloImpl.class";
        java.io.FileInputStream in = new java.io.FileInputStream(path);
        byte[] original = new byte[in.available()];
        in.read(original);
        in.close();
        byte[] encode = Base64.getEncoder().encode(original);
        //output encode byte
        FileOutputStream out = new FileOutputStream("D:/out.file");
        out.write(encode);
        out.flush();
        out.close();
    }

    @Test
    public void test() throws IOException, IllegalAccessException, InstantiationException {
        File f = new File("D:/out.file");
        if (f.exists() && f.isFile()) {
            FileInputStream in = new FileInputStream(f);
            byte[] original = new byte[in.available()];
            in.read(original);//got encode byte
            in.close();
            byte[] decode = Base64.getDecoder().decode(original);
//            byte[] decode = original;
            SQClassLoader loader = new SQClassLoader();
            Class hello = loader.defineClass(decode, null);
            Object o1 = hello.newInstance();
            System.out.println(o1.getClass().getClassLoader());
            System.out.println(Hello.class.getClassLoader());
            Hello o = (Hello) hello.newInstance();
            o.sayHello("sunquan");
        }
    }
}
