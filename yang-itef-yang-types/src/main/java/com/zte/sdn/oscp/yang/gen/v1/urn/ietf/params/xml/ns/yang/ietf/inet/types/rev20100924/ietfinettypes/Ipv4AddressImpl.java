package com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes;

import java.util.regex.Pattern;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.google.common.base.Preconditions;

public class Ipv4AddressImpl implements Ipv4Address {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer id;

    @Column
    private Integer parentId;

    public static final String String = "String";
    @Column(displaySize = 10)
    private String string;

    public static final String ParentPath = "ParentPath";
    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public String getString() {
        return this.string;
        }


    @Override
    public String getParentPath() {
        return this.parentPath;
        }



    @Override
    public void setString(String string) {
        //Preconditions.checkArgument(Pattern.matches("(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(%[\p{N}\p{L}]+)?",string));
        this.string = string;
    }

    @Override
    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id,parentPath);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ipv4AddressImpl other = (Ipv4AddressImpl) o;
        return
            Objects.equals(id,other.id)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

