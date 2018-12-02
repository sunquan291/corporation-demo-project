package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getnodenni;

import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getnodenni.getnodennioutput.nodenni.IpImpl;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getnodenni.getnodennioutput.nodenni.InterfaceImpl;
import com.zte.sdn.oscp.persistence.annotations.Column;
import com.zte.sdn.oscp.persistence.annotations.Relation;

import java.util.Objects;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getnodenni.getnodennioutput.NodeNni;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getnodenni.getnodennioutput.nodenni.Interface;
import com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.getnodenni.getnodennioutput.nodenni.Ip;

public class GetNodeNniOutput {

    @Column(isPrimaryKey = true, isAutoIncrement = true, index = 0)
    private Integer primaryId;

    @Column
    private Integer parentId;

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = IpImpl.class)
    private Ip Ip = new IpImpl();

    @Relation(parentFieldNames = {"id"}, childFieldNames = {"parentId"}, memberType = InterfaceImpl.class)
    private Interface oscpYangPrefixInterface = new InterfaceImpl();


    public Ip getIp() {
        return this.Ip;
    }


    public Interface getOscpYangPrefixInterface() {
        return this.oscpYangPrefixInterface;
    }



    public void setIp(Ip Ip) {
        this.Ip = Ip;
    }

    public void setOscpYangPrefixInterface(Interface oscpYangPrefixInterface) {
        this.oscpYangPrefixInterface = oscpYangPrefixInterface;
    }



}

