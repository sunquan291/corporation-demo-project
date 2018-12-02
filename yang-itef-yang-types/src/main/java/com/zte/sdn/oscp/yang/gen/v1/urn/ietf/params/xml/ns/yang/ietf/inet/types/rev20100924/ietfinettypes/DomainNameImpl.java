package com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes;

import java.util.regex.Pattern;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.persistence.validator.annotation.ExpressionLengthRestriction;
import com.google.common.base.Preconditions;

public class DomainNameImpl implements DomainName {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer id;

    @Column
    private Integer parentId;

    public static final String String = "String";
    @Column(displaySize = 10)
    @ExpressionLengthRestriction(rangeContent = "1..253")
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
        //Preconditions.checkArgument(Pattern.matches("((([a-zA-Z0-9_]([a-zA-Z0-9\-_]){0,61})?[a-zA-Z0-9]\.)*([a-zA-Z0-9_]([a-zA-Z0-9\-_]){0,61})?[a-zA-Z0-9]\.?)|\.",string));
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
        DomainNameImpl other = (DomainNameImpl) o;
        return
            Objects.equals(id,other.id)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

