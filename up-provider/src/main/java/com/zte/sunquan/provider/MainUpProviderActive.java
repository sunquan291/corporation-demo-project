package com.zte.sunquan.provider;

import com.zte.sunquan.model.User;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Created by 10184538 on 2018/3/15.
 */
public class MainUpProviderActive implements BundleActivator {
    public void start(BundleContext context) throws Exception {
        System.out.println("MainUpProviderActive start in up-provider");
        printClassLoader(User.class);
        System.out.println("--------");
        printClassLoader(MainUpProviderActive.class);
        System.out.println("******************");
        System.out.println("Thread Name:" + Thread.currentThread().getName());
        System.out.println("Thread classLoader:" + Thread.currentThread().getContextClassLoader());
        Class<?> aClass = Thread.currentThread().getContextClassLoader().loadClass("com.zte.sunquan.model.User");
        printClassLoader(aClass);
        Class<?> bclass=MainUpProviderActive.class.getClassLoader().loadClass("com.zte.sunquan.model.User");
        System.out.println("#####################");
        printClassLoader(bclass);
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("MainUpProviderActive stop in up-provider");
    }

    public void printClassLoader(Class cls) {
        ClassLoader loader = cls.getClassLoader();
        while (loader != null) {
            System.out.println(loader);
            loader = loader.getParent();
        }
        System.out.println(loader);
    }

    public void get(User user) {
        System.out.println("abc");
    }
}
