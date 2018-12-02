package com.zte.sunquan.demo.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by 10184538 on 2017/2/20.
 */
public class TestDynamicProxy {

    @Test
    public void testA() {
        SortedSet<Integer> classes = new TreeSet<Integer>(new Comparator<Integer>() {
            public int compare(Integer object1, Integer object2) {
                System.out.println(object1.intValue() + ":" + object2.intValue());
//                if(object1.intValue()>object2.intValue())
//                    return 1;
//                else if(object1.intValue()<object2.intValue())
//                    return -1;
//                else
//                    return 0;
                return 1;
            }
        });
        classes.add(1);
        System.out.println("------");
        classes.add(2);
        classes.add(3);
//        classes.add(4);
        System.out.println(classes.first());
    }

    @Test
    public void AB() {
        Optional<Integer> optional = Optional.ofNullable(1);
        optional.map(i -> {
            System.out.println(i);
            return "a";
        }).orElseGet(() -> {
            System.out.println("bbbb");
            return "b";
        });
    }

    private void addInterface(Map<String, Class> map, Class[] cls) {
        for (Class c : cls)
            map.putIfAbsent(c.getName(), c);
        for (Class c : cls) {
            if (c.getInterfaces() != null && c.getInterfaces().length > 0) {
                addInterface(map, c.getInterfaces());
            }
        }
    }

    interface C {

    }
    interface D extends C{

    }

    class A implements C,D {

    }

    @Test
    public void testAC() {
        Map<String, Class> map = new HashMap<>();
        Class[] cls = {A.class};
        addInterface(map, cls);
        map.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
    }

    @Test
    public void testTree() {

        List<Class<?>> ifaces = new ArrayList<>();


        SortedSet<Class<?>> classes = new TreeSet<Class<?>>(new Comparator<Class<?>>() {
            public int compare(Class<?> object1, Class<?> object2) {
                System.out.println("object1:" + object1 + "--object2:" + object2);
                if (object1.getName().equals(object2.getName())) {
                    return 0;
                } else if (object1.isAssignableFrom(object2)) {
                    // first class is parent of second, it occurs earlier in type hierarchy
                    return -1;
                } else if (object2.isAssignableFrom(object1)) {
                    // second class is subclass of first one, it occurs later in hierarchy
                    return 1;
                }
                // types have separate inheritance trees, so it doesn't mater which one is first or second,
                // however we can't mark them as equal cause one of them will be removed
                return 1;
            }
        });
        System.out.println(MA.class.isAssignableFrom(MB.class));
        classes.add(Subject.class);
        System.out.println("===1====");
        classes.add(Hello.class);
        System.out.println("====2===");
        classes.add(MB.class);
        System.out.println("====3===");
        classes.add(MA.class);
        System.out.println("====4===");
        System.out.println(classes.size());
        System.out.println(classes.last());
        SortedSet<Class<?>> classes2 = new TreeSet<Class<?>>(new Comparator<Class<?>>() {
            public int compare(Class<?> object1, Class<?> object2) {
                if (object1.getName().equals(object2.getName())) {
                    return 0;
                } else if (object1.isAssignableFrom(object2)) {
                    // first class is parent of second, it occurs earlier in type hierarchy
                    return -1;
                } else if (object2.isAssignableFrom(object1)) {
                    // second class is subclass of first one, it occurs later in hierarchy
                    return 1;
                }
                // types have separate inheritance trees, so it doesn't mater which one is first or second,
                // however we can't mark them as equal cause one of them will be removed
                return 1;
            }
        });
        classes2.add(Hello.class);
        System.out.println("===5====");
//        classes.addAll(classes2);
        classes.add(Subject.class);
//        classes.add(MA.class);
        System.out.println("====6===");
        System.out.println(classes.size());
    }

    public static void main(String[] args) {
        Object proxyClass = Proxy.newProxyInstance(Subject.class.getClassLoader(),
//                new Class[]{Subject.class},
                RealSubject.class.getInterfaces(),
                new ProxyInvocationHandler(new RealSubject()));
        System.out.println("result:" + proxyClass);
        if (proxyClass == null) {
            System.out.println("hello,world");
        }
        if (proxyClass instanceof Subject) {
            ((Subject) proxyClass).opration();
        }
        if (proxyClass instanceof Subject2) {
            ((Subject2) proxyClass).opration2();
        }
    }

    private List<String> getList(){
        System.out.println("getList");
        List<String> list=new ArrayList<>();
        list.add("aaaa");
        list.add("bbbb");
        list.add("aaaa");
        list.add("bbbb");
        list.add("aaaa");
        list.add("bbbb");
        return list;
    }
    @Test
    public void testaa(){
//        for (int i=0;i<getList().size();i++){
//            System.out.println("abc");
//        }
        for(String s:getList()){
            System.out.println("abc");
//            System.out.println(s);
        }
    }
}
