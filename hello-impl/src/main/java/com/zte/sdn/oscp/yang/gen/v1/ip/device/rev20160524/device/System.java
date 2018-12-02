package com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20160524.device;

import com.zte.sdn.oscp.persistence.annotation.Table;
import com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20160524.device.system.Login;

    //interface-declare.txt
@Table
public interface System {

    //getter.txt
    Login getLogin();

    //getter.txt
    String getParentPath();


    //setter.txt
    void setLogin(Login login);

    //setter.txt
    void setParentPath(String parentPath);


}

