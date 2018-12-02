package com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20170324;

import com.zte.sdn.oscp.yang.gen.v1.ip.net.sub.subnet.My;
import com.zte.sdn.oscp.yang.gen.v1.ip.net.sub.subnet.MyImpl;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;

    //class-declare.txt
public class NetworkImpl implements Network {

    //id.txt
    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer id;

    //parent-id.txt
    @Column
    private Integer parentId;

    //attribute.txt
    public static final String YangVersion = "YangVersion";
    @Column(displaySize = 10)
    private String yangVersion = "1";

    //attribute.txt
    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = MyImpl.class)
    private My manufacturer = new MyImpl();

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
    private String ip = "127.0.0.0";

    //attribute.txt
    public static final String HardwareType = "HardwareType";
    @Column(displaySize = 10)
    private String hardwareType;

    //attribute.txt
    public static final String ParentPath = "ParentPath";
    @Column(displaySize = 10)
    private String parentPath;


    //getter-impl.txt
    @Override
    public My getManufacturer() {
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
    public String getHardwareType() {
        return this.hardwareType;
   }


    //getter-impl.txt
    @Override
    public String getParentPath() {
        return this.parentPath;
   }



    //setter-impl.txt
    @Override
    public void setManufacturer(My manufacturer) {
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
    public void setHardwareType(String hardwareType) {
        this.hardwareType = hardwareType;
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
        NetworkImpl other = (NetworkImpl) o;
        return
            Objects.equals(id,other.id)&&
            Objects.equals(parentPath,other.parentPath);
    }


}

