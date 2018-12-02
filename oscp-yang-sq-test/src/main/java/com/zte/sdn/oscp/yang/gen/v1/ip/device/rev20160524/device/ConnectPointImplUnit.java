package com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20160524.device;

import com.zte.sdn.oscp.persistence.annotation.Column;
import com.zte.sdn.oscp.persistence.annotation.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.core.transaction.domain.Unit;
import com.zte.sdn.oscp.core.transaction.domain.EntityUnit;

    //class-declare.txt
public class ConnectPointImplUnit extends EntityUnit implements ConnectPointUnit {

    //id.txt
    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer id;

    //parent-id.txt
    @Column
    private Integer parentId;

    //attribute.txt
    public static final String NetworkId = "NetworkId";
    @Column(displaySize = 10)
    private Unit<String> networkId;

    //attribute.txt
    public static final String ParentPath = "ParentPath";
    @Column(displaySize = 10)
    private String parentPath;


    //getter-impl.txt
    @Override
    public Unit<String> getNetworkId() {
        return this.networkId;
   }


    //getter-impl.txt
    @Override
    public String getParentPath() {
        return this.parentPath;
   }



    //setter-impl.txt
    @Override
    public void setNetworkId(Unit<String> networkId) {
        this.networkId = networkId;
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
        ConnectPointImplUnit other = (ConnectPointImplUnit) o;
        return
            Objects.equals(id,other.id)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

