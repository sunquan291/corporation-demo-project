package com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20160524;

import com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20160524.device.ConnectPoint;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotation.Column;
import com.zte.sdn.oscp.persistence.annotation.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20160524.device.ConnectPointImpl;
import java.util.Set;
import java.util.LinkedHashSet;

    //class-declare.txt
public class DeviceImpl implements Device {

    //id.txt
    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer id;

    //parent-id.txt
    @Column
    private Integer parentId;

    //attribute.txt
    public static final String Manufacturer = "Manufacturer";
    @Column(displaySize = 10)
    private String manufacturer;

    //attribute.txt
    public static final String HwVersion = "HwVersion";
    @Column(displaySize = 10)
    private String hwVersion;

    //attribute.txt
    public static final String SwVersion = "SwVersion";
    @Column(displaySize = 10)
    private String swVersion;

    //attribute.txt
    public static final String SerialNumber = "SerialNumber";
    @Column(displaySize = 10)
    private String serialNumber;

    //attribute.txt
    public static final String Ip = "Ip";
    @Column(displaySize = 10)
    private String ip;

    //attribute.txt
    private Set<String> flows = new LinkedHashSet<String>();
    @Column(displaySize = 1000)
    private String flowsStr;

    //attribute.txt
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =ConnectPointImpl.class, associateLoad = false, associateSave = false)
    private Set<ConnectPoint> connectPoint = new LinkedHashSet<ConnectPoint>();

    //attribute.txt
    public static final String ParentPath = "ParentPath";
    @Column(displaySize = 10)
    private String parentPath;


    //getter-impl.txt
    @Override
    public String getManufacturer() {
        return this.manufacturer;
   }


    //getter-impl.txt
    @Override
    public String getHwVersion() {
        return this.hwVersion;
   }


    //getter-impl.txt
    @Override
    public String getSwVersion() {
        return this.swVersion;
   }


    //getter-impl.txt
    @Override
    public String getSerialNumber() {
        return this.serialNumber;
   }


    //getter-impl.txt
    @Override
    public String getIp() {
        return this.ip;
   }


    //getter-impl.txt
    @Override
    public Set<String> getFlows() {
        this.flows.clear();
        for(String in:this.flowsStr.split(",")) {
            this.flows.add(in);
        }
        return this.flows;
    }

    //getter-impl.txt
    @Override
    public Set<ConnectPoint> getConnectPoint() {
        return this.connectPoint;
    }

    //get-from-impl.txt
    @Override
    public ConnectPoint getFromConnectPoint(String key) {
        return this.connectPoint.stream().filter(value ->
                value.getNetworkId().equals(key))
                .findFirst().get();
    }
    //getter-impl.txt
    @Override
    public String getParentPath() {
        return this.parentPath;
   }



    //setter-impl.txt
    @Override
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    //setter-impl.txt
    @Override
    public void setHwVersion(String hwVersion) {
        this.hwVersion = hwVersion;
    }

    //setter-impl.txt
    @Override
    public void setSwVersion(String swVersion) {
        this.swVersion = swVersion;
    }

    //setter-impl.txt
    @Override
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    //setter-impl.txt
    @Override
    public void setIp(String ip) {
        this.ip = ip;
    }

    //setter-impl.txt
    @Override
    public void setFlows(Set<String> flows) {
        this.flows = flows;
        this.flowsStr = flows.stream()
                .collect(java.util.stream.Collectors.joining(","));
                //.reduce((a,b)->a+","+b).get();
    }

    //setter-impl.txt
    @Override
    public void setConnectPoint(Set<ConnectPoint> connectPoint) {
        this.connectPoint = connectPoint;
    }

    //setter-impl.txt
    @Override
    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }


    //addTo-impl.txt
    public void addToFlows(String addTo) {
        flows.add(addTo);
         if(flowsStr==null || flowsStr.equals(""))
            flowsStr += addTo;
         else
            flowsStr += ","+addTo;
    }

    //addTo-impl.txt
    public void addToConnectPoint(ConnectPoint addTo) {
        connectPoint.add(addTo);
    }


    //removeFromImpl.txt
    @Override
    public void removeFromFlows(String key) {
        flows.remove(key);
        setFlows(this.flows);
    }
    //removeFromImpl.txt
    @Override
    public void removeFromConnectPoint(String key) {
        Iterator<ConnectPoint> iterator = this.connectPoint.iterator();
        while (iterator.hasNext()) {
            ConnectPoint next = iterator.next();
            if (next.getNetworkId().equals(key))
                iterator.remove();
        }
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
        DeviceImpl other = (DeviceImpl) o;
        return
            Objects.equals(id,other.id)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

