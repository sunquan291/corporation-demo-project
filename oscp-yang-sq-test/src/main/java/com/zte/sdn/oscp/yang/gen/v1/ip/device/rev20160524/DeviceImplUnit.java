package com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20160524;

import com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20160524.device.ConnectPointImplUnit;
import java.util.Iterator;
import com.zte.sdn.oscp.persistence.annotation.Column;
import com.zte.sdn.oscp.persistence.annotation.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.core.transaction.domain.Unit;
import com.zte.sdn.oscp.core.transaction.domain.EntityUnit;
import java.util.Set;
import java.util.LinkedHashSet;
import com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20160524.device.ConnectPointUnit;

    //class-declare.txt
public class DeviceImplUnit extends EntityUnit implements DeviceUnit {

    //id.txt
    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer id;

    //parent-id.txt
    @Column
    private Integer parentId;

    //attribute.txt
    public static final String Manufacturer = "Manufacturer";
    @Column(displaySize = 10)
    private Unit<String> manufacturer;

    //attribute.txt
    public static final String HwVersion = "HwVersion";
    @Column(displaySize = 10)
    private Unit<String> hwVersion;

    //attribute.txt
    public static final String SwVersion = "SwVersion";
    @Column(displaySize = 10)
    private Unit<String> swVersion;

    //attribute.txt
    public static final String SerialNumber = "SerialNumber";
    @Column(displaySize = 10)
    private Unit<String> serialNumber;

    //attribute.txt
    public static final String Ip = "Ip";
    @Column(displaySize = 10)
    private Unit<String> ip;

    //attribute.txt
    private Set<Unit<String>> flows = new LinkedHashSet<Unit<String>>();
    @Column(displaySize = 1000)
    private Unit<String> flowsStr;

    //attribute.txt
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType =ConnectPointImplUnit.class, associateLoad = false, associateSave = false)
    private Set<ConnectPointUnit> connectPoint = new LinkedHashSet<ConnectPointUnit>();

    //attribute.txt
    public static final String ParentPath = "ParentPath";
    @Column(displaySize = 10)
    private String parentPath;


    //getter-impl.txt
    @Override
    public Unit<String> getManufacturer() {
        return this.manufacturer;
   }


    //getter-impl.txt
    @Override
    public Unit<String> getHwVersion() {
        return this.hwVersion;
   }


    //getter-impl.txt
    @Override
    public Unit<String> getSwVersion() {
        return this.swVersion;
   }


    //getter-impl.txt
    @Override
    public Unit<String> getSerialNumber() {
        return this.serialNumber;
   }


    //getter-impl.txt
    @Override
    public Unit<String> getIp() {
        return this.ip;
   }


    //getter-impl.txt
    @Override
    public Set<Unit<String>> getFlows() {
        return this.flows;
    }

    //getter-impl.txt
    @Override
    public Set<ConnectPointUnit> getConnectPoint() {
        return this.connectPoint;
    }

    //get-from-impl.txt
    @Override
    public ConnectPointUnit getFromConnectPointUnit(String key) {
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
    public void setManufacturer(Unit<String> manufacturer) {
        this.manufacturer = manufacturer;
    }

    //setter-impl.txt
    @Override
    public void setHwVersion(Unit<String> hwVersion) {
        this.hwVersion = hwVersion;
    }

    //setter-impl.txt
    @Override
    public void setSwVersion(Unit<String> swVersion) {
        this.swVersion = swVersion;
    }

    //setter-impl.txt
    @Override
    public void setSerialNumber(Unit<String> serialNumber) {
        this.serialNumber = serialNumber;
    }

    //setter-impl.txt
    @Override
    public void setIp(Unit<String> ip) {
        this.ip = ip;
    }

    //setter-impl.txt
    @Override
    public void setFlows(Set<Unit<String>> flows) {
        this.flows = flows;
    }

    //setter-impl.txt
    @Override
    public void setConnectPoint(Set<ConnectPointUnit> connectPoint) {
        this.connectPoint = connectPoint;
    }

    //setter-impl.txt
    @Override
    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }


    //addTo-impl.txt
    public void addToFlows(Unit<String> addTo) {
        flows.add(addTo);
    }

    //addTo-impl.txt
    public void addToConnectPointUnit(ConnectPointUnit addTo) {
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
    public void removeFromConnectPointUnit(String key) {
        Iterator<ConnectPointUnit> iterator = this.connectPoint.iterator();
        while (iterator.hasNext()) {
            ConnectPointUnit next = iterator.next();
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
        DeviceImplUnit other = (DeviceImplUnit) o;
        return
            Objects.equals(id,other.id)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

