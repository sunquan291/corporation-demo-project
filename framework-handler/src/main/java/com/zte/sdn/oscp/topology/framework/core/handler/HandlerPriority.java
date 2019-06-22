package com.zte.sdn.oscp.topology.framework.core.handler;

/**
 * Created by 00040506 on 2019/4/11.
 */
public class HandlerPriority {

    /**
     * node handler
     */
    public static int NODE_MD_OPTICAL_PHY = 9000;
    public static int NODE_LAYER_DEDUCE = 10010;
    public static int NODE_DELMSG_SENDTO_IPSDN = 9980;
    public static int NODE_CLOUD_SYNC = 10000;
    public static int NODE_STANDARD_STORE = 10000;
    public static int NODE_ADDMSG_SENDTO_IPSDN = 10044;
    public static int NODE_STANDARD_NOTIFY = 10050;
    public static int NODE_STANDARD_SYNC = 10555;
    public static int NODE_STANDARD_DEDUCE = 10060;
    public static int NODE_STANDARD_REBUILD = 10080;
    public static int NODE_SHIFT = 20050;

    /**
     * LTP handler
     */
    public static int LTP_MD_OPTICA_PHY = 9000;
    public static int LTP_STANDARD_STORE = 10000;
    public static int LTP_LAYER_DEDUCE = 10010;
    public static int LTP_STANDARD_NOTIFY = 10050;
    public static int LTP_STANDARD_REBUILD = 10090;
    public static int LTP_STANDARD_DEDUCE = 20000;
    public static int LTP_SHIFT = 20050;

    /**
     * Link handler
     */
    public static int LINK_SHIFT = 8050;
    public static int LINK_LAYER_DEDUCE = 10010;
    public static int LINK_STANDARD_BEFORE_SYNC = 9950;
    public static int LINK_STANDARD_AFTER_SYNC = 10030;
    public static int LINK_REVERSE_DELMSG_SENDTO_IPSDN = 9981;
    public static int LINK_DELMSG_SENDTO_IPSDN = 9980;
    public static int LINK_MD_OPTICAL_LAYER_FD = 9990;
    public static int LINK_STANDARD_STORE = 10000;
    public static int LINK_IGP_RING = 10000;
    public static int LINK_ADDMSG_SENDTO_IPSDN = 10044;
    public static int LINK_STANDARD_NOTIFY = 10050;
    public static int LINK_STANDARD_DEDUCE = 20000;

    /**
     * Group handler
     */
    public static int GROUP_STANDARD_STORE = 10000;
    public static int GROUP_STANDARD_NOTIFY = 10050;
    public static int GROUP_SHIFT = 20050;

    /**
     * Layer handler
     */
    public static int LAYER_STANDARD_STORE = 10000;
    public static int LAYER_STANDARD_NOTIFY = 10050;

    /**
     * Topology handler
     */
    public static int TOPOLOGY_STANDARD_STORE = 10000;
    public static int TOPOLOGY_STANDARD_NOTIFY = 10050;
    public static int TOPOLOGY_SHIFT = 20050;

    /**
     * CAPACITY handler
     */
    public static int CAPACITY_STANDARD_SYNC = 10000;
    public static int CAPACITY_STANDARD_STORE = 10000;
    public static int CAPACITY_STANDARD_NOTIFY = 10050;

    /**
     * STATE handler
     */
    public static int STATE_STANDARD_STORE = 10000;
    public static int STATE_STANDARD_NOTIFY = 10050;
    public static int STATE_SHIFT = 20050;

    /**
     * Performance handler
     */
    public static int PERFORMANCE_STANDARD_STORE = 10000;
    public static int PERFORMANCE_STANDARD_NOTIFY = 10050;

}
