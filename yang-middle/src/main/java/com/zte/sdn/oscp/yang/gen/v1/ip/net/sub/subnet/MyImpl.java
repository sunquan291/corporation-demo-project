package com.zte.sdn.oscp.yang.gen.v1.ip.net.sub.subnet;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;

    //class-declare.txt
public class MyImpl implements My {

    //id.txt
    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer id;

    //parent-id.txt
    @Column
    private Integer parentId;

    //attribute.txt
    public static final String String = "String";
    @Column(displaySize = 10)
    private String string;

    //attribute.txt
    public static final String ParentPath = "ParentPath";
    @Column(displaySize = 10)
    private String parentPath;


    //getter-impl.txt
    @Override
    public String getString() {
        return this.string;
   }


    //getter-impl.txt
    @Override
    public String getParentPath() {
        return this.parentPath;
   }



    //setter-impl.txt
    @Override
    public void setString(String string) {
        this.string = string;
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
        MyImpl other = (MyImpl) o;
        return
            Objects.equals(id,other.id)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

