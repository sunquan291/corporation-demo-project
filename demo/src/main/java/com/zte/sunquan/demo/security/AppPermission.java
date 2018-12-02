package com.zte.sunquan.demo.security;

import java.io.Serializable;
import java.security.BasicPermission;
import java.security.Permission;

/**
 * Created by 10184538 on 2016/11/15.
 */
public class AppPermission extends BasicPermission {
    private String action;

    public AppPermission(String name) {
        super(name);
    }

    public AppPermission(String name, String action) {
        super(name, action);
        this.action = action;
    }

    @Override
    public boolean implies(Permission p) {

        if (p.getActions().equalsIgnoreCase(this.getActions()))
            return true;
        else
            return false;

//        //如果赋值权限为wirte，默认最高，直接通过
//        if (this.getActions().equalsIgnoreCase("write")) return true;
//            //要求权限必须相等（其实这里默认只有wirte/read两类动作权限）
//        else if (p.getActions().equalsIgnoreCase(this.getActions())) return true;
//        else return false;
    }

    @Override
    public String getActions() {
        return this.action;
    }
}
