package com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.ipprefix;

import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.Ipv6Prefix;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.Ipv4PrefixImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.Ipv6PrefixImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.Ipv4Prefix;

public class IpPrefixUnionImpl implements IpPrefixUnion {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer id;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = Ipv4PrefixImpl.class)
    private Ipv4Prefix ipv4Prefix = new Ipv4PrefixImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = Ipv6PrefixImpl.class)
    private Ipv6Prefix ipv6Prefix = new Ipv6PrefixImpl();

    public static final String ParentPath = "ParentPath";
    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public Ipv4Prefix getIpv4Prefix() {
        return this.ipv4Prefix;
        }


    @Override
    public Ipv6Prefix getIpv6Prefix() {
        return this.ipv6Prefix;
        }


    @Override
    public String getParentPath() {
        return this.parentPath;
        }



    @Override
    public void setIpv4Prefix(Ipv4Prefix ipv4Prefix) {
        this.ipv4Prefix = ipv4Prefix;
    }

    @Override
    public void setIpv6Prefix(Ipv6Prefix ipv6Prefix) {
        this.ipv6Prefix = ipv6Prefix;
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
        IpPrefixUnionImpl other = (IpPrefixUnionImpl) o;
        return
            Objects.equals(id,other.id)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

