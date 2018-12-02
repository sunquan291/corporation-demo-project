package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.device;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.device.cliconnection.ConnectTypeEnum;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddress;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddressImpl;

public class CliConnectionImpl implements CliConnection {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "The name of the connection."
    */
    @Column(displaySize = 10)
    private String name;

    /**
     * "The ip of the connection."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = IpAddressImpl.class)
    private IpAddress ipAddress = new IpAddressImpl();

    /**
     * "The port of the connection."
    */
    @Column
    private Integer port;

    /**
     * "The user-name of the connection."
    */
    @Column(displaySize = 10)
    private String userName;

    /**
     * "The password of the connection."
    */
    @Column(displaySize = 10)
    private String password;

    /**
     * "The connect-type of the connection."
    */
    private ConnectTypeEnum connectType;
    private int connectTypeValue;

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public String getName() {
        return this.name;
    }


    @Override
    public IpAddress getIpAddress() {
        return this.ipAddress;
    }


    @Override
    public Integer getPort() {
        return this.port;
    }


    @Override
    public String getUserName() {
        return this.userName;
    }


    @Override
    public String getPassword() {
        return this.password;
    }


    @Override
    public ConnectTypeEnum getConnectType() {
        this.connectType =  ConnectTypeEnum.of(connectTypeValue);
        return this.connectType;
    }


    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setIpAddress(IpAddress ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public void setPort(Integer port) {
        this.port = port;
    }
    public void setPort(String port) {
        this.port = Integer.parseInt(port);
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setConnectType(ConnectTypeEnum connectType) {
        this.connectType = connectType;
        this.connectTypeValue =  connectType.getConnectTypeEnum();
    }

    @Override
    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }


    @Override
    public int hashCode() {
        return Objects.hash(primaryId,parentPath);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CliConnectionImpl other = (CliConnectionImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

