package com.zte.sunquan.demo.security;

import org.junit.Test;

import java.net.URL;

/**
 * Created by 10184538 on 2017/6/29.
 */
public class AppPermissionTest {
    private void getXX() {
        SecurityManager safeManager = System.getSecurityManager();
        safeManager.checkPermission(new AppPermission("getXX", "read"));
        System.out.println("getXXX");
    }

    @Test
    public void test() {
        System.setSecurityManager(new SecurityManager());
        getXX();
    }

    @Test
    public void test2() {
        URL path=AppPermissionTest.class.getClassLoader().getResource("filepolicy.policy");
        System.setProperty("java.security.policy",path.getPath());
        System.setSecurityManager(new SecurityManager());
        Account account = new Account();
        System.out.println(account.getBalance());
        account.setBalance(29.0);
    }
}
