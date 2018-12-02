package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.controllers.controller.controllerdetail;

import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddress;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.IpAddressImpl;
import java.util.Set;
import java.util.LinkedHashSet;

public class RestconfConnectionImpl implements RestconfConnection {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    /**
     * "The ip of the connection."
    */
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = IpAddressImpl.class)
    private IpAddress restconfIp = new IpAddressImpl();

    /**
     * "The port of the connection."
    */
    @Column
    private Integer restconfPort;

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
     * "The messages of the notifications."
    */
    private Set<String> notification = new LinkedHashSet<String>();
    @Column(displaySize = 1000)
    private String notificationStr;

    @Column(displaySize = 10)
    private String parentPath;


    @Override
    public IpAddress getRestconfIp() {
        return this.restconfIp;
    }


    @Override
    public Integer getRestconfPort() {
        return this.restconfPort;
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
    public Set<String> getNotification() {
        this.notification.clear();
        for(String in:this.notificationStr.split(",")) {
            this.notification.add(in);
        }
        return this.notification;
    }

    @Override
    public String getParentPath() {
        return this.parentPath;
    }



    @Override
    public void setRestconfIp(IpAddress restconfIp) {
        this.restconfIp = restconfIp;
    }

    @Override
    public void setRestconfPort(Integer restconfPort) {
        this.restconfPort = restconfPort;
    }
    public void setRestconfPort(String restconfPort) {
        this.restconfPort = Integer.parseInt(restconfPort);
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
    public void setNotification(Set<String> notification) {
        this.notification = notification;
        this.notificationStr = notification.stream()
                .collect(java.util.stream.Collectors.joining(","));
                //.reduce((a,b)->a+","+b).get();
    }

    @Override
    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }


    public void addToNotification(String addTo) {
        notification.add(addTo);
         if(notificationStr==null || notificationStr.equals(""))
            notificationStr += addTo;
         else
            notificationStr += ","+addTo;
    }


    @Override
    public void removeFromNotification(String key) {
        notification.remove(key);
        setNotification(this.notification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primaryId,parentPath);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestconfConnectionImpl other = (RestconfConnectionImpl) o;
        return
            Objects.equals(primaryId,other.primaryId)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

