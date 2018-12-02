package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.controllers.controller.controllerdetail;

import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddress;
import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.SnmpAuthProtocolType;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.SnmpVersionType;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.SnmpEncryProtocolType;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.Snmpv3SecurityLevel;

@Table
public interface SnmpConnection {

    /**
     * "The ip of the connection."
     * @return 
    */
    IpAddress getSnmpIp();

    /**
     * "The name of the connection."
     * @return 
    */
    String getName();

    /**
     * "The moc of the connection."
     * @return 
    */
    String getMoc();

    /**
     * "The snmp-community of the connection."
     * @return 
    */
    String getSnmpCommunity();

    /**
     * "The snmp-write-community of the connection."
     * @return 
    */
    String getSnmpWriteCommunity();

    /**
     * "The snmp-version of the connection."
     * @return 
    */
    SnmpVersionType getSnmpVersion();

    /**
     * "The user-name of the connection."
     * @return 
    */
    String getUserName();

    /**
     * "The context-name of the connection."
     * @return 
    */
    String getContextName();

    /**
     * "The snmp-port of the connection."
     * @return 
    */
    Integer getSnmpPort();

    /**
     * "The timeout of the connection."
     * @return 
    */
    Integer getTimeout();

    /**
     * "The retry times of the connection."
     * @return 
    */
    Integer getRetry();

    /**
     * "The snmpv3-security-Level of the connection."
     * @return 
    */
    Snmpv3SecurityLevel getSnmpv3SecurityLevel();

    /**
     * "The snmpv3-encry-protocol of the connection."
     * @return 
    */
    SnmpEncryProtocolType getSnmpv3EncryProtocol();

    /**
     * "The snmpv3-encry-password of the connection."
     * @return 
    */
    String getSnmpv3EncryPassword();

    /**
     * "The snmpv3-auth-protocol of the connection."
     * @return 
    */
    SnmpAuthProtocolType getSnmpv3AuthProtocol();

    /**
     * "The snmpv3-auth-password of the connection."
     * @return 
    */
    String getSnmpv3AuthPassword();

    String getParentPath();


    /**
     * "The ip of the connection."
     * @param snmpIp 
    */
    void setSnmpIp(IpAddress snmpIp);

    /**
     * "The name of the connection."
     * @param name 
    */
    void setName(String name);

    /**
     * "The moc of the connection."
     * @param moc 
    */
    void setMoc(String moc);

    /**
     * "The snmp-community of the connection."
     * @param snmpCommunity 
    */
    void setSnmpCommunity(String snmpCommunity);

    /**
     * "The snmp-write-community of the connection."
     * @param snmpWriteCommunity 
    */
    void setSnmpWriteCommunity(String snmpWriteCommunity);

    /**
     * "The snmp-version of the connection."
     * @param snmpVersion 
    */
    void setSnmpVersion(SnmpVersionType snmpVersion);

    /**
     * "The user-name of the connection."
     * @param userName 
    */
    void setUserName(String userName);

    /**
     * "The context-name of the connection."
     * @param contextName 
    */
    void setContextName(String contextName);

    /**
     * "The snmp-port of the connection."
     * @param snmpPort 
    */
    void setSnmpPort(Integer snmpPort);

    /**
     * "The timeout of the connection."
     * @param timeout 
    */
    void setTimeout(Integer timeout);

    /**
     * "The retry times of the connection."
     * @param retry 
    */
    void setRetry(Integer retry);

    /**
     * "The snmpv3-security-Level of the connection."
     * @param snmpv3SecurityLevel 
    */
    void setSnmpv3SecurityLevel(Snmpv3SecurityLevel snmpv3SecurityLevel);

    /**
     * "The snmpv3-encry-protocol of the connection."
     * @param snmpv3EncryProtocol 
    */
    void setSnmpv3EncryProtocol(SnmpEncryProtocolType snmpv3EncryProtocol);

    /**
     * "The snmpv3-encry-password of the connection."
     * @param snmpv3EncryPassword 
    */
    void setSnmpv3EncryPassword(String snmpv3EncryPassword);

    /**
     * "The snmpv3-auth-protocol of the connection."
     * @param snmpv3AuthProtocol 
    */
    void setSnmpv3AuthProtocol(SnmpAuthProtocolType snmpv3AuthProtocol);

    /**
     * "The snmpv3-auth-password of the connection."
     * @param snmpv3AuthPassword 
    */
    void setSnmpv3AuthPassword(String snmpv3AuthPassword);

    void setParentPath(String parentPath);


}

