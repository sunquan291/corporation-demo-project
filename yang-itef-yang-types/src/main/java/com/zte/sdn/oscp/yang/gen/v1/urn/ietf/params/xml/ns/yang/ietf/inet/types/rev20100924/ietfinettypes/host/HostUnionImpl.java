package com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.host;

import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddress;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.DomainName;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddressImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.DomainNameImpl;

public class HostUnionImpl implements HostUnion {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer id;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = IpAddressImpl.class)
    private IpAddress ipAddress = new IpAddressImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = DomainNameImpl.class)
    private DomainName domainName = new DomainNameImpl();

    public static final String ParentPath = "ParentPath";
    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public IpAddress getIpAddress() {
        return this.ipAddress;
        }


    @Override
    public DomainName getDomainName() {
        return this.domainName;
        }


    @Override
    public String getParentPath() {
        return this.parentPath;
        }



    @Override
    public void setIpAddress(IpAddress ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public void setDomainName(DomainName domainName) {
        this.domainName = domainName;
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
        HostUnionImpl other = (HostUnionImpl) o;
        return
            Objects.equals(id,other.id)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

