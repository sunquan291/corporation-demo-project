package com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.ipprefix.IpPrefixUnionImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.ipprefix.IpPrefixUnion;

public class IpPrefixImpl implements IpPrefix {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer id;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = IpPrefixUnionImpl.class)
    private IpPrefixUnion union = new IpPrefixUnionImpl();

    public static final String ParentPath = "ParentPath";
    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public IpPrefixUnion getUnion() {
        return this.union;
        }


    @Override
    public String getParentPath() {
        return this.parentPath;
        }



    @Override
    public void setUnion(IpPrefixUnion union) {
        this.union = union;
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
        IpPrefixImpl other = (IpPrefixImpl) o;
        return
            Objects.equals(id,other.id)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

