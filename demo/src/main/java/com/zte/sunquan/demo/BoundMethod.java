package com.zte.sunquan.demo;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import org.junit.Test;

/**
 * Created by sunquan on 2018/4/4.
 * 高性能反射
 */
public class BoundMethod {
    public void print(String p) {
        System.out.println("sunquan:" + p);
    }

    @Test
    public void testBound() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        //找方法(1方法参数2方法名)
        MethodType mt = MethodType.methodType(void.class, String.class);
        MethodHandle mh = lookup.findVirtual(BoundMethod.class, "print", mt);
        //绑对象
        mh = mh.bindTo(new BoundMethod());
        mh.invoke("Hello World");
    }

    //https://www.programcreek.com/java-api-examples/index.php?api=java.lang.invoke.MethodHandles
    //（1）创建MethodType对象，指定方法的签名；
    //（2）在MethodHandles.Lookup中查找类型为MethodType的MethodHandle；
    //（3）传入方法参数并调用MethodHandle.invoke或者MethodHandle.invokeExact方法。

    //https://blog.csdn.net/jQuerys/article/details/50922634
    //http://fair-jm.iteye.com/blog/1997108
    @Test
    public void testBound2() throws Throwable {
        //private method
        Method print = Pair.class.getDeclaredMethod("print", String.class);
        print.setAccessible(true);
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.unreflect(print);
        mh = mh.bindTo(new Pair<String>("a", "1"));
        mh.invoke("Hello World");
    }
}
