package com.zte.sunquan.demo.security;

/**
 * Created by 10184538 on 2017/6/29.
 */
public class Account {
    private double balance;
    private AppPermission permission;

    public double getBalance() {
        SecurityManager safeManager = System.getSecurityManager();
        safeManager.checkPermission(new AppPermission("balance", "get"));
        return balance;
    }

    public void setBalance(double balance) {
        SecurityManager safeManager = System.getSecurityManager();
        safeManager.checkPermission(new AppPermission("balance", "set"));
        this.balance = balance;
    }

}
