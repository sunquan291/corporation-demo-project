package com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20160524.device;

import com.zte.sdn.oscp.persistence.annotation.Column;
import com.zte.sdn.oscp.persistence.annotation.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20160524.device.system.LoginImpl;
import com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20160524.device.system.Login;

    //class-declare.txt
public class SystemImpl implements System {

    //id.txt
    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer id;

    //parent-id.txt
    @Column
    private Integer parentId;

    //attribute.txt
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = LoginImpl.class)
    private Login login = new LoginImpl();

    //attribute.txt
    public static final String ParentPath = "ParentPath";
    @Column(displaySize = 10)
    private String parentPath;


    //getter-impl.txt
    @Override
    public Login getLogin() {
        return this.login;
   }


    //getter-impl.txt
    @Override
    public String getParentPath() {
        return this.parentPath;
   }



    //setter-impl.txt
    @Override
    public void setLogin(Login login) {
        this.login = login;
    }

    //setter-impl.txt
    @Override
    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }


    //hash-code.txt
    @Override
    public int hashCode() {
        return Objects.hash(id,parentPath);
    }


    //equals.txt
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemImpl other = (SystemImpl) o;
        return
            Objects.equals(id,other.id)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

