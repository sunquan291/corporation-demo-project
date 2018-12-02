package com.zte.sdn.oscp.yang.gen.v1.ip.net.sub;

import com.zte.sdn.oscp.yang.gen.v1.ip.net.sub.subnet.My;
import com.zte.sdn.oscp.persistence.annotations.Table;

    //interface-declare.txt
@Table
public interface SubNet {

    //getter.txt
    String getParentPath();


    //setter.txt
    void setParentPath(String parentPath);


}

