package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getalldevice.getalldeviceoutput.deviceinfo;

import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddress;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.Snmpv3SecurityLevelImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.SnmpEncryProtocolTypeImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.SnmpAuthProtocolType;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.SnmpVersionTypeImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.SnmpAuthProtocolTypeImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddressImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.SnmpVersionType;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.SnmpEncryProtocolType;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.Snmpv3SecurityLevel;

public class SnmpConnectionImpl implements SnmpConnection {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "The ip of the connection."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = IpAddressImpl.class)
    private IpAddress snmpIp = new IpAddressImpl();

    /**
     * "The name of the connection."
    */
    @Column(displaySize = 10)
    private String name;

    /**
     * "The moc of the connection."
    */
    @Column(displaySize = 10)
    private String moc;

    /**
     * "The snmp-community of the connection."
    */
    @Column(displaySize = 10)
    private String snmpCommunity;

    /**
     * "The snmp-write-community of the connection."
    */
    @Column(displaySize = 10)
    private String snmpWriteCommunity;

    /**
     * "The snmp-version of the connection."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = SnmpVersionTypeImpl.class)
    private SnmpVersionType snmpVersion = new SnmpVersionTypeImpl();

    /**
     * "The user-name of the connection."
    */
    @Column(displaySize = 10)
    private String userName;

    /**
     * "The context-name of the connection."
    */
    @Column(displaySize = 10)
    private String contextName;

    /**
     * "The snmp-port of the connection."
    */
    @Column
    private Integer snmpPort;

    /**
     * "The timeout of the connection."
    */
    @Column
    private Integer timeout;

    /**
     * "The retry times of the connection."
    */
    @Column
    private Integer retry;

    /**
     * "The snmpv3-security-Level of the connection."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = Snmpv3SecurityLevelImpl.class)
    private Snmpv3SecurityLevel snmpv3SecurityLevel = new Snmpv3SecurityLevelImpl();

    /**
     * "The snmpv3-encry-protocol of the connection."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = SnmpEncryProtocolTypeImpl.class)
    private SnmpEncryProtocolType snmpv3EncryProtocol = new SnmpEncryProtocolTypeImpl();

    /**
     * "The snmpv3-encry-password of the connection."
    */
    @Column(displaySize = 10)
    private String snmpv3EncryPassword;

    /**
     * "The snmpv3-auth-protocol of the connection."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = SnmpAuthProtocolTypeImpl.class)
    private SnmpAuthProtocolType snmpv3AuthProtocol = new SnmpAuthProtocolTypeImpl();

    /**
     * "The snmpv3-auth-password of the connection."
    */
    @Column(displaySize = 10)
    private String snmpv3AuthPassword;

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public IpAddress getSnmpIp() {
        return this.snmpIp;
    }


    @Override
    public String getName() {
        return this.name;
    }


    @Override
    public String getMoc() {
        return this.moc;
    }


    @Override
    public String getSnmpCommunity() {
        return this.snmpCommunity;
    }


    @Override
    public String getSnmpWriteCommunity() {
        return this.snmpWriteCommunity;
    }


    @Override
    public SnmpVersionType getSnmpVersion() {
        return this.snmpVersion;
    }


    @Override
    public String getUserName() {
        return this.userName;
    }


    @Override
    public String getContextName() {
        return this.contextName;
    }


    @Override
    public Integer getSnmpPort() {
        return this.snmpPort;
    }


    @Override
    public Integer getTimeout() {
        return this.timeout;
    }


    @Override
    public Integer getRetry() {
        return this.retry;
    }


    @Override
    public Snmpv3SecurityLevel getSnmpv3SecurityLevel() {
        return this.snmpv3SecurityLevel;
    }


    @Override
    public SnmpEncryProtocolType getSnmpv3EncryProtocol() {
        return this.snmpv3EncryProtocol;
    }


    @Override
    public String getSnmpv3EncryPassword() {
        return this.snmpv3EncryPassword;
    }


    @Override
    public SnmpAuthProtocolType getSnmpv3AuthProtocol() {
        return this.snmpv3AuthProtocol;
    }


    @Override
    public String getSnmpv3AuthPassword() {
        return this.snmpv3AuthPassword;
    }


    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setSnmpIp(IpAddress snmpIp) {
        this.snmpIp = snmpIp;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setMoc(String moc) {
        this.moc = moc;
    }

    @Override
    public void setSnmpCommunity(String snmpCommunity) {
        this.snmpCommunity = snmpCommunity;
    }

    @Override
    public void setSnmpWriteCommunity(String snmpWriteCommunity) {
        this.snmpWriteCommunity = snmpWriteCommunity;
    }

    @Override
    public void setSnmpVersion(SnmpVersionType snmpVersion) {
        this.snmpVersion = snmpVersion;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void setContextName(String contextName) {
        this.contextName = contextName;
    }

    @Override
    public void setSnmpPort(Integer snmpPort) {
        this.snmpPort = snmpPort;
    }
    public void setSnmpPort(String snmpPort) {
        this.snmpPort = Integer.parseInt(snmpPort);
    }

    @Override
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
    public void setTimeout(String timeout) {
        this.timeout = Integer.parseInt(timeout);
    }

    @Override
    public void setRetry(Integer retry) {
        this.retry = retry;
    }
    public void setRetry(String retry) {
        this.retry = Integer.parseInt(retry);
    }

    @Override
    public void setSnmpv3SecurityLevel(Snmpv3SecurityLevel snmpv3SecurityLevel) {
        this.snmpv3SecurityLevel = snmpv3SecurityLevel;
    }

    @Override
    public void setSnmpv3EncryProtocol(SnmpEncryProtocolType snmpv3EncryProtocol) {
        this.snmpv3EncryProtocol = snmpv3EncryProtocol;
    }

    @Override
    public void setSnmpv3EncryPassword(String snmpv3EncryPassword) {
        this.snmpv3EncryPassword = snmpv3EncryPassword;
    }

    @Override
    public void setSnmpv3AuthProtocol(SnmpAuthProtocolType snmpv3AuthProtocol) {
        this.snmpv3AuthProtocol = snmpv3AuthProtocol;
    }

    @Override
    public void setSnmpv3AuthPassword(String snmpv3AuthPassword) {
        this.snmpv3AuthPassword = snmpv3AuthPassword;
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
        SnmpConnectionImpl other = (SnmpConnectionImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

