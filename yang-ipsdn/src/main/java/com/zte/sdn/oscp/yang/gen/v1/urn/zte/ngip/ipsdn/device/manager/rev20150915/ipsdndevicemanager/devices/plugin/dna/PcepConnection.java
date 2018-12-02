package com.zte.sdn.oscp.yang.gen.v1.urn.zte.ngip.ipsdn.device.manager.rev20150915.ipsdndevicemanager.devices.plugin.dna;

import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev20100924.ietfinettypes.Ipv4Address;

@Table
public interface PcepConnection {

    /**
     * "=
                A ip address is specified for whitch D-controller
                is a PCE for added device .
            "
     * @return 
    */
    Ipv4Address getPcepPeerIp();

    /**
     * "=
                A ip address on added device ,whitch is a PCC.
                this device use the ip address connection to PCE
            "
     * @return 
    */
    Ipv4Address getPcepRouterId();

    String getParentPath();


    /**
     * "=
                A ip address is specified for whitch D-controller
                is a PCE for added device .
            "
     * @param pcepPeerIp 
    */
    void setPcepPeerIp(Ipv4Address pcepPeerIp);

    /**
     * "=
                A ip address on added device ,whitch is a PCC.
                this device use the ip address connection to PCE
            "
     * @param pcepRouterId 
    */
    void setPcepRouterId(Ipv4Address pcepRouterId);

    void setParentPath(String parentPath);


}

